package com.robert.arqea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClaveDAO {
    public String buscarClave(int id) {
        String sql = q.Leer("museo", "clave");
        System.out.println("SQL buscar clave museo: " + sql);

        String clave = null;

        try (Connection con = ConexionBD.getConexion();
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
