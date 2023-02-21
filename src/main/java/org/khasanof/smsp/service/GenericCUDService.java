package org.khasanof.smsp.service;

import org.khasanof.smsp.dto.BaseDTO;
import org.khasanof.smsp.dto.GenericDTO;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 3:02 PM
 * <br/>
 * Package: org.khasanof.smsp.service
 */
public interface GenericCUDService<CD extends BaseDTO, UD extends GenericDTO, K extends Serializable> {

    void create(CD dto);

    void update(UD dto);

    void delete(K id);
}
