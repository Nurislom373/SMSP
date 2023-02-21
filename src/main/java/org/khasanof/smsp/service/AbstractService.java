package org.khasanof.smsp.service;

import lombok.RequiredArgsConstructor;
import org.khasanof.smsp.mapper.BaseMapper;
import org.khasanof.smsp.repository.BaseRepository;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 3:00 PM
 * <br/>
 * Package: org.khasanof.smsp.service
 */
@RequiredArgsConstructor
public class AbstractService<R extends BaseRepository, M extends BaseMapper> {
    protected final R repository;
    protected final M mapper;
}
