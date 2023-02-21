package org.khasanof.smsp.mapper.organization;

import org.khasanof.smsp.dto.GenericDTO;
import org.khasanof.smsp.dto.organization.OrganizationCreateDTO;
import org.khasanof.smsp.dto.organization.OrganizationGetDTO;
import org.khasanof.smsp.dto.organization.OrganizationUpdateDTO;
import org.khasanof.smsp.entity.organization.OrganizationEntity;
import org.khasanof.smsp.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 3:07 PM
 * <br/>
 * Package: org.khasanof.smsp.mapper.organization
 */
@Component
@Mapper(componentModel = "spring")
public interface OrganizationMapper extends GenericMapper<OrganizationCreateDTO, OrganizationUpdateDTO,
        OrganizationGetDTO, OrganizationEntity> {
}
