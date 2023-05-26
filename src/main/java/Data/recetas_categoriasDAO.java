package Data;

import java.util.*;

import Controller.Conexion;

import java.sql.*;
import Model.recetas_categoriasJB;

public class recetas_categoriasDAO {
    public static final String seleccionar = "select * from recetas_categorias order by ID_Categoria";
    public static final String insertar = "insert into recetas_categorias(ID_Recetas, ID_Categorias) values (?,?)";
    public static final String eliminar = "delete from recetas_categorias where ID_Recetas_categorias=?";
    public static final String modificar = "update recetas_categorias set ID_Recetas=?, ID_Categorias=?, where ID_Recetas_categorias=?";

    // seleccionar
    public List<recetas_categoriasJB> Select() {
        Statement st;
        ResultSet rs;
        recetas_categoriasJB rc;

        List<recetas_categoriasJB> recetas_categorias = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(seleccionar);

            while (rs.next()) {
                int ID_Recetas_categorias = rs.getInt("ID_Recetas_categorias");
                int ID_Recetas = rs.getInt("ID_Recetas");
                int ID_Categorias = rs.getInt("ID_Categorias");

                rc = new recetas_categoriasJB(ID_Recetas_categorias, ID_Recetas, ID_Categorias);
                recetas_categorias.add(rc);
            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return recetas_categorias;
    }

    // insertar
    public void insertar(recetas_categoriasJB recetas_categorias) {
        Connection con;
        PreparedStatement st;
        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insertar);
            st.setInt(1, recetas_categorias.getID_Recetas());
            st.setInt(2, recetas_categorias.getID_Categorias());

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
    public void modificar(recetas_categoriasJB recetas_categorias) {
        Connection con;
        PreparedStatement st;
        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(modificar);
            st.setInt(1, recetas_categorias.getID_Recetas_categorias());
            st.setInt(2, recetas_categorias.getID_Recetas());
            st.setInt(3, recetas_categorias.getID_Categorias());
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
    public void eliminar(recetas_categoriasJB recetas_categorias) {
        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(eliminar);
            st.setInt(1, recetas_categorias.getID_Recetas_categorias());
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
