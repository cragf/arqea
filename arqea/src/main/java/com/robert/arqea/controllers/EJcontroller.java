package com.robert.arqea.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robert.arqea.dao.ArtefactoDAO;
import com.robert.arqea.models.Artefacto;

@RestController
@RequestMapping("/api")
public class EJcontroller {
    @GetMapping("/ejemplo_rest")
    public ArrayList<Artefacto> ejemplo_rest() {
        ArtefactoDAO ar = new ArtefactoDAO();
        try {
            ArrayList<Artefacto> lArtefactos = ar.listar();
            return lArtefactos;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
