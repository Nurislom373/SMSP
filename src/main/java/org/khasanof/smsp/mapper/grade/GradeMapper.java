package org.khasanof.smsp.mapper.grade;

import org.khasanof.smsp.dto.grade.GradeCreateDTO;
import org.khasanof.smsp.dto.grade.GradeGetDTO;
import org.khasanof.smsp.dto.grade.GradeUpdateDTO;
import org.khasanof.smsp.entity.grade.GradeEntity;
import org.khasanof.smsp.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/24/2023
 * <br/>
 * Time: 8:36 PM
 * <br/>
 * Package: org.khasanof.smsp.mapper.grade
 */
@Component
@Mapper(componentModel = "spring")
public interface GradeMapper extends GenericMapper<GradeCreateDTO, GradeUpdateDTO, GradeGetDTO, GradeEntity> {
}
