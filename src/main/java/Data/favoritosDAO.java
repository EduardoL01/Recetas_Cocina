package Data;

import java.util.*;

import Controller.Conexion;

import java.sql.*;

import Model.favoritosJB;

public class favoritosDAO {
    public static final String seleccionar = "select * from favoritos order by ID_Favoritos";
    public static final String insertar = "insert into favoritos(ID_Usuario, ID_Recetas) values (?,?)";
    public static final String eliminar = "delete from favoritos where ID_Favoritos=?";
    public static final String modificar = "update favoritos set ID_Usuario=?, ID_Recetas=? where ID_Favoritos=?";

    // seleccionar
    public List<favoritosJB> Select() {
        Statement st;
        ResultSet rs;
        favoritosJB fav;

        List<favoritosJB> favoritos = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(seleccionar);

            while (rs.next()) {
                int ID_Favoritos = rs.getInt("ID_Favoritos");
                int ID_Usuario = rs.getInt("ID_Usuarios");
                int ID_Recetas = rs.getInt("ID_Recetas");

                fav = new favoritosJB(ID_Favoritos, ID_Usuario, ID_Recetas);
                favoritos.add(fav);
            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return favoritos;
    }

    // insertar
    public void insertar(favoritosJB favoritos) {
        Connection con;
        PreparedStatement st;
        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insertar);
            st.setInt(1, favoritos.getID_Usuario());
            st.setInt(2, favoritos.getID_Recetas());

            if (st.executeUpdate() == 1) {
                System.out.println("registro exitoso");
            }
            Conexion.close(con);
            Conexion.close(st);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // modificar
    public void modificar(favoritosJB favoritos) {
        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(modificar);
            st.setInt(1, favoritos.getID_Favoritos());
            st.setInt(2, favoritos.getID_Usuario());
            st.setInt(3, favoritos.getID_Recetas());
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
    public void eliminar(favoritosJB favoritos) {
        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(eliminar);
            st.setInt(1, favoritos.getID_Favoritos());
            if (st.executeUpdate() == 1) {
                System.out.println("registro eliminado");
            }
            Conexion.close(con);
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
