package org.khasanof.smsp.repository.grade;

import org.khasanof.smsp.entity.grade.GradeEntity;
import org.khasanof.smsp.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/24/2023
 * <br/>
 * Time: 8:37 PM
 * <br/>
 * Package: org.khasanof.smsp.repository.grade
 */
@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Integer>, BaseRepository {
}
