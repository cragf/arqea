package com.robert.arqea.dao;

import com.robert.arqea.models.Lider;
import com.robert.arqea.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LiderDAO implements DAOinterfaz {

    @Override
    public ArrayList<Lider> listar() {
        ArrayList<Lider> lista = new ArrayList<>();
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Lider lider = new Lider(
                        rs.getInt("IDlider"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                );
                lista.add(lider);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void insertar(Object obj) {
        Lider lider = (Lider) obj;
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, lider.getNombre());
            ps.setString(2, lider.getApellido());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Object obj) {
        Lider lider = (Lider) obj;
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, lider.getNombre());
            ps.setString(2, lider.getApellido());
            ps.setInt(3, lider.getId());
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
        // No aplica de forma natural a Lider; se implementa por contrato de la interfaz.
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
