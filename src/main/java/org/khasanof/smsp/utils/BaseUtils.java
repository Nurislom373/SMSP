package org.khasanof.smsp.utils;

import org.khasanof.smsp.exception.exceptions.InvalidValidationException;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 11:28 PM
 * <br/>
 * Package: org.khasanof.smsp.utils
 */
public abstract class BaseUtils {

    public static void validId(Integer id) {
        if (id == null || id < 1) {
            throw new InvalidValidationException("Invalid id!");
        }
    }

}
