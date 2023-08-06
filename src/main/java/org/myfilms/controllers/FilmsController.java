package org.myfilms.controllers;

import org.myfilms.repositories.interfaces.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/films")
public class FilmsController {

    private final FilmRepository filmRepositoryImpl;

    @Autowired
    public FilmsController(FilmRepository filmRepositoryImpl) {
        this.filmRepositoryImpl = filmRepositoryImpl;
    }


    @GetMapping("/all-my-films")
    public String returnIndex(Model model) {
        model.addAttribute("films", filmRepositoryImpl.findAll());
        return "films-template";
    }

}
