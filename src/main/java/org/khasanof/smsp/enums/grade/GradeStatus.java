package org.khasanof.smsp.enums.grade;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.khasanof.smsp.enums.organization.OrganizationStatusEnum;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/24/2023
 * <br/>
 * Time: 8:32 PM
 * <br/>
 * Package: org.khasanof.smsp.enums.grade
 */
@Getter
@RequiredArgsConstructor
public enum GradeStatus {
    ACTIVE("bg-label-primary"),
    LOCKED("bg-label-danger");
    private final String statusLabel;

    public static GradeStatus findAny() {
        return Arrays.asList(values())
                .get(new Random().nextInt(values().length));
    }
}
