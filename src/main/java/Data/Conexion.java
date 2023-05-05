package Data;

import java.sql.*;

public class Conexion {
    private static final String user="postgres";
    private static final String password="131001";
    private static final String bd="recetas_cocina";
    private static final String server="jdbc:postgresql://localhost:5432/"+bd;
    private static final String driver="org.postgresql.Driver";

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(server, user, password);
        } catch (SQLException ex) {
            System.out.println("Error al intentar conectarse a la BD" + server);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public static void close(ResultSet result){
        try {
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void close(Statement state){
        try {
            state.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}