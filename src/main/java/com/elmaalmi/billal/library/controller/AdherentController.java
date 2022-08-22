package com.elmaalmi.billal.library.controller;

import com.elmaalmi.billal.library.model.Adherent;
import com.elmaalmi.billal.library.service.AdherentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/adherent")
public class AdherentController {
    @Autowired
    private AdherentService adherentService;

    @GetMapping
    public String index(Model modelAndView){
        System.out.println(adherentService.findAll().size());
        modelAndView.addAttribute("adherents",adherentService.findAll());
        return "adherent/index";
    }
    @GetMapping("/add")
    public String add(@ModelAttribute Adherent adherent){
        return "adherent/add";
    }
    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Adherent adherent, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "adherent/add";
        }
        adherentService.save(adherent);
        return "redirect:/adherent";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id,Model model){
        model.addAttribute("adherent",adherentService.findById(id));
        return "adherent/add";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        adherentService.delete(id);
        return "redirect:/adherent";
    }


}
