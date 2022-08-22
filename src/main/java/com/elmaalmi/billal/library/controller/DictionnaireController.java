package com.elmaalmi.billal.library.controller;

import com.elmaalmi.billal.library.model.Adherent;
import com.elmaalmi.billal.library.model.Dictionnaire;
import com.elmaalmi.billal.library.service.DictionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/document/dictionnaire")
public class DictionnaireController {
    @Autowired
    private DictionnaireService dictionnaireService;
    @GetMapping("/add")
    public String add(@ModelAttribute Dictionnaire dictionnaire){
        return "document/AddDictionnaire";
    }
    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Dictionnaire dictionnaire, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "document/AddDictionnaire";
        }
        dictionnaireService.save(dictionnaire);
        return "redirect:/document";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("dictionnaire",dictionnaireService.findById(id));
        return "document/AddDictionnaire";
    }
    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute Dictionnaire dictionnaire, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "document/AddDictionnaire";
        }
        dictionnaireService.update(dictionnaire);
        return "redirect:/document";
        //return "document/AddDictionnaire";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        dictionnaireService.delete(id);
        return "redirect:/adherent";
    }

}
