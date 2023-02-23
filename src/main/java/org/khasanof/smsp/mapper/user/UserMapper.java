package org.khasanof.smsp.mapper.user;

import org.khasanof.smsp.dto.user.AuthUserCreateDTO;
import org.khasanof.smsp.dto.user.AuthUserDetailDTO;
import org.khasanof.smsp.dto.user.AuthUserGetDTO;
import org.khasanof.smsp.dto.user.AuthUserUpdateDTO;
import org.khasanof.smsp.entity.auth_user.AuthUserEntity;
import org.khasanof.smsp.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/23/2023
 * <br/>
 * Time: 10:24 AM
 * <br/>
 * Package: org.khasanof.smsp.mapper.user
 */
@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<AuthUserCreateDTO, AuthUserUpdateDTO, AuthUserGetDTO, AuthUserEntity> {

    AuthUserEntity toDetailDTO(AuthUserDetailDTO DTO);

    AuthUserDetailDTO fromDetailDTO(AuthUserEntity entity);

}
