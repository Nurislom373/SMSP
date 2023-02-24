package org.khasanof.smsp.entity.grade;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;
import org.khasanof.smsp.entity.Auditable;
import org.khasanof.smsp.entity.organization.OrganizationEntity;
import org.khasanof.smsp.enums.grade.GradeStatus;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 10:49 PM
 * <br/>
 * Package: org.khasanof.smsp.entity.grade
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "grade")
public class GradeEntity extends Auditable {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false, length = Length.LONG)
    private String description;

    @Enumerated
    @Basic(optional = false)
    private GradeStatus status;

    @ManyToOne
    @JoinColumn(name = "organization_id", foreignKey = @ForeignKey(name = "ORGANIZATION_ID_FK"))
    private OrganizationEntity organization;
}
