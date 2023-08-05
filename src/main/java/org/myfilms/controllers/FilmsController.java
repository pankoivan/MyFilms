package org.myfilms.controllers;

import org.myfilms.dao.interfaces.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/films")
public class FilmsController {

    @Autowired
    private FilmDao filmDaoImpl;

    @GetMapping("/all-my-films")
    public String returnIndex(Model model) {
        System.out.println(filmDaoImpl.findById("474"));
        /*filmDaoImpl.findAll()
                .getItems()
                .forEach(System.out::println);*/

        model.addAttribute("films", filmDaoImpl.findAll().getItems()
                .stream()
                .map(film -> filmDaoImpl.findById(String.valueOf(film.getKinopoiskId()))));

        return "films-template";
    }

}
