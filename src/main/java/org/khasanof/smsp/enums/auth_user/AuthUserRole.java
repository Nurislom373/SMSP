package org.khasanof.smsp.enums.auth_user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.khasanof.smsp.enums.organization.OrganizationStatusEnum;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/23/2023
 * <br/>
 * Time: 10:02 AM
 * <br/>
 * Package: org.khasanof.smsp.enums.auth_user
 */
@Getter
@RequiredArgsConstructor
public enum AuthUserRole {
    SUPER_ADMIN("bg-danger"),
    ADMIN("bg-warning"),
    TEACHER("bg-success");
    private final String label;

    public static AuthUserRole findAny() {
        return Arrays.asList(values())
                .get(new Random().nextInt(values().length));
    }
}
