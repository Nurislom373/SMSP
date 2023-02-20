package org.khasanof.smsp.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 10:27 PM
 * <br/>
 * Package: org.khasanof.smsp.controller.auth
 */
@Controller
public class AuthController {

    @GetMapping(value = "/auth/login")
    public String loginPage() {
        return "auth/Login";
    }

}
