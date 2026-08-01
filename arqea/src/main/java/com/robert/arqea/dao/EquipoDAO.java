package com.robert.arqea.dao;
 
import com.robert.arqea.models.Equipo;
import com.robert.arqea.util.ConnectionDB;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
public class EquipoDAO implements DAOinterfaz {
 
    @Override
    public ArrayList<Equipo> listar() {
        ArrayList<Equipo> lista = new ArrayList<>();
        String sql = ""; // debe hacer JOIN con lideres para traer el nombre del lider
 
        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
 
            while (rs.next()) {
                Equipo equipo = new Equipo(
                        rs.getInt("IDequipo"),
                        rs.getString("nombre_equipo"),
                        rs.getString("lider") // nombre del lider, no el id
                );
                lista.add(equipo);
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return lista;
    }
 
    @Override
    public void insertar(Object obj) {
        Equipo equipo = (Equipo) obj;
        String sql = ""; // debe resolver el id del lider a partir de equipo.getLider()
 
        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
 
            ps.setString(1, equipo.getNombre());
            ps.setString(2, equipo.getLider());
            ps.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public void actualizar(Object obj) {
        Equipo equipo = (Equipo) obj;
        String sql = ""; // debe resolver el id del lider a partir de equipo.getLider()
 
        try (Connection con = ConnectionDB.Getconexion().Conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
 
            ps.setString(1, equipo.getNombre());
            ps.setString(2, equipo.getLider());
            ps.setInt(3, equipo.getId());
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
        // No aplica de forma natural a Equipo; se implementa por contrato de la interfaz.
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