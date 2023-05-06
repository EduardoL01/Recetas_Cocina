package Model;

public class TDificultadJB {
    private int ID_Dificultad;
    private String dificultad;

    public TDificultadJB() {
    }

    //seleccinar
    public TDificultadJB(int ID_Dificultad, String dificultad) {
        this.ID_Dificultad = ID_Dificultad;
        this.dificultad = dificultad;
    }
    
    public int getID_Dificultad() {
        return ID_Dificultad;
    }

    public void setID_Dificultad(int iD_Dificultad) {
        ID_Dificultad = iD_Dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getDificultad() {
        return dificultad;
    }
}
