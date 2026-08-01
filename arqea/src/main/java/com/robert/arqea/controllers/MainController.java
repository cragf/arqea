package com.robert.arqea.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.robert.arqea.dao.ArtefactoDAO;
import com.robert.arqea.models.Artefacto;

@Controller
public class MainController {
    @GetMapping("/principal")
    public String info(Model model) {

        ArtefactoDAO ed = new ArtefactoDAO();
        try {
            ArrayList<Artefacto> lArtefactos = ed.listar();
            model.addAttribute("artefactos", lArtefactos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Ejecutando el controlador de artefactos");
        return "principal";
    }
}
