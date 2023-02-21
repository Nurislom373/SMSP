package org.khasanof.smsp.dto.organization;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.khasanof.smsp.dto.GenericDTO;
import org.khasanof.smsp.enums.organization.OrganizationStatusEnum;

import java.time.LocalDateTime;

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
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationGetDTO extends GenericDTO {
    private String name;

    private String email;

    private String logoPath;

    private OrganizationStatusEnum status;

    private String statusLabel;

    private LocalDateTime createdAt;
}
