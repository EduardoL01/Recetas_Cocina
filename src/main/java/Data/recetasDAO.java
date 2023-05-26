package Data;

import java.util.*;

import Controller.Conexion;

import java.sql.*;
import java.sql.Date;

import Model.recetasJB;

public class recetasDAO {
    public static final String seleccionar = "select * from recetas order by titulo";
    public static final String insertar = "insert into recetas(titulo, descripcion, porciones, tiempo_preparacion, ingredientes, instrucciones, ID_Usuario, ID_Dificultad) values (?,?,?,?,?,?,?,?)";
    public static final String eliminar = "delete from recetas where ID_Recetas=?";
    public static final String modificar = "update recetas set titulo=?, descripcion=?, porciones=?, tiempo_preparacion=?, ingredientes=?, instrucciones=?, ID_Usuario=?, ID_Dificultad=? where ID_Recetas=?";

    //seleccionar
    public List<recetasJB> Select() {
        Statement st;
        ResultSet rs;
        recetasJB re;

        List<recetasJB> recetas=new ArrayList<>();
        try {
            Connection con= Conexion.getConnection();
            assert con != null;
            st=con.createStatement();
            rs=st.executeQuery(seleccionar);
            while (rs.next()) {
                int ID_Recetas=rs.getInt("ID_Recetas");
                String titulo=rs.getString("titulo");
                String descripcion=rs.getString("descripcion");
                int porciones=rs.getInt("porciones");
                Time tiempo_preparacion=rs.getTime("tiempo_preparacion");
                String ingredientes=rs.getString("ingredientes");
                String instrucciones = rs.getString("instrucciones");
                Date fecha_publicacion=rs.getDate("fecha_publicacion");
                int ID_Usuario=rs.getInt("ID_Usuario");
                int ID_Dificultad=rs.getInt("ID_Dificultad");

                re=new recetasJB(ID_Recetas, titulo, descripcion, porciones, tiempo_preparacion, ingredientes, instrucciones, fecha_publicacion, ID_Usuario, ID_Dificultad);
                recetas.add(re);
            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return recetas;
    }

    // insertar
    public void insertar(recetasJB recetas) {
        Connection con;
        PreparedStatement st;
        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insertar);
            st.setString(1, recetas.getTitulo());
            st.setString(2, recetas.getDescripcion());
            st.setInt(3, recetas.getPorciones());
            st.setTime(4, recetas.getTiempo_preparacion());
            st.setString(5, recetas.getIngredientes());
            st.setString(6, recetas.getInstrucciones());
            st.setInt(7, recetas.getID_Usuario());
            st.setInt(8, recetas.getID_Dificultad());

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
    public void modificar(recetasJB recetas) {
        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(modificar);
            st.setInt(1, recetas.getID_Recetas());
            st.setString(2, recetas.getTitulo());
            st.setString(3, recetas.getDescripcion());
            st.setInt(4, recetas.getPorciones());
            st.setTime(5, recetas.getTiempo_preparacion());
            st.setString(6, recetas.getIngredientes());
            st.setString(7, recetas.getInstrucciones());
            st.setInt(8, recetas.getID_Usuario());
            st.setInt(9, recetas.getID_Dificultad());
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
    public void eliminar(recetasJB recetas) {
        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(eliminar);
            st.setInt(1, recetas.getID_Recetas());
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
