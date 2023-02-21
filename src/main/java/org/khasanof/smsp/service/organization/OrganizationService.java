package org.khasanof.smsp.service.organization;

import org.khasanof.smsp.criteria.organization.OrganizationCriteria;
import org.khasanof.smsp.dto.organization.OrganizationCreateDTO;
import org.khasanof.smsp.dto.organization.OrganizationGetDTO;
import org.khasanof.smsp.dto.organization.OrganizationUpdateDTO;
import org.khasanof.smsp.service.BaseService;
import org.khasanof.smsp.service.GenericCUDService;
import org.khasanof.smsp.service.GenericGLService;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 3:08 PM
 * <br/>
 * Package: org.khasanof.smsp.service.organization
 */
public interface OrganizationService extends GenericCUDService<OrganizationCreateDTO, OrganizationUpdateDTO, Integer>,
        GenericGLService<OrganizationGetDTO, Integer, OrganizationCriteria>, BaseService {

    int totalPages();

}
