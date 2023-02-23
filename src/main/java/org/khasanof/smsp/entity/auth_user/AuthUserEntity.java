package org.khasanof.smsp.entity.auth_user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;
import org.khasanof.smsp.entity.Auditable;
import org.khasanof.smsp.entity.organization.OrganizationEntity;
import org.khasanof.smsp.enums.auth_user.AuthUserRole;
import org.khasanof.smsp.enums.auth_user.AuthUserStatus;
import org.khasanof.smsp.enums.language.LanguageEnum;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 3:52 PM
 * <br/>
 * Package: org.khasanof.smsp.entity.auth_user
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "auth_user")
public class AuthUserEntity extends Auditable {

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false, length = Length.LONG16)
    private String password;

    @Enumerated(EnumType.STRING)
    private AuthUserStatus status;

    @Enumerated
    private AuthUserRole role;

    @Enumerated(EnumType.STRING)
    private LanguageEnum language;

    @Column(name = "first_name", nullable = false, length = 120)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 120)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "image_path", length = Length.LONG16)
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "organization_id", foreignKey = @ForeignKey(name = "ORGANIZATION_ID_FK"))
    private OrganizationEntity organization;
}
