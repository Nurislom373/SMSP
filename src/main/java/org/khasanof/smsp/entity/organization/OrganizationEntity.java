package org.khasanof.smsp.entity.organization;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;
import org.khasanof.smsp.entity.Auditable;
import org.khasanof.smsp.enums.organization.OrganizationStatusEnum;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 10:45 PM
 * <br/>
 * Package: org.khasanof.smsp.entity.organization
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organization")
public class OrganizationEntity extends Auditable {

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private OrganizationStatusEnum status;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "logo_path", length = Length.LONG16)
    private String logoPath;
}
