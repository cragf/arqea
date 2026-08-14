package com.robert.arqea.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.robert.arqea.dao.ArtefactoDAO;
//import com.robert.arqea.dao.ClaveDAO;
import com.robert.arqea.dao.EquipoDAO;
import com.robert.arqea.dao.MuseoDAO;
import com.robert.arqea.models.Artefacto;
import com.robert.arqea.models.Equipo;
import com.robert.arqea.models.Museo;

@Controller
public class MainController {

    //private final ClaveDAO claveDAO = new ClaveDAO();
    private final ArtefactoDAO artefactoDAO = new ArtefactoDAO();
    //private final ClaseDAO claseDAO = new ClaseDAO();
    private final EquipoDAO equipoDAO = new EquipoDAO();
    //private final LiderDAO liderDAO = new LiderDAO();
    private final MuseoDAO museoDAO = new MuseoDAO();
    //private final YacimientoDAO yacimientoDAO = new YacimientoDAO();
    @GetMapping("/principal")
        public String principal(Model model) {
                return "principal";
        }
    @GetMapping("/") // bro no quiere corregir el no tener una ruta raiz asi que va dejar un parche just in case
        public String raiz() {
                return "redirect:/principal";
        }
    @GetMapping("/artefactos/nuevo")
    public String nuevoArtefacto(Model model) {
        model.addAttribute("artefacto", new Artefacto());
        return "artefacto-formulario";
    }

    @GetMapping("/artefactos/editar/{id}")
    public String editarArtefacto(@PathVariable int id, Model model) {
        model.addAttribute("artefacto", buscarArtefactoPorId(id));
        return "artefacto-formulario";
    }

    @PostMapping("/artefactos/guardar")
    public String guardarArtefacto(@ModelAttribute Artefacto artefacto, RedirectAttributes redirectAttributes) {
        if (artefacto.getIdArtefacto() == null) {
            artefacto.setHabilitado(true);
            String claveGenerada = generarClave();
            artefacto.setClave(claveGenerada);
            artefactoDAO.insertar(artefacto);
            redirectAttributes.addFlashAttribute("claveGenerada", claveGenerada);
        } else {
            Artefacto original = buscarArtefactoPorId(artefacto.getIdArtefacto());
            artefacto.setClave(original.getClave());
            artefactoDAO.actualizar(artefacto);
        }
        return "redirect:/principal";
    }

    @GetMapping("/artefactos/eliminar/{id}")
    public String eliminarArtefacto(@PathVariable int id) {
        artefactoDAO.eliminar(id);
        return "redirect:/principal";
    }

    private Artefacto buscarArtefactoPorId(int id) {
        ArrayList<Artefacto> lista = artefactoDAO.listar();
        for (Artefacto a : lista) {
            if (a.getIdArtefacto() != null && a.getIdArtefacto() == id) {
                return a;
            }
        }
        return new Artefacto();
    }
    
    @GetMapping("/equipos/nuevo")
    public String nuevoEquipo(Model model) {
        model.addAttribute("equipo", new Equipo());
        return "equipo-formulario";
    }

    @GetMapping("/equipos/editar/{id}")
    public String editarEquipo(@PathVariable int id, Model model) {
        model.addAttribute("equipo", buscarEquipoPorId(id));
        return "equipo-formulario";
    }

    @PostMapping("/equipos/guardar")
    public String guardarEquipo(@ModelAttribute Equipo equipo, @RequestParam(required = false) String clave, RedirectAttributes redirectAttributes) {
        if (equipo.getIdEquipo() == null) {
            equipo.setHabilitado(true);
            String claveGenerada = generarClave();
            equipo.setClave(claveGenerada);
            equipoDAO.insertar(equipo);
            redirectAttributes.addFlashAttribute("claveGenerada", claveGenerada);
        } else {
            Equipo original = buscarEquipoPorId(equipo.getIdEquipo());
            equipo.setClave(original.getClave()); // preserva la clave real, nunca viajo por el form
            equipoDAO.actualizar(equipo);
        }
        return "redirect:/principal";
    }

    @GetMapping("/equipos/eliminar/{id}")
    public String eliminarEquipo(@PathVariable int id) {
        equipoDAO.eliminar(id);
        return "redirect:/principal";
    }

    private Equipo buscarEquipoPorId(int id) {
        ArrayList<Equipo> lista = equipoDAO.listar();
        for (Equipo e : lista) {
            if (e.getIdEquipo() != null && e.getIdEquipo() == id) {
                return e;
            }
        }
        return new Equipo();
    }
    @GetMapping("/museos/nuevo")
    public String nuevoMuseo(Model model) {
        model.addAttribute("museo", new Museo());
        return "museo-formulario";
    }

    @GetMapping("/museos/editar/{id}")
    public String editarMuseo(@PathVariable int id, Model model) {
        model.addAttribute("museo", buscarMuseoPorId(id));
        return "museo-formulario";
    }

    @PostMapping("/museos/guardar")
    public String guardarMuseo(@ModelAttribute Museo museo, @RequestParam(required = false) String clave, RedirectAttributes redirectAttributes) {
        if (museo.getIdMuseo() == null) {
            museo.setHabilitado(true);
            String claveGenerada = generarClave();
            museo.setClave(claveGenerada);
            museoDAO.insertar(museo);
            redirectAttributes.addFlashAttribute("claveGenerada", claveGenerada);
        } else {
            Museo original = buscarMuseoPorId(museo.getIdMuseo());
            museo.setClave(original.getClave()); // preserva la clave real, nunca viajo por el form
            museoDAO.actualizar(museo);
        }
        return "redirect:/principal";
    }

    @GetMapping("/museos/eliminar/{id}")
    public String eliminarMuseo(@PathVariable int id) {
        museoDAO.eliminar(id);
        return "redirect:/principal";
    }

    private Museo buscarMuseoPorId(int id) {
        ArrayList<Museo> lista = museoDAO.listar();
        for (Museo m : lista) {
            if (m.getIdMuseo() != null && m.getIdMuseo() == id) {
                return m;
            }
        }
        return new Museo();
    }
    private String generarClave() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        java.util.Random rnd = new java.util.Random();

        sb.append(letras.charAt(rnd.nextInt(26)));
        sb.append(letras.charAt(rnd.nextInt(26)));
        for (int i = 0; i < 10; i++) {
            sb.append(rnd.nextInt(10));
        }
        return sb.toString();
    }
}
