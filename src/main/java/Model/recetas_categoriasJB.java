package Model;

public class recetas_categoriasJB {
    private int ID_Recetas_categorias;
    private int ID_Recetas;
    private int ID_Categorias;

    public recetas_categoriasJB() {
    }

    // seleccinar y modificar
    public recetas_categoriasJB(int ID_Recetas_categorias, int ID_Recetas, int ID_Categorias) {
        this.ID_Recetas_categorias = ID_Recetas_categorias;
        this.ID_Recetas = ID_Recetas;
        this.ID_Categorias = ID_Categorias;
    }

    // insertar
    public recetas_categoriasJB(int ID_Recetas, int ID_Categorias) {
        this.ID_Recetas = ID_Recetas;
        this.ID_Categorias = ID_Categorias;
    }

    // eliminar
    public recetas_categoriasJB(int ID_Recetas_categorias) {
        this.ID_Recetas_categorias = ID_Recetas_categorias;
    }

    public int getID_Recetas_categorias() {
        return ID_Recetas_categorias;
    }

    public void setID_Recetas_categorias(int iD_Recetas_categorias) {
        ID_Recetas_categorias = iD_Recetas_categorias;
    }

    public int getID_Recetas() {
        return ID_Recetas;
    }

    public void setID_Recetas(int iD_Recetas) {
        ID_Recetas = iD_Recetas;
    }

    public int getID_Categorias() {
        return ID_Categorias;
    }

    public void setID_Categorias(int iD_Categorias) {
        ID_Categorias = iD_Categorias;
    }
}
