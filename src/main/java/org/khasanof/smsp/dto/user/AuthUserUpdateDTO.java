package org.khasanof.smsp.dto.user;

import jakarta.validation.constraints.*;
import lombok.*;
import org.khasanof.smsp.dto.GenericDTO;
import org.khasanof.smsp.enums.auth_user.AuthUserRole;
import org.khasanof.smsp.enums.auth_user.AuthUserStatus;
import org.khasanof.smsp.enums.language.LanguageEnum;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/23/2023
 * <br/>
 * Time: 10:22 AM
 * <br/>
 * Package: org.khasanof.smsp.dto.user
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserUpdateDTO extends GenericDTO {
    @NotBlank
    @Size(min = 3, max = 120)
    private String firstName;
    @NotBlank
    @Size(min = 3, max = 120)
    private String lastName;
    @NotNull
    @Min(1)
    private Integer organizationId;
    @NotBlank
    @Email
    @Size(min = 7, max = 250)
    private String email;
    private MultipartFile file;
    @NotBlank
    @Size(min = 9, max = 14)
    private String phoneNumber;
    @NotNull
    private AuthUserRole role;
    @NotNull
    private AuthUserStatus status;
    @NotNull
    private LanguageEnum language;
}
