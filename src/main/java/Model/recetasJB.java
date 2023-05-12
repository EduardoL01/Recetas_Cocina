package Model;

import java.io.Serializable;

import java.sql.*;

public class recetasJB implements Serializable {
    private int ID_Recetas;
    private String titulo;
    private String descripcion;
    private int porciones;
    private Time tiempo_preparacion;
    private String ingredientes;
    private String instrucciones;
    public Date fecha_publicacion;
    private int ID_Usuario;
    private int ID_Dificultad;

    public recetasJB() {
    }

    // seleccinar
    public recetasJB(int ID_Recetas, String titulo, String descripcion, int porciones, Time tiempo_preparacion,
            String ingredientes, String instrucciones, Date fecha_publicacion, int ID_Usuario, int ID_Dificultad) {
        this.ID_Recetas = ID_Recetas;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.porciones = porciones;
        this.tiempo_preparacion = tiempo_preparacion;
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
        this.fecha_publicacion = fecha_publicacion;
        this.ID_Usuario = ID_Usuario;
        this.ID_Dificultad = ID_Dificultad;
    }

    // modificar
    public recetasJB(int ID_Recetas, String titulo, String descripcion, int porciones, Time tiempo_preparacion,
            String ingredientes, String instrucciones, int ID_Usuario, int ID_Dificultad) {
        this.ID_Recetas = ID_Recetas;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.porciones = porciones;
        this.tiempo_preparacion = tiempo_preparacion;
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
        this.ID_Usuario = ID_Usuario;
        this.ID_Dificultad = ID_Dificultad;
    }

    // insertar
    public recetasJB(String titulo, String descripcion, int porciones, Time tiempo_preparacion,
            String ingredientes, String instrucciones, int ID_Usuario, int ID_Dificultad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.porciones = porciones;
        this.tiempo_preparacion = tiempo_preparacion;
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
        this.ID_Usuario = ID_Usuario;
        this.ID_Dificultad = ID_Dificultad;
    }

    // eliminar
    public recetasJB(int ID_Recetas) {
        this.ID_Recetas = ID_Recetas;
    }

    public int getID_Recetas() {
        return ID_Recetas;
    }

    public void setID_Recetas(int iD_Recetas) {
        ID_Recetas = iD_Recetas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPorciones() {
        return porciones;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }

    public Time getTiempo_preparacion() {
        return tiempo_preparacion;
    }

    public void setTiempo_preparacion(Time tiempo_preparacion) {
        this.tiempo_preparacion = tiempo_preparacion;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int iD_Usuario) {
        ID_Usuario = iD_Usuario;
    }

    public int getID_Dificultad() {
        return ID_Dificultad;
    }

    public void setID_Dificultad(int iD_Dificultad) {
        ID_Dificultad = iD_Dificultad;
    }
}
