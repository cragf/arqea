package com.robert.arqea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.robert.arqea.dao.ArtefactoDAO;
//import com.robert.arqea.dao.ClaseDAO;
import com.robert.arqea.dao.ClaveDAO;
import com.robert.arqea.dao.EquipoDAO;
//import com.robert.arqea.dao.LiderDAO;
import com.robert.arqea.dao.MuseoDAO;
//import com.robert.arqea.dao.YacimientoDAO;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    private final ClaveDAO claveDAO = new ClaveDAO();
    private final ArtefactoDAO artefactoDAO = new ArtefactoDAO();
    //private final ClaseDAO claseDAO = new ClaseDAO();
    private final EquipoDAO equipoDAO = new EquipoDAO();
    //private final LiderDAO liderDAO = new LiderDAO();
    private final MuseoDAO museoDAO = new MuseoDAO();
    //private final YacimientoDAO yacimientoDAO = new YacimientoDAO();

    @PostMapping("/ingresar")
    public String ingresar(@RequestParam String clave, HttpSession session, RedirectAttributes redirectAttributes) {
        Integer idMuseo = claveDAO.buscarClaveMuseo(clave);
        if (idMuseo != null) {
            session.setAttribute("tipo", "museo");
            session.setAttribute("id", idMuseo);
            return "redirect:/admin";
        }

        Integer idEquipo = claveDAO.buscarClaveEquipo(clave);
        if (idEquipo != null) {
            session.setAttribute("tipo", "equipo");
            session.setAttribute("id", idEquipo);
            return "redirect:/admin";
        }

        redirectAttributes.addFlashAttribute("error", "Clave incorrecta");
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String admin(HttpSession session, Model model) {
        String tipo = (String) session.getAttribute("tipo");
        if (tipo == null) {
            return "redirect:/"; // nadie entró con una clave valida todavia
        }
        model.addAttribute("tipo", tipo);
        model.addAttribute("colorFondo", "museo".equals(tipo) ? "#1B3A6B" : "#D4AF37");
        return "admin";
    }

    @PostMapping("/salir")
    public String salir(HttpSession session) {
        session.invalidate();
        return "redirect:/principal";
    }

    @PostMapping("/verificar-clave")
    public String verificarClave(@RequestParam String tipo, @RequestParam int id,
                                @RequestParam String accion, @RequestParam String clave,
                                RedirectAttributes redirectAttributes) {

        Integer idValidado = switch (tipo) {
            case "museo" -> claveDAO.buscarClaveMuseo(clave);
            case "equipo" -> claveDAO.buscarClaveEquipo(clave);
            case "artefacto" -> claveDAO.buscarClaveArtefacto(clave);
            default -> null;
        };

        if (idValidado == null || idValidado != id) {
            redirectAttributes.addFlashAttribute("errorClave", "Código incorrecto");
            redirectAttributes.addFlashAttribute("tipoReintento", tipo);
            redirectAttributes.addFlashAttribute("idReintento", id);
            redirectAttributes.addFlashAttribute("accionReintento", accion);
            return "redirect:/admin";
        }

        if ("eliminar".equals(accion)) {
            switch (tipo) {
                case "museo" -> museoDAO.eliminar(id);
                case "equipo" -> equipoDAO.eliminar(id);
                case "artefacto" -> artefactoDAO.eliminar(id);
            }
            return "redirect:/admin";
        }

        // accion == "editar"
        return "redirect:/" + tipo + "s/editar/" + id;
    }
}
