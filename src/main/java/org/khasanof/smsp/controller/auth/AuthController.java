package org.khasanof.smsp.controller.auth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping(value = "/auth/*")
public class AuthController {

    @GetMapping(value = "login")
    public String loginPage() {
        return "auth/auth-login-basic";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "settings")
    public String settingsPage() {
        return "auth/account-settings";
    }

}
