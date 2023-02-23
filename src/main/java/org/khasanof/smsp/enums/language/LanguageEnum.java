package org.khasanof.smsp.enums.language;

import org.khasanof.smsp.enums.organization.OrganizationStatusEnum;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 4:00 PM
 * <br/>
 * Package: org.khasanof.smsp.enums.language
 */
public enum LanguageEnum {
    UZBEK,
    RUSSIA,
    ENGLISH;

    public static LanguageEnum findAny() {
        return Arrays.asList(values())
                .get(new Random().nextInt(values().length));
    }
}
