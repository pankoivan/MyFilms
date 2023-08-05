package org.myfilms.controllers;

import org.myfilms.dao.interfaces.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/films")
public class FilmsController {

    @Autowired
    private FilmDao filmDaoImpl;

    @GetMapping("/all-my-films")
    public String returnIndex() {
        //System.out.println(filmDaoImpl.findById("328"));
        filmDaoImpl.findAll()
                .getItems()
                .forEach(System.out::println);
        return "films-template";
    }

}
