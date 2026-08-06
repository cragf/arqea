package com.robert.arqea.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.robert.arqea.dao.ArtefactoDAO;
import com.robert.arqea.dao.ClaseDAO;
import com.robert.arqea.dao.EquipoDAO;
import com.robert.arqea.dao.LiderDAO;
import com.robert.arqea.dao.MuseoDAO;
import com.robert.arqea.dao.YacimientoDAO;
import com.robert.arqea.models.Artefacto;
import com.robert.arqea.models.Clase;
import com.robert.arqea.models.Equipo;
import com.robert.arqea.models.Lider;
import com.robert.arqea.models.Museo;
import com.robert.arqea.models.Yacimiento;

@Controller
public class MainController {
    @GetMapping("/principal")
    public String info(Model model) {

        ArtefactoDAO artd = new ArtefactoDAO();
        ClaseDAO clad = new ClaseDAO();
        EquipoDAO equd = new EquipoDAO();
        LiderDAO lidd = new LiderDAO();
        MuseoDAO musd = new MuseoDAO();
        YacimientoDAO yacd = new YacimientoDAO();
        try {
            ArrayList<Artefacto> lArtefactos = artd.listar();
            model.addAttribute("artefactos", lArtefactos);
            System.out.println("Artefactos listados: " + lArtefactos.size());
            ArrayList<Clase> lClases = clad.listar();
            model.addAttribute("clases", lClases);
            System.out.println("Clases listadas: " + lClases.size());
            ArrayList<Equipo> lEquipos = equd.listar();
            model.addAttribute("equipos", lEquipos);
            System.out.println("Equipos listados: " + lEquipos.size());
            ArrayList<Lider> lLideres = lidd.listar();
            model.addAttribute("lideres", lLideres);
            System.out.println("Líderes listados: " + lLideres.size());
            ArrayList<Museo> lMuseos = musd.listar();
            model.addAttribute("museos", lMuseos);
            System.out.println("Museos listados: " + lMuseos.size());
            ArrayList<Yacimiento> lYacimientos = yacd.listar();
            model.addAttribute("yacimientos", lYacimientos);
            System.out.println("Yacimientos listados: " + lYacimientos.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Ejecutado el controlador de artefactos");
        return "principal";
    }
}
