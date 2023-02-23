package org.khasanof.smsp.dto.user;

import lombok.*;
import org.khasanof.smsp.dto.GenericDTO;
import org.khasanof.smsp.enums.auth_user.AuthUserStatus;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/23/2023
 * <br/>
 * Time: 10:15 AM
 * <br/>
 * Package: org.khasanof.smsp.dto.user
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserDetailDTO extends GenericDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String imagePath;
    private String language;
    private String phoneNumber;
    private String role;
    private String organizationName;
    private AuthUserStatus status;
}
