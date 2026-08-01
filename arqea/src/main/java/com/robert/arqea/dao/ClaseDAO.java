package com.robert.arqea.dao;

import com.robert.arqea.models.Clase;
import com.robert.arqea.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClaseDAO implements DAOinterfaz {

    @Override
    public ArrayList<Clase> listar() {
        ArrayList<Clase> lista = new ArrayList<>();
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Clase clase = new Clase(
                        rs.getInt("IDclase"),
                        rs.getString("nombre_clase"),
                        rs.getString("descripcion_clase")
                );
                lista.add(clase);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void insertar(Object obj) {
        Clase clase = (Clase) obj;
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, clase.getNombreClase());
            ps.setString(2, clase.getDescripcionClase());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Object obj) {
        Clase clase = (Clase) obj;
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, clase.getNombreClase());
            ps.setString(2, clase.getDescripcionClase());
            ps.setInt(3, clase.getIdClase());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mover(Object obj, int clave, int destino, boolean museo) {
        // No aplica de forma natural a Clase; se implementa por contrato de la interfaz.
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, destino);
            ps.setInt(2, clave);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
