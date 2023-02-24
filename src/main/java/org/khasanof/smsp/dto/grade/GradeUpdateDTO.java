package org.khasanof.smsp.dto.grade;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Length;
import org.khasanof.smsp.dto.GenericDTO;
import org.khasanof.smsp.enums.grade.GradeStatus;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/24/2023
 * <br/>
 * Time: 8:35 PM
 * <br/>
 * Package: org.khasanof.smsp.dto.grade
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GradeUpdateDTO extends GenericDTO {
    @NotBlank
    @Size(min = 2, max = 250)
    private String name;
    @NotBlank
    @Size(min = 2, max = Length.LONG)
    private String description;
    @NotNull
    private GradeStatus status;
    @NotNull
    @Min(1)
    private Integer organizationId;
}
