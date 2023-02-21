package org.khasanof.smsp.controller;

import lombok.RequiredArgsConstructor;
import org.khasanof.smsp.service.BaseService;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 2:55 PM
 * <br/>
 * Package: org.khasanof.smsp.controller
 */
@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService> {

    protected final S service;
}
