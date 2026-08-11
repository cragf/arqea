package com.robert.arqea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.robert.arqea.dao.ClaveDAO;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    private final ClaveDAO claveDAO = new ClaveDAO();

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
}
