package org.khasanof.smsp.service.organization;

import org.khasanof.smsp.criteria.organization.OrganizationCriteria;
import org.khasanof.smsp.dto.cloudinary.CloudinaryGetDTO;
import org.khasanof.smsp.dto.organization.OrganizationCreateDTO;
import org.khasanof.smsp.dto.organization.OrganizationGetDTO;
import org.khasanof.smsp.dto.organization.OrganizationUpdateDTO;
import org.khasanof.smsp.entity.organization.OrganizationEntity;
import org.khasanof.smsp.exception.exceptions.InvalidValidationException;
import org.khasanof.smsp.exception.exceptions.NotFoundException;
import org.khasanof.smsp.mapper.organization.OrganizationMapper;
import org.khasanof.smsp.repository.organization.OrganizationRepository;
import org.khasanof.smsp.service.AbstractService;
import org.khasanof.smsp.service.cloudinary.CloudinaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 3:12 PM
 * <br/>
 * Package: org.khasanof.smsp.service.organization
 */
@Service
public class OrganizationServiceImpl extends AbstractService<OrganizationRepository, OrganizationMapper> implements OrganizationService {

    private final CloudinaryService cloudinaryService;

    public OrganizationServiceImpl(OrganizationRepository repository, OrganizationMapper mapper, CloudinaryService cloudinaryService) {
        super(repository, mapper);
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public void create(OrganizationCreateDTO dto) {
        CloudinaryGetDTO upload = cloudinaryService.upload(dto.getFile());
        boolean exists = repository.existsByEmail(dto.getEmail());
        if (exists) {
            throw new RuntimeException("This Email Organization Already Created!");
        }
        OrganizationEntity entity = mapper.toCreateDTO(dto);
        entity.setLogoPath(upload.getUrl());
        repository.save(entity);
    }

    @Override
    public void update(OrganizationUpdateDTO dto) {
        validOnId(dto.getId());

        boolean fileNonNull = Objects.nonNull(dto.getFile());
        CloudinaryGetDTO upload = null;

        if (fileNonNull) {
            upload = cloudinaryService.upload(dto.getFile());
        }

        OrganizationEntity organization = repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("Organization Not Found"));

        swapDtoToEntity(organization, dto, fileNonNull, upload.getUrl());
        repository.save(organization);
    }

    @Override
    public void delete(Integer id) {
        validOnId(id);
        if (!repository.existsById(id)) {
            throw new NotFoundException("Organization not found");
        }
        repository.deleteById(id);
    }

    @Override
    public OrganizationGetDTO get(Integer id) {
        validOnId(id);
        return mapper.fromGetDTO(
                repository.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("Organization not found");
                })
        );
    }

    @Override
    public List<OrganizationGetDTO> list(OrganizationCriteria criteria) {
        return repository.findAll(PageRequest.of(criteria.getPage(),
                        criteria.getSize()))
                .stream()
                .map(this::setEntityToGD)
                .toList();
    }

    private OrganizationGetDTO setEntityToGD(OrganizationEntity entity) {
        OrganizationGetDTO dto = mapper.fromGetDTO(entity);
        dto.setStatusLabel(entity.getStatus().getLabel());
        return dto;
    }

    @Override
    public int totalPages() {
        return repository.findAll(PageRequest.of(0, 10))
                .getTotalPages();
    }

    private void swapDtoToEntity(OrganizationEntity entity, OrganizationUpdateDTO dto, boolean fileNonNull, String url) {
        if (!fileNonNull) {
            BeanUtils.copyProperties(dto, entity, "id", "file");
        } else {
            entity.setLogoPath(url);
            BeanUtils.copyProperties(dto, entity, "id", "file");
        }
    }

    private void validOnId(Integer id) {
        if (id == null || id < 1) {
            throw new InvalidValidationException("Invalid id!");
        }
    }

    private void validOnUpdate(OrganizationEntity entity, OrganizationUpdateDTO dto) {
    }
}
