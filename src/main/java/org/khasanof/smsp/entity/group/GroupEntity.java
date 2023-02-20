package org.khasanof.smsp.entity.group;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;
import org.khasanof.smsp.entity.Auditable;
import org.khasanof.smsp.entity.auth_user.AuthUserEntity;
import org.khasanof.smsp.entity.grade.GradeEntity;
import org.khasanof.smsp.enums.group.GroupStatusEnum;

import java.time.LocalDateTime;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 10:50 PM
 * <br/>
 * Package: org.khasanof.smsp.entity.group
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GroupEntity extends Auditable {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "grade_id", foreignKey = @ForeignKey(name = "GRADE_ID_FK"), nullable = false)
    private GradeEntity gradeId;

    @Enumerated(EnumType.STRING)
    private GroupStatusEnum status;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey(name = "TEACHER_ID_FK"), nullable = false)
    private AuthUserEntity teacherId;

    @Column(name = "overview", length = Length.LONG)
    private String overview;
}
