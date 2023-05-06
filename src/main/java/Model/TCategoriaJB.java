package Model;

public class TCategoriaJB {
    private int ID_Categoria;
    private String nombre;

    public TCategoriaJB() {
    }

    // seleccinar y modificar
    public TCategoriaJB(int iD_Categoria, String nombre) {
        ID_Categoria = iD_Categoria;
        this.nombre = nombre;
    }

    // insertar
    public TCategoriaJB(String nombre) {
        this.nombre = nombre;
    }

    // eliminar
    public TCategoriaJB(int iD_Categoria) {
        ID_Categoria = iD_Categoria;
    }

    public int getID_Categoria() {
        return ID_Categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setID_Categoria(int iD_Categoria) {
        ID_Categoria = iD_Categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}