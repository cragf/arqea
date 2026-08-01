package com.robert.arqea.dao;


import java.util.ArrayList;

public interface DAOinterfaz {
    public ArrayList<?> listar();
    public void insertar(Object obj);
    public void actualizar(Object obj);
    public void eliminar(int id);
    public void mover(Object obj, int clave, int destino, boolean museo);
}
