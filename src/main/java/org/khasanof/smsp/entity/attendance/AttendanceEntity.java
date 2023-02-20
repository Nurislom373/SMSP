package org.khasanof.smsp.entity.attendance;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.khasanof.smsp.entity.Auditable;
import org.khasanof.smsp.entity.group.GroupEntity;
import org.khasanof.smsp.enums.attendance.AttendanceAtdEnum;
import org.khasanof.smsp.enums.attendance.AttendanceStatusEnum;

import java.sql.SQLType;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 11:15 PM
 * <br/>
 * Package: org.khasanof.smsp.entity.attendance
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attendance")
public class AttendanceEntity extends Auditable {

    @ManyToOne
    @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name = "GROUP_ID_FK"), nullable = false)
    private GroupEntity groupId;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private AttendanceStatusEnum status;

    @MapKeyColumn(name = "student_id", unique = true)
    @Column(name = "atd_json", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<Integer, AttendanceAtdEnum> atdJson;

}
