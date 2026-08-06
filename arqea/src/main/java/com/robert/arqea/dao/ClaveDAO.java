package com.robert.arqea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.robert.arqea.util.ConnectionDB;

public class ClaveDAO {
    private Querys q = new Querys();
    public String buscarClaveMuseo(int id) {

        String sql = q.Leer("museo", "clave");
        System.out.println("SQL buscar clave museo: " + sql);

        String clave = null;

        try (Connection con = ConnectionDB.Getconexion().Conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    clave = rs.getString("clave");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clave;
    }
    public String buscarClaveEquipo(int id) {

        String sql = q.Leer("equipo", "clave");
        System.out.println("SQL buscar clave equipo: " + sql);

        String clave = null;

        try (Connection con = ConnectionDB.Getconexion().Conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    clave = rs.getString("clave");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clave;
    }
    public String buscarClaveArtefacto(int id) {

        String sql = q.Leer("artefacto", "clave");
        System.out.println("SQL buscar clave artefacto: " + sql);

        String clave = null;

        try (Connection con = ConnectionDB.Getconexion().Conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    clave = rs.getString("clave");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clave;
    }
}
