package org.khasanof.smsp.service.user;

import org.khasanof.smsp.criteria.user.AuthUserCriteria;
import org.khasanof.smsp.dto.cloudinary.CloudinaryGetDTO;
import org.khasanof.smsp.dto.organization.OrganizationGetDTO;
import org.khasanof.smsp.dto.user.AuthUserCreateDTO;
import org.khasanof.smsp.dto.user.AuthUserDetailDTO;
import org.khasanof.smsp.dto.user.AuthUserGetDTO;
import org.khasanof.smsp.dto.user.AuthUserUpdateDTO;
import org.khasanof.smsp.entity.auth_user.AuthUserEntity;
import org.khasanof.smsp.entity.organization.OrganizationEntity;
import org.khasanof.smsp.enums.auth_user.AuthUserStatus;
import org.khasanof.smsp.exception.exceptions.NotFoundException;
import org.khasanof.smsp.mapper.user.AuthUserMapper;
import org.khasanof.smsp.repository.user.AuthUserRepository;
import org.khasanof.smsp.service.AbstractService;
import org.khasanof.smsp.service.cloudinary.CloudinaryService;
import org.khasanof.smsp.service.organization.OrganizationService;
import org.khasanof.smsp.utils.BaseUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/23/2023
 * <br/>
 * Time: 12:39 PM
 * <br/>
 * Package: org.khasanof.smsp.service.user
 */
@Service
public class AuthUserServiceImpl extends AbstractService<AuthUserRepository, AuthUserMapper> implements AuthUserService {

    private final PasswordEncoder passwordEncoder;
    private final CloudinaryService cloudinaryService;
    private final OrganizationService organizationService;

    public AuthUserServiceImpl(AuthUserRepository repository, AuthUserMapper mapper, PasswordEncoder passwordEncoder, CloudinaryService cloudinaryService, OrganizationService organizationService) {
        super(repository, mapper);
        this.passwordEncoder = passwordEncoder;
        this.cloudinaryService = cloudinaryService;
        this.organizationService = organizationService;
    }

    @Override
    public void create(AuthUserCreateDTO dto) {
        CloudinaryGetDTO cloudinaryGetDTO = null;

        if (!dto.getFile().isEmpty()) {
            cloudinaryGetDTO = cloudinaryService.upload(dto.getFile());
        }
        OrganizationEntity entity = organizationService.getEntity(dto.getOrganizationId());

        AuthUserEntity userEntity = mapper.toCreateDTO(dto);
        userEntity.setLanguage(dto.getLanguage());
        userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
        userEntity.setOrganization(entity);
        userEntity.setStatus(AuthUserStatus.NO_ACTIVE);

        if (Objects.nonNull(cloudinaryGetDTO)) {
            userEntity.setImagePath(cloudinaryGetDTO.getUrl());
        }
        repository.save(userEntity);
    }

    @Override
    public void update(AuthUserUpdateDTO dto) {
        BaseUtils.validId(dto.getId());
        CloudinaryGetDTO cloudinaryGetDTO = null;

        AuthUserEntity entity = repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("AuthUser Not Found"));

        if (!entity.getOrganization().getId().equals(dto.getId())) {
            OrganizationEntity organization = organizationService.getEntity(dto.getId());
            entity.setOrganization(organization);
        }
        if (!dto.getFile().isEmpty()) {
            cloudinaryGetDTO = cloudinaryService.upload(dto.getFile());
        }
        swapDtoEntity(dto, entity);
        if (Objects.nonNull(cloudinaryGetDTO)) {
            entity.setImagePath(cloudinaryGetDTO.getUrl());
        }
        repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        BaseUtils.validId(id);
        if (!repository.existsById(id)) {
            throw new NotFoundException("AuthUser Not Found");
        }
        repository.deleteById(id);
    }

    @Override
    public AuthUserGetDTO get(Integer id) {
        BaseUtils.validId(id);
        return swapEntityToGDTO(
                repository.findById(id)
                        .orElseThrow(() -> new NotFoundException("AuthUser Not Found")));
    }

    @Override
    public List<AuthUserGetDTO> list(AuthUserCriteria criteria) {
        return repository.findAll(PageRequest.of(criteria.getPage(),
                        criteria.getSize()))
                .stream()
                .map(this::swapEntityToGDTO)
                .toList();
    }

    @Override
    public int totalPages() {
        return repository.findAll(PageRequest.of(0, 10))
                .getTotalPages();
    }

    @Override
    public AuthUserDetailDTO detail(Integer id) {
        return null;
    }

    private AuthUserGetDTO swapEntityToGDTO(AuthUserEntity entity) {
        AuthUserGetDTO authUserGetDTO = mapper.fromGetDTO(entity);
        authUserGetDTO.setOrganizationName(entity.getOrganization().getName());
        authUserGetDTO.setRoleLabel(entity.getRole().getLabel());
        authUserGetDTO.setStatusLabel(entity.getStatus().getLabel());
        authUserGetDTO.setCreatedAt(entity.getCreatedAt());
        return authUserGetDTO;
    }

    private void swapDtoEntity(AuthUserUpdateDTO dto, AuthUserEntity entity) {
        BeanUtils.copyProperties(dto, entity, "id");
    }
}
