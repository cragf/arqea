package com.robert.arqea.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

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

@ControllerAdvice
public class AdvController {
    ArtefactoDAO artd = new ArtefactoDAO();
    ClaseDAO clad = new ClaseDAO();
    EquipoDAO equd = new EquipoDAO();
    LiderDAO lidd = new LiderDAO();
    MuseoDAO musd = new MuseoDAO();
    YacimientoDAO yacd = new YacimientoDAO();
    
    @ModelAttribute("artefactos")
    ArrayList<Artefacto> CargarArtefactos() {
    System.out.println("Artefactos listados: " + artd.listar().size()); 
    return  artd.listar();
    }
    @ModelAttribute("clases")
    ArrayList<Clase> CargarClases() { 
    System.out.println("Clases listadas: " + clad.listar().size());
    return  clad.listar(); 
}
    @ModelAttribute("equipos")
    ArrayList<Equipo> CargarEquipos() { 
    System.out.println("Equipos listados: " + equd.listar().size());
    return  equd.listar();
    }
    @ModelAttribute("lideres")
    ArrayList<Lider> CargarLideres() { 
    System.out.println("Líderes listados: " + lidd.listar().size());
    return  lidd.listar();
 }
    @ModelAttribute("museos")
    ArrayList<Museo> CargarMuseos() { 
    System.out.println("Museos listados: " + musd.listar().size());
    return  musd.listar();
    }
    @ModelAttribute("yacimientos")
    ArrayList<Yacimiento> CargarYacimientos() { 
    System.out.println("Yacimientos listados: " + yacd.listar().size());
    return  yacd.listar();
    }

}
