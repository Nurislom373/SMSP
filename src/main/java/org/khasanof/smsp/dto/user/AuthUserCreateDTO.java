package org.khasanof.smsp.dto.user;

import jakarta.validation.constraints.*;
import lombok.*;
import org.khasanof.smsp.dto.BaseDTO;
import org.khasanof.smsp.enums.auth_user.AuthUserRole;
import org.khasanof.smsp.enums.auth_user.AuthUserStatus;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/23/2023
 * <br/>
 * Time: 10:16 AM
 * <br/>
 * Package: org.khasanof.smsp.dto.user
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserCreateDTO implements BaseDTO {

    @NotBlank
    @Size(min = 3, max = 120)
    private String firstName;
    @NotBlank
    @Size(min = 3, max = 120)
    private String lastName;
    @NotBlank
    @Email
    @Size(min = 7, max = 250)
    private String email;
    private MultipartFile file;
    @NotNull
    @Min(1)
    private Integer organizationId;
    @NotBlank
    @Size(min = 4, max = 250)
    private String password;
    @NotBlank
    @Size(min = 9, max = 14)
    private String phoneNumber;
    @NotNull
    private AuthUserRole role;
}
