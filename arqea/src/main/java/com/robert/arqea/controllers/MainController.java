package com.robert.arqea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/principal")
        public String principal(Model model) {
                return "principal";
        }
}
