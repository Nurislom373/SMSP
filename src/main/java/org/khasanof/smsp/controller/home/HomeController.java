package org.khasanof.smsp.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/20/2023
 * <br/>
 * Time: 10:28 PM
 * <br/>
 * Package: org.khasanof.smsp.controller.home
 */
@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String homePage() {
        return "home/index";
    }
}
