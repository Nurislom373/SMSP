package org.khasanof.smsp.service;

import org.khasanof.smsp.criteria.BaseCriteria;
import org.khasanof.smsp.dto.GenericDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 3:03 PM
 * <br/>
 * Package: org.khasanof.smsp.service
 */
public interface GenericGLService<GD extends GenericDTO, K extends Serializable, CR extends BaseCriteria> {
    GD get(K id);

    List<GD> list(CR criteria);
}
