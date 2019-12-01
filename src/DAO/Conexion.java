package DAO;

import java.sql.*;

public class Conexion {

    public static Connection conectar() {

        Connection con = null;
        Statement stmt = null;
        String url = "jdbc:sqlite:/Users/javier/Desktop/1ß Cuatri/practicaMTP_03/pokedexMTP/dataBase/Pokedex.db";

        try {
                Class.forName("org.sqlite.JDBC");
                 con = DriverManager.getConnection(url);
                 stmt = con.createStatement();
                 ResultSet resultado = stmt.executeQuery("select * from pokemon");


        } catch (Exception e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        return con;
    }

    //public static get
}
