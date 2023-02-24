package org.khasanof.smsp.dto.grade;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.khasanof.smsp.dto.BaseDTO;
import org.khasanof.smsp.enums.grade.GradeStatus;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/24/2023
 * <br/>
 * Time: 8:28 PM
 * <br/>
 * Package: org.khasanof.smsp.dto.grade
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GradeCreateDTO implements BaseDTO {
    @NotBlank
    @Size(min = 2, max = 250)
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private GradeStatus status;
    @NotNull
    @Min(1)
    private Integer organizationId;
}
