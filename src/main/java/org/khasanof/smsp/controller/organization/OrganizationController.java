package org.khasanof.smsp.controller.organization;

import jakarta.validation.Valid;
import org.khasanof.smsp.controller.AbstractController;
import org.khasanof.smsp.criteria.organization.OrganizationCriteria;
import org.khasanof.smsp.dto.organization.OrganizationCreateDTO;
import org.khasanof.smsp.dto.organization.OrganizationGetDTO;
import org.khasanof.smsp.dto.organization.OrganizationUpdateDTO;
import org.khasanof.smsp.service.organization.OrganizationService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 1:08 PM
 * <br/>
 * Package: org.khasanof.smsp.controller.organization
 */
@Controller
@RequestMapping(value = "/organizations/*")
public class OrganizationController extends AbstractController<OrganizationService> {

    public OrganizationController(OrganizationService service) {
        super(service);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView page(@Valid OrganizationCriteria criteria) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("organizations/organizations-basic");
        modelAndView.addObject("organizations", service.list(criteria));
        modelAndView.addObject("currentPage", criteria.getPage());
        modelAndView.addObject("elementSize", criteria.getSize());
        modelAndView.addObject("totalPages", service.totalPages());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute OrganizationCreateDTO dto) {
        service.create(dto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/organizations/");
        modelAndView.addObject("organizations", service.list(new OrganizationCriteria()));
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable Integer id) {
        service.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/organizations/");
        return modelAndView;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public OrganizationGetDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<OrganizationGetDTO> list() {
        return service.getAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute OrganizationUpdateDTO dto) {
        service.update(dto);
        return "redirect:/organizations/";
    }
}
