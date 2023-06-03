package Data;

import java.util.*;

import Controller.Conexion;

import java.sql.*;

import Model.usuariosJB;

public class usuariosDAO {
    public static final String seleccionar = "Select * from usuarios order by ID_Usuario";
    public static final String insertar = "insert into usuarios(nombre, apellido, email, contraseña) values (?,?,?,?)";
    public static final String eliminar = "delete from usuarios where ID_Usuario=?";
    public static final String modificar = "update usuarios set nombre=?, apellido=?, email=?, contraseña=?, tipo_usuario=? where ID_Usuario=?";
    public static final String validar = "Select * from usuarios where email=? and contraseña=?";

    // seleccionar
    public List<usuariosJB> Select() {
        Statement st;
        ResultSet rs;
        usuariosJB usu;

        List<usuariosJB> usuarios = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(seleccionar);

            while (rs.next()) {
                int ID_Usuario = rs.getInt("ID_Usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String contraseña = rs.getString("contraseña");
                String tipo_usuario = rs.getString("tipo_usuario");

                usu = new usuariosJB(ID_Usuario, nombre, apellido, email, contraseña, tipo_usuario);
                usuarios.add(usu);
            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }

    // insertar
    public void insertar(usuariosJB usuarios) {
        Connection con;
        PreparedStatement st;
        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insertar);
            st.setString(1, usuarios.getNombre());
            st.setString(2, usuarios.getApellido());
            st.setString(3, usuarios.getEmail());
            st.setString(4, usuarios.getContraseña());

            if (st.executeUpdate() == 1) {
                System.out.println("Registro Exitoso");
            }
            Conexion.close(con);
            Conexion.close(st);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // modificar
    public void modificar(usuariosJB usuarios) {
        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(modificar);
            st.setInt(1, usuarios.getID_Usuario());
            st.setString(2, usuarios.getNombre());
            st.setString(3, usuarios.getApellido());
            st.setString(4, usuarios.getEmail());
            st.setString(5, usuarios.getContraseña());
            st.setString(6, usuarios.getTipo_usuario());
            if (st.executeUpdate() == 1) {
                System.out.println("registro actualizado");
            }
            Conexion.close(con);
            Conexion.close(st);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("error");
        }
    }

    // eliminar
    public void eliminar(usuariosJB usuarios) {
        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(eliminar);
            st.setInt(1, usuarios.getID_Usuario());
            if (st.executeUpdate() == 1) {
                System.out.println("Registro eliminado");
            }
            Conexion.close(con);
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //validar usuarios
    public usuariosJB login (String email, String contraseña){
        PreparedStatement st ;
        ResultSet rs ;
        usuariosJB usuario=null;

        try{
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(validar);
            st.setString(1, email);
            st.setString(2, contraseña);
            rs= st.executeQuery();
            while (rs.next())
            {
                int id=rs.getInt("ID_Usuario");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String u=rs.getString("email");
                String pass=rs.getString("contraseña");
                String tipo=rs.getString("tipo_usuario");

                System.out.println(id+nombre+apellido+pass+u);
                usuario=new usuariosJB(id,nombre,apellido,u,contraseña,tipo);

            }

            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
