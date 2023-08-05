package org.myfilms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/films")
public class FilmsController {

    @GetMapping("/all-my-films")
    public String returnIndex() {
        System.out.println("Hello Word!");
        return "films-template";
    }

}
