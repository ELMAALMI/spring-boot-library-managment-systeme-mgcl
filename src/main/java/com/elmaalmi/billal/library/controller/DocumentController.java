package com.elmaalmi.billal.library.controller;

import com.elmaalmi.billal.library.dal.DictionnaireRepository;
import com.elmaalmi.billal.library.dal.LivreRepository;
import com.elmaalmi.billal.library.dal.RevueRepository;
import com.elmaalmi.billal.library.service.DictionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    LivreRepository livreRepository;
    @Autowired
    RevueRepository revueRepository;
    @Autowired
    DictionnaireRepository dictionnaireRepository;
    @Autowired
    DictionnaireService dictionnaireService;

    @GetMapping
    public String index(Model modelAndView){
        modelAndView.addAttribute("nb_livre",livreRepository.count());
        modelAndView.addAttribute("nb_revue",revueRepository.count());
        modelAndView.addAttribute("nb_dictionnaire",dictionnaireRepository.count());
        modelAndView.addAttribute("dictionnaires",dictionnaireService.findAll());
        return "document/index";
    }
}
