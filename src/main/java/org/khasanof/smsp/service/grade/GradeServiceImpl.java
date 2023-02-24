package org.khasanof.smsp.service.grade;

import org.khasanof.smsp.criteria.grade.GradeCriteria;
import org.khasanof.smsp.dto.grade.GradeCreateDTO;
import org.khasanof.smsp.dto.grade.GradeGetDTO;
import org.khasanof.smsp.dto.grade.GradeUpdateDTO;
import org.khasanof.smsp.entity.grade.GradeEntity;
import org.khasanof.smsp.entity.organization.OrganizationEntity;
import org.khasanof.smsp.exception.exceptions.NotFoundException;
import org.khasanof.smsp.mapper.grade.GradeMapper;
import org.khasanof.smsp.repository.grade.GradeRepository;
import org.khasanof.smsp.service.AbstractService;
import org.khasanof.smsp.service.organization.OrganizationService;
import org.khasanof.smsp.utils.BaseUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/24/2023
 * <br/>
 * Time: 8:39 PM
 * <br/>
 * Package: org.khasanof.smsp.service.grade
 */
@Service
public class GradeServiceImpl extends AbstractService<GradeRepository, GradeMapper> implements GradeService {

    private final OrganizationService organizationService;

    public GradeServiceImpl(GradeRepository repository, GradeMapper mapper, OrganizationService organizationService) {
        super(repository, mapper);
        this.organizationService = organizationService;
    }

    @Override
    public void create(GradeCreateDTO dto) {
        OrganizationEntity entity = organizationService.getEntity(dto.getOrganizationId());
        GradeEntity gradeEntity = mapper.toCreateDTO(dto);
        gradeEntity.setOrganization(entity);
        repository.save(gradeEntity);
    }

    @Override
    public void update(GradeUpdateDTO dto) {
        GradeEntity entity = repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("Grade Not Found"));

        if (entity.getOrganization().getId().equals(dto.getOrganizationId())) {
            OrganizationEntity organization = organizationService.getEntity(dto.getOrganizationId());
            entity.setOrganization(organization);
        }

        BeanUtils.copyProperties(dto, entity, "id");
        repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        BaseUtils.validId(id);
        if (!repository.existsById(id)) {
            throw new NotFoundException("Grade Not Found");
        }
        repository.deleteById(id);
    }

    @Override
    public GradeGetDTO get(Integer id) {
        BaseUtils.validId(id);
        return swapGToEntity(
                repository.findById(id)
                        .orElseThrow(() -> {
                            throw new NotFoundException("Grade Not Found");
                        })
        );
    }

    @Override
    public List<GradeGetDTO> list(GradeCriteria criteria) {
        return repository.findAll(PageRequest.of(criteria.getPage(),
                        criteria.getSize()))
                .stream()
                .map(this::swapGToEntity)
                .toList();
    }

    private GradeGetDTO swapGToEntity(GradeEntity entity) {
        GradeGetDTO dto = mapper.fromGetDTO(entity);
        dto.setOrganizationName(entity.getOrganization().getName());
        dto.setStatusLabel(entity.getStatus().getStatusLabel());
        return dto;
    }

    @Override
    public int totalPages(GradeCriteria criteria) {
        return repository.findAll(PageRequest.of(criteria.getPage(),
                criteria.getSize())).getTotalPages();
    }
}
