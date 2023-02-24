package org.khasanof.smsp.dto.grade;

import lombok.*;
import org.khasanof.smsp.dto.GenericDTO;
import org.khasanof.smsp.enums.grade.GradeStatus;

import java.time.LocalDateTime;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/24/2023
 * <br/>
 * Time: 8:29 PM
 * <br/>
 * Package: org.khasanof.smsp.dto.grade
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GradeGetDTO extends GenericDTO {
    private String name;
    private String description;
    private GradeStatus status;
    private String statusLabel;
    private String organizationName;
    private LocalDateTime createdAt;
}
