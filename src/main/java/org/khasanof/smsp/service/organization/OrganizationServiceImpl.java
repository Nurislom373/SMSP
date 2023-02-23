package org.khasanof.smsp.service.organization;

import org.khasanof.smsp.criteria.organization.OrganizationCriteria;
import org.khasanof.smsp.dto.cloudinary.CloudinaryGetDTO;
import org.khasanof.smsp.dto.organization.OrganizationCreateDTO;
import org.khasanof.smsp.dto.organization.OrganizationGetDTO;
import org.khasanof.smsp.dto.organization.OrganizationUpdateDTO;
import org.khasanof.smsp.entity.organization.OrganizationEntity;
import org.khasanof.smsp.exception.exceptions.NotFoundException;
import org.khasanof.smsp.mapper.organization.OrganizationMapper;
import org.khasanof.smsp.repository.organization.OrganizationRepository;
import org.khasanof.smsp.service.AbstractService;
import org.khasanof.smsp.service.cloudinary.CloudinaryService;
import org.khasanof.smsp.utils.BaseUtils;
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
        BaseUtils.validId(dto.getId());
        boolean empty = dto.getFile().isEmpty();
        CloudinaryGetDTO upload = null;

        if (!empty) {
            upload = cloudinaryService.upload(dto.getFile());
        }

        OrganizationEntity organization = repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("Organization Not Found"));

        if (Objects.nonNull(upload)) {
            organization.setLogoPath(upload.getUrl());
        }

        swapDtoToEntity(organization, dto);
        repository.save(organization);
    }

    @Override
    public void delete(Integer id) {
        BaseUtils.validId(id);
        if (!repository.existsById(id)) {
            throw new NotFoundException("Organization not found");
        }
        repository.deleteById(id);
    }

    @Override
    public OrganizationGetDTO get(Integer id) {
        BaseUtils.validId(id);
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

    @Override
    public OrganizationEntity getEntity(Integer id) {
        BaseUtils.validId(id);
        return repository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Organization Not Found");
                });
    }

    @Override
    public List<OrganizationGetDTO> getAll() {
        return repository.findAll().stream().map(this::setEntityToGD).toList();
    }

    private void swapDtoToEntity(OrganizationEntity entity, OrganizationUpdateDTO dto) {
        BeanUtils.copyProperties(dto, entity, "id", "file");
    }
}
