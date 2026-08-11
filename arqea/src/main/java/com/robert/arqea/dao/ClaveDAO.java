package com.robert.arqea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.robert.arqea.util.ConnectionDB;

public class ClaveDAO {
    private Querys q = new Querys();
    public Integer buscarClaveMuseo(String clave) {

        String sql = q.Leer("museo", "ingresar");
        System.out.println("SQL ingresar museo: " + sql);

        Integer id = null;

        try (Connection con = ConnectionDB.Getconexion().Conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, clave);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("IDmuseo");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
    public Integer buscarClaveEquipo(String clave) {

        String sql = q.Leer("equipo", "ingresar");
        System.out.println("SQL ingresar equipo: " + sql);

        Integer id = null;

        try (Connection con = ConnectionDB.Getconexion().Conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, clave);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("IDequipo");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
    public Integer buscarClaveArtefacto(String clave) {

        String sql = q.Leer("artefacto", "ingresar");
        System.out.println("SQL ingresar artefacto: " + sql);

        Integer id = null;

        try (Connection con = ConnectionDB.Getconexion().Conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, clave);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("IDartefacto");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
