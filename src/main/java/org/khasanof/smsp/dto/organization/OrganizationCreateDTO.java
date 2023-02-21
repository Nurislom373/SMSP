package org.khasanof.smsp.dto.organization;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.khasanof.smsp.dto.BaseDTO;
import org.khasanof.smsp.dto.GenericDTO;
import org.khasanof.smsp.enums.organization.OrganizationStatusEnum;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 2:47 PM
 * <br/>
 * Package: org.khasanof.smsp.dto.organization
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationCreateDTO implements BaseDTO {

    @NotBlank
    @Size(min = 3, max = 250)
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private MultipartFile file;

    @NotNull
    private OrganizationStatusEnum status;
}
