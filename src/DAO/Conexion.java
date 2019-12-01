/**
 Copyright [2019] [Andres Iturria Soler, Javier Linares Castrillon, Samuel Aragones Lozano]
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */

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
