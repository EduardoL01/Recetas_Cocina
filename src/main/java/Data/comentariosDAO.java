package Data;

import java.util.*;

import java.sql.*;
import java.sql.Date;

import Model.comentariosJB;

public class comentariosDAO {
    public static final String seleccionar = "Select * from comentarios order by comentario";
    public static final String insertar = "insert into comentarios(comentario, ID_Usuario, ID_Recetas) values (?,?,?)";
    public static final String eliminar = "delete from comentarios where ID_Comentario=?";
    public static final String modificar = "update comentario set comentario, ID_Usuario, ID_Recetas";

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
                int ID_Usuario=rs.getInt("ID_Comentario");
                int ID_Recetas=rs.getInt("ID_Usuario");

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

    //insertar
    public void insertar(comentariosJB comentarios){
        Connection con;
        PreparedStatement st;
        try {
            con = Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(insertar);
            st.setString(1, comentarios.getComentario());

            if (st.executeUpdate()==1) {
                System.out.println("Registro Exitoso");
            }
            Conexion.close(con);
            Conexion.close(st);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //modificar
    public void modificar(comentariosJB comentarios){
        Connection con;
        PreparedStatement st;

        try {
            con= Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(modificar);
            st.setString(1, comentarios.getComentario());
            st.setInt(2, comentarios.getID_Comentario());
            st.setInt(3, comentarios.getID_Recetas());
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
