package org.khasanof.smsp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/23/2023
 * <br/>
 * Time: 9:57 AM
 * <br/>
 * Package: org.khasanof.smsp.controller.users
 */
@Controller
@RequestMapping(value = "/users/*")
public class UserController {

    @GetMapping
    public ModelAndView usersPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/users-basic");
        return modelAndView;
    }
}
