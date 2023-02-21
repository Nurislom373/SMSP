package org.khasanof.smsp.service.organization;

import org.khasanof.smsp.criteria.organization.OrganizationCriteria;
import org.khasanof.smsp.dto.cloudinary.CloudinaryGetDTO;
import org.khasanof.smsp.dto.organization.OrganizationCreateDTO;
import org.khasanof.smsp.dto.organization.OrganizationGetDTO;
import org.khasanof.smsp.dto.organization.OrganizationUpdateDTO;
import org.khasanof.smsp.entity.organization.OrganizationEntity;
import org.khasanof.smsp.mapper.organization.OrganizationMapper;
import org.khasanof.smsp.repository.organization.OrganizationRepository;
import org.khasanof.smsp.service.AbstractService;
import org.khasanof.smsp.service.cloudinary.CloudinaryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public OrganizationGetDTO get(Integer id) {
        return null;
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
}
