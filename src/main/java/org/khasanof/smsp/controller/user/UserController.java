package org.khasanof.smsp.controller.user;

import jakarta.validation.Valid;
import org.khasanof.smsp.controller.AbstractController;
import org.khasanof.smsp.criteria.user.AuthUserCriteria;
import org.khasanof.smsp.dto.user.AuthUserCreateDTO;
import org.khasanof.smsp.dto.user.AuthUserUpdateDTO;
import org.khasanof.smsp.service.user.AuthUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
public class UserController extends AbstractController<AuthUserService> {

    public UserController(AuthUserService service) {
        super(service);
    }

    @GetMapping
    public ModelAndView usersPage(@Valid AuthUserCriteria criteria) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", service.list(criteria));
        modelAndView.addObject("currentPage", criteria.getPage());
        modelAndView.addObject("elementSize", criteria.getSize());
        modelAndView.addObject("totalPages", service.totalPages());
        modelAndView.setViewName("users/users-basic");
        return modelAndView;
    }

    @PostMapping(value = "create")
    public String create(@Valid @ModelAttribute AuthUserCreateDTO dto) {
        service.create(dto);
        return "redirect:/users/";
    }

    @DeleteMapping(value = "delete/{id}")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>("Successfully Deleted - AuthUser", HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "update")
    public String update(@Valid @ModelAttribute AuthUserUpdateDTO dto) {
        service.update(dto);
        return "redirect:/users/";
    }
}
