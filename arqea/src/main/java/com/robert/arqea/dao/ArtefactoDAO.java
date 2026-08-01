package com.robert.arqea.dao;

import com.robert.arqea.models.Artefacto;
import com.robert.arqea.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArtefactoDAO implements DAOinterfaz {
    @Override
    public ArrayList<Artefacto> listar() {
        ArrayList<Artefacto> lista = new ArrayList<>();

        String sql = q.Leer("artefacto", "listar");
        System.out.println("SQL listar artefactos: " + sql);

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Artefacto artefacto = new Artefacto(
                        rs.getInt("IDartefacto"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("descubridores"), // nombre del equipo
                        rs.getBoolean("encamino"),
                        rs.getString("museo"),         // nombre del museo (puede ser null)
                        rs.getString("yacimiento"),    // nombre del yacimiento
                        rs.getString("clave"),
                        rs.getString("img"),
                        rs.getString("clase")          // nombre de la clase
                );
                lista.add(artefacto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void insertar(Object obj) {
        Artefacto artefacto = (Artefacto) obj;
        // debe resolver los ids de equipo/museo/yacimiento/clase
        // a partir de los nombres que trae el objeto
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, artefacto.getNombre());
            ps.setString(2, artefacto.getDescripcion());
            ps.setString(3, artefacto.getDescubridores());
            ps.setBoolean(4, artefacto.getEncamino());
            ps.setString(5, artefacto.getMuseo());
            ps.setString(6, artefacto.getYacimiento());
            ps.setString(7, artefacto.getClave());
            ps.setString(8, artefacto.getImg());
            ps.setString(9, artefacto.getClase());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Object obj) {
        Artefacto artefacto = (Artefacto) obj;
        String sql = "";

        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, artefacto.getNombre());
            ps.setString(2, artefacto.getDescripcion());
            ps.setString(3, artefacto.getDescubridores());
            ps.setBoolean(4, artefacto.getEncamino());
            ps.setString(5, artefacto.getMuseo());
            ps.setString(6, artefacto.getYacimiento());
            ps.setString(7, artefacto.getClave());
            ps.setString(8, artefacto.getImg());
            ps.setString(9, artefacto.getClase());
            ps.setInt(10, artefacto.getIdArtefacto());
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

    // clave aqui es el IDartefacto (int), no confundir con la columna varchar "clave".
    // destino es el id del museo o del yacimiento, segun indique el flag "museo".
    @Override
    public void mover(Object obj, int clave, int destino, boolean museo) {
        String sql;

        if (museo) {
            sql = ""; // ej: UPDATE artefactos SET museo = ? WHERE IDartefacto = ?
        } else {
            sql = ""; // ej: UPDATE artefactos SET yacimiento = ? WHERE IDartefacto = ?
        }

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
