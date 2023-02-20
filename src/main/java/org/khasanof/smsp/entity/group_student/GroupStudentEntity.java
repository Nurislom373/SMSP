package org.khasanof.smsp.entity.group_student;

import jakarta.persistence.*;
import lombok.*;
import org.khasanof.smsp.entity.Auditable;
import org.khasanof.smsp.entity.auth_user.AuthUserEntity;
import org.khasanof.smsp.entity.group.GroupEntity;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 11:08 PM
 * <br/>
 * Package: org.khasanof.smsp.entity.group_student
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GroupStudentEntity extends GroupEntity {

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "group_student",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<AuthUserEntity> users;
}
