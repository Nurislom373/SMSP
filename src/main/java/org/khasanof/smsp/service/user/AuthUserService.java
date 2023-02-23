package org.khasanof.smsp.service.user;

import org.khasanof.smsp.criteria.user.AuthUserCriteria;
import org.khasanof.smsp.dto.user.AuthUserCreateDTO;
import org.khasanof.smsp.dto.user.AuthUserDetailDTO;
import org.khasanof.smsp.dto.user.AuthUserGetDTO;
import org.khasanof.smsp.dto.user.AuthUserUpdateDTO;
import org.khasanof.smsp.service.BaseService;
import org.khasanof.smsp.service.GenericCUDService;
import org.khasanof.smsp.service.GenericGLService;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/23/2023
 * <br/>
 * Time: 10:29 AM
 * <br/>
 * Package: org.khasanof.smsp.service
 */
public interface AuthUserService extends GenericCUDService<AuthUserCreateDTO, AuthUserUpdateDTO, Integer>,
        GenericGLService<AuthUserGetDTO, Integer, AuthUserCriteria>, BaseService {

    int totalPages();

    AuthUserDetailDTO detail(Integer id);

}
