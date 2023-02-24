package org.khasanof.smsp.controller.grades;

import jakarta.validation.Valid;
import org.khasanof.smsp.controller.AbstractController;
import org.khasanof.smsp.criteria.grade.GradeCriteria;
import org.khasanof.smsp.dto.grade.GradeCreateDTO;
import org.khasanof.smsp.dto.grade.GradeGetDTO;
import org.khasanof.smsp.dto.grade.GradeUpdateDTO;
import org.khasanof.smsp.enums.grade.GradeStatus;
import org.khasanof.smsp.service.grade.GradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/24/2023
 * <br/>
 * Time: 8:47 PM
 * <br/>
 * Package: org.khasanof.smsp.controller.grade
 */
@Controller
@RequestMapping(value = "/grades/*")
public class GradeController extends AbstractController<GradeService> {

    public GradeController(GradeService service) {
        super(service);
    }

    @GetMapping(value = "/")
    public ModelAndView page(@Valid GradeCriteria criteria) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("grades/grades-basic");
        modelAndView.addObject("grades", service.list(criteria));
        modelAndView.addObject("currentPage", criteria.getPage());
        modelAndView.addObject("elementSize", criteria.getSize());
        modelAndView.addObject("totalPages", service.totalPages(criteria));
        return modelAndView;
    }

    @PostMapping(value = "create")
    public String create(@Valid @ModelAttribute GradeCreateDTO dto) {
        service.create(dto);
        return "redirect:/grades/";
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<GradeGetDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>("Successfully deleted - Grade", HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "update")
    public String update(@Valid @ModelAttribute GradeUpdateDTO dto) {
        service.update(dto);
        return "redirect:/grades/";
    }
}
