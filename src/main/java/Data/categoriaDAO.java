package Data;

import java.util.*;

import Controller.Conexion;

import java.sql.*;

import Model.categoriaJB;

public class categoriaDAO {
    public static final String seleccionar = "Select * from categoria order by nombre";
    public static final String insertar = "insert into categoria(nombre) values (?)";
    public static final String eliminar = "delete from categoria where ID_Categoria=?";
    public static final String modificar = "update categoria set nombre=? where ID_Categoria=?";

    // seleccionar
    public List<categoriaJB> Select() {
        Statement st;
        ResultSet rs;
        categoriaJB cat;

        List<categoriaJB> categoria = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(seleccionar);

            while (rs.next()) {
                int ID_Categoria = rs.getInt("ID_Categoria");
                String nombre = rs.getString("nombre");

                cat = new categoriaJB(ID_Categoria, nombre);
                categoria.add(cat);
            }

            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categoria;
    }

    // insertar
    public void insertar(categoriaJB categoria) {
        Connection con;
        PreparedStatement st;
        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insertar);
            st.setString(1, categoria.getNombre());

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
    public void modificar(categoriaJB categoria) {
        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(modificar);
            st.setInt(1, categoria.getID_Categoria());
            st.setString(2, categoria.getNombre());
            if (st.executeUpdate() == 1) {
                System.out.println("Registro Actualizado");
            }
            Conexion.close(con);
            Conexion.close(st);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
    }

    // eliminar
    public void eliminar(categoriaJB categoria) {
        Connection con;
        PreparedStatement st;

        try {
            con= Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(eliminar);
            st.setInt(1, categoria.getID_Categoria());
            if (st.executeUpdate()==1) {
                System.out.println("Registro  Eliminado");
            }
            Conexion.close(con);
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
