package com.robert.arqea.dao;

import com.robert.arqea.models.Museo;
import com.robert.arqea.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MuseoDAO implements DAOinterfaz {

    @Override
    public ArrayList<Museo> listar() {
        ArrayList<Museo> lista = new ArrayList<>();
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Museo museo = new Museo(
                        rs.getInt("IDmuseo"),
                        rs.getString("nombre_museo")
                );
                lista.add(museo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void insertar(Object obj) {
        Museo museo = (Museo) obj;
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, museo.getNombreMuseo());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Object obj) {
        Museo museo = (Museo) obj;
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, museo.getNombreMuseo());
            ps.setInt(2, museo.getIdMuseo());
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
        // No aplica de forma natural a Museo; se implementa por contrato de la interfaz.
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
