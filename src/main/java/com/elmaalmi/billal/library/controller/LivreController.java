package com.elmaalmi.billal.library.controller;

import com.elmaalmi.billal.library.dal.DictionnaireRepository;
import com.elmaalmi.billal.library.dal.LivreRepository;
import com.elmaalmi.billal.library.dal.RevueRepository;
import com.elmaalmi.billal.library.model.Adherent;
import com.elmaalmi.billal.library.model.Livre;
import com.elmaalmi.billal.library.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/document/livre")
public class LivreController {
    @Autowired
    private LivreService livreService;
    //
    @Autowired
    LivreRepository livreRepository;
    @Autowired
    RevueRepository revueRepository;
    @Autowired
    DictionnaireRepository dictionnaireRepository;
    @GetMapping
    public String index(Model model){
        model.addAttribute("livres",livreService.findAll());
        model.addAttribute("nb_livre",livreRepository.count());
        model.addAttribute("nb_revue",revueRepository.count());
        model.addAttribute("nb_dictionnaire",dictionnaireRepository.count());
        return "document/livreIndex";
    }
    @GetMapping("/add")
    public String add(@ModelAttribute Livre livre){
        return "document/addLivre";
    }
    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Livre livre, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "document/addLivre";
        }
        livreService.save(livre);
        return "redirect:/document/livre";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("livre",livreService.findById(id));
        return "document/addLivre";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        livreService.delete(id);
        return "redirect:/document/livre";
    }
}
