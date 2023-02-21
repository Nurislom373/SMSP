package org.khasanof.smsp.criteria.organization;

import org.khasanof.smsp.criteria.GenericCriteria;
import org.springframework.data.domain.Sort;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 3:08 PM
 * <br/>
 * Package: org.khasanof.smsp.criteria.organization
 */
public class OrganizationCriteria extends GenericCriteria {

    public OrganizationCriteria(Integer size, Integer page, Sort.Direction direction) {
        super(size, page, direction);
    }

    public OrganizationCriteria() {
        super();
    }
}
