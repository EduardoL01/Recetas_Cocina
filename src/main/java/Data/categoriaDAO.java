package Data;

import java.util.*;

import java.sql.*;

import Model.categoriaJB;

public class categoriaDAO {
    public static final String seleccionar = "Select * from categoria order by categoria";
    public static final String insertar = "insert into categoria(nombre) values (?)";
    public static final String eliminar = "delete from categoria where ID_Categoria=?";
    public static final String modificar = "update categoria set categoria=? where ID_Categoria=?";

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
                String nombre = rs.getString("categoria");

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
    public void modificar(categoriaJB categoria){
        Connection con;
        PreparedStatement st;

        try {
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(modificar);
            st.setString(1, eliminar);
            st.setInt(2, categoria.getID_Categoria());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
