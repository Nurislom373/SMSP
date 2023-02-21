package org.khasanof.smsp.enums.organization;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 10:46 PM
 * <br/>
 * Package: org.khasanof.smsp.enums.organization
 */
@Getter
@RequiredArgsConstructor
public enum OrganizationStatusEnum {

    ACTIVE("bg-label-primary"),
    BLOCKED("bg-label-danger");

    private final String label;

    public static OrganizationStatusEnum findAny() {
        return Arrays.asList(values())
                .get(new Random().nextInt(values().length));
    }



}
