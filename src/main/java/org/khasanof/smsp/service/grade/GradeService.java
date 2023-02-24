package org.khasanof.smsp.service.grade;

import org.khasanof.smsp.criteria.grade.GradeCriteria;
import org.khasanof.smsp.dto.grade.GradeCreateDTO;
import org.khasanof.smsp.dto.grade.GradeGetDTO;
import org.khasanof.smsp.dto.grade.GradeUpdateDTO;
import org.khasanof.smsp.service.BaseService;
import org.khasanof.smsp.service.GenericCUDService;
import org.khasanof.smsp.service.GenericGLService;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/24/2023
 * <br/>
 * Time: 8:37 PM
 * <br/>
 * Package: org.khasanof.smsp.service.grade
 */
public interface GradeService extends GenericCUDService<GradeCreateDTO, GradeUpdateDTO, Integer>,
        GenericGLService<GradeGetDTO, Integer, GradeCriteria>, BaseService {

    int totalPages(GradeCriteria criteria);
}
