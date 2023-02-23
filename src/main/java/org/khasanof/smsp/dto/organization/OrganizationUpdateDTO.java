package org.khasanof.smsp.dto.organization;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.smsp.dto.GenericDTO;
import org.khasanof.smsp.enums.organization.OrganizationStatusEnum;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 3:05 PM
 * <br/>
 * Package: org.khasanof.smsp.dto.organization
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationUpdateDTO extends GenericDTO {

    @NotBlank
    @Size(min = 3, max = 250)
    private String name;

    @NotBlank
    @Email
    private String email;

    private MultipartFile file;

    @NotNull
    private OrganizationStatusEnum status;
}
