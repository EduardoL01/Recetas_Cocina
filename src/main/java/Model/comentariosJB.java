package Model;

import java.io.Serializable;

import java.sql.Date;

public class comentariosJB implements Serializable {
    private int ID_Comentario;
    private String comentario;
    private Date fecha_comentario;
    private int ID_Usuario;
    private int ID_Recetas;

    public comentariosJB() {
    }

    // seleccinar
    public comentariosJB(int ID_Comentario, String comentario, Date fecha_comentario, int ID_Usuario, int ID_Recetas) {
        this.ID_Comentario = ID_Comentario;
        this.comentario = comentario;
        this.fecha_comentario = fecha_comentario;
        this.ID_Usuario = ID_Usuario;
        this.ID_Recetas = ID_Recetas;
    }

    // modificar
    public comentariosJB(int ID_Comentario, String comentario, int ID_Usuario, int ID_Recetas) {
        this.comentario = comentario;
        this.ID_Usuario = ID_Usuario;
        this.ID_Recetas = ID_Recetas;
    }

    // insertar
    public comentariosJB(String comentario, int ID_Usuario, int ID_Recetas) {
        this.comentario = comentario;
        this.ID_Usuario = ID_Usuario;
        this.ID_Recetas = ID_Recetas;
    }

    // eliminar
    public comentariosJB(int ID_Comentario) {
        this.ID_Comentario = ID_Comentario;
    }

    public int getID_Comentario() {
        return ID_Comentario;
    }

    public void setID_Comentario(int ID_Comentario) {
        this.ID_Comentario = ID_Comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha_comentario() {
        return fecha_comentario;
    }

    public void setFecha_comentario(Date fecha_comentario) {
        this.fecha_comentario = fecha_comentario;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int iD_Usuario) {
        ID_Usuario = iD_Usuario;
    }

    public int getID_Recetas() {
        return ID_Recetas;
    }

    public void setID_Recetas(int iD_Recetas) {
        ID_Recetas = iD_Recetas;
    }

}
