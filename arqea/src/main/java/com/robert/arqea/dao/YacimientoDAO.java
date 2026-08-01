package com.robert.arqea.dao;

import com.robert.arqea.models.Yacimiento;
import com.robert.arqea.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class YacimientoDAO implements DAOinterfaz {

    @Override
    public ArrayList<Yacimiento> listar() {
        ArrayList<Yacimiento> lista = new ArrayList<>();
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Yacimiento yacimiento = new Yacimiento(
                        rs.getInt("IDyacimiento"),
                        rs.getString("nombre"),
                        rs.getObject("latitud", Double.class),
                        rs.getObject("longitud", Double.class)
                );
                lista.add(yacimiento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void insertar(Object obj) {
        Yacimiento yacimiento = (Yacimiento) obj;
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, yacimiento.getNombre());

            if (yacimiento.getLongitud() != null && yacimiento.getLatitud() != null) {
                ps.setDouble(2, yacimiento.getLongitud());
                ps.setDouble(3, yacimiento.getLatitud());
            } else {
                ps.setNull(2, Types.DOUBLE);
                ps.setNull(3, Types.DOUBLE);
            }

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Object obj) {
        Yacimiento yacimiento = (Yacimiento) obj;
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, yacimiento.getNombre());

            if (yacimiento.getLongitud() != null && yacimiento.getLatitud() != null) {
                ps.setDouble(2, yacimiento.getLongitud());
                ps.setDouble(3, yacimiento.getLatitud());
            } else {
                ps.setNull(2, Types.DOUBLE);
                ps.setNull(3, Types.DOUBLE);
            }

            ps.setInt(4, yacimiento.getIdYacimiento());
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
        // No aplica de forma natural a Yacimiento; se implementa por contrato de la interfaz.
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
