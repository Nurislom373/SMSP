package org.khasanof.smsp.mapper;

import org.khasanof.smsp.dto.BaseDTO;
import org.khasanof.smsp.dto.GenericDTO;
import org.khasanof.smsp.entity.BaseEntity;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 11:31 PM
 * <br/>
 * Package: org.khasanof.smsp.mapper
 */
public interface GenericMapper<
        CD extends BaseDTO,
        UD extends GenericDTO,
        GD extends GenericDTO,
        DD extends GenericDTO,
        E extends BaseEntity> extends BaseMapper {
    E toCreateDTO(CD DTO);

    CD fromCreateDTO(E entity);

    E toUpdateDTO(UD DTO);

    UD fromUpdateDTO(E entity);

    E toGetDTO(GD DTO);

    GD fromGetDTO(E entity);

    List<E> toGetListDTO(List<GD> DTO);

    List<GD> fromGetListDTO(List<E> entity);

    E toDetailDTO(DD DTO);

    DD fromDetailDTO(E entity);
}
