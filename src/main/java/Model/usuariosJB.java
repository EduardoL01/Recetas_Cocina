package Model;

public class usuariosJB {
    private int ID_Usuario;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private String tipo_usuario;

    public usuariosJB() {
    }

    //modificar y seleccinar
    public usuariosJB(int ID_Usuario ,String nombre, String apellido, String email, String contraseña, String tipo_usuario) {
        this.ID_Usuario = ID_Usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.tipo_usuario = tipo_usuario;
    }

    //insertar
    public usuariosJB(String nombre, String apellido, String email, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
    }

    //eliminar
    public usuariosJB(int ID_Usuario, String nombre, String apellido, String email, String contraseña) {
        this.ID_Usuario = ID_Usuario;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int iD_Usuario) {
        ID_Usuario = iD_Usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }
}
