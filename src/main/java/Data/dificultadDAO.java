package Data;

import java.util.*;

import Controller.Conexion;

import java.sql.*;
import Model.dificultadJB;

public class dificultadDAO {
    public static final String selecionar = "select * from dificultades order by dificultad";

    // seleccionar
    public List<dificultadJB> Select() {
        Statement st;
        ResultSet rs;
        dificultadJB dif;

        List<dificultadJB> dificultades = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(selecionar);
            while (rs.next()) {
                int ID_Dificultad = rs.getInt("ID_Dificultad");
                String dificultad = rs.getString("dificultad");

                dif=new dificultadJB(ID_Dificultad, dificultad);
                dificultades.add(dif);
            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dificultades;
    }
}
