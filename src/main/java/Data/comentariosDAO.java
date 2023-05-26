package Data;

import java.util.*;

import Controller.Conexion;

import java.sql.*;
import java.sql.Date;

import Model.comentariosJB;

public class comentariosDAO {
    public static final String seleccionar = "Select * from comentarios order by ID_Comentario";
    public static final String insertar = "insert into comentarios(comentario, ID_Usuario, ID_Recetas) values (?,?,?)";
    public static final String eliminar = "delete from comentarios where ID_Comentario=?";
    public static final String modificar = "update comentario set comentario=?, ID_Usuario=?, ID_Recetas=? where ID_Comentario=?";

    // seleccionar
    public List<comentariosJB> Select() {
        Statement st;
        ResultSet rs;
        comentariosJB com;

        List<comentariosJB> comentarios = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(seleccionar);

            while (rs.next()) {
                int ID_Comentario = rs.getInt("ID_Comentario");
                String comentario = rs.getString("comentario");
                Date fecha_comentario = rs.getDate("fecha_comentario");
                int ID_Usuario = rs.getInt("ID_Comentario");
                int ID_Recetas = rs.getInt("ID_Usuario");

                com = new comentariosJB(ID_Comentario, comentario, fecha_comentario, ID_Usuario, ID_Recetas);
                comentarios.add(com);
            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return comentarios;
    }

    // insertar
    public void insertar(comentariosJB comentarios) {
        Connection con;
        PreparedStatement st;
        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insertar);
            st.setString(1, comentarios.getComentario());

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
    public void modificar(comentariosJB comentarios) {
        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(modificar);
            st.setInt(1, comentarios.getID_Comentario());
            st.setString(2, comentarios.getComentario());
            st.setInt(3, comentarios.getID_Comentario());
            st.setInt(4, comentarios.getID_Recetas());
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
    public void eliminar(comentariosJB comentarios) {
        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(eliminar);
            st.setInt(1, comentarios.getID_Comentario());
            if (st.executeUpdate() == 1) {
                System.out.println("Registro eliminado");
            }
            Conexion.close(con);
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
