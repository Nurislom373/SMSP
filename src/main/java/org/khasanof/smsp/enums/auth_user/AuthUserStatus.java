package org.khasanof.smsp.enums.auth_user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.khasanof.smsp.enums.organization.OrganizationStatusEnum;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 3:57 PM
 * <br/>
 * Package: org.khasanof.smsp.enums.auth_user
 */
@Getter
@RequiredArgsConstructor
public enum AuthUserStatus {
    ACTIVE("bg-label-primary"),
    BLOCKED("bg-label-danger"),
    NO_ACTIVE("bg-label-warning");
    private final String label;

    public static AuthUserStatus findAny() {
        return Arrays.asList(values())
                .get(new Random().nextInt(values().length));
    }
}
