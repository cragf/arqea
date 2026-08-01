package com.robert.arqea.dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Querys {
    public String Leer (String campo, String accion) {
        try {
            Path path = Paths.get("arqea\\src\\main\\resources\\querys\\"+accion+".txt");
            List<String> lista = Files.readAllLines(path);
            StringBuilder salida = new StringBuilder();;
            boolean encontrado = false;
            for (String fila : lista) {
                if (fila.contains(">>") && encontrado && !fila.equals(">>"+campo)) {
                    break;
                }
                if (fila.equals(">>"+campo)) {
                    encontrado = true;
                    continue;
                }
                if (encontrado) {
                   salida.append(fila).append("\n");
                }
            }
            return salida.toString();
        } catch (Exception e) {
            System.out.println("Error al " + accion + " el campo " + campo);
        }
        return "";
    }
}
