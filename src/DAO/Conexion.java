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
import java.util.ArrayList;

import domain.stats.Pokemon;
import domain.stats.Stats;

public class Conexion {
    private static Connection con = null;
    private static Statement stmt = null;


    private static Connection conectar() {


        String url = "jdbc:sqlite:dataBase/Pokedex.db";

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();


        } catch (Exception e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        return con;
    }

    public static ArrayList<String> pokemonNombres() {

        conectar();

        ArrayList<String> pokemons = new ArrayList<>();
        try {
            ResultSet resultado = stmt.executeQuery("select nombre from pokemon");

            while (resultado.next()){
                pokemons.add(resultado.getString("Nombre"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pokemons;

    }

    public static ArrayList<String> pokemonLocalizaciones(int i){

        conectar();

        ArrayList<String> pokemons = new ArrayList<>();

        try {
            ResultSet resultado = stmt.executeQuery("select p.nombre from pokemon p, localizacion l, pokemonLocalizacion pl where " +
                    "p.idPokemon = pl.idPokemon and l.idLocalizacion = pl.idLocalizacion and l.idLocalizacion = " + i);
            while (resultado.next()) {
                pokemons.add(resultado.getString("Nombre"));
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return pokemons;
    }

    public static Stats pokemonStats(String n){
        conectar();
       Stats s  = new Stats();
       String path = "";
        try {
            ResultSet resultado = stmt.executeQuery("select * from pokemon where pokemon.nombre = "+ n);
            while (resultado.next()) {

                path = "res/imagenes/fotos/" +  resultado.getInt("idPokemon");
                s.setPath(path);
                s.setName(n);
                s.setPs(resultado.getInt("Ps"));
                s.setAtaque(resultado.getInt("Ataque"));
                s.setDefensa(resultado.getInt("Defensa"));
                s.setAtaqueEsp(resultado.getInt("AtaqueEsp"));
                s.setDefensaEsp(resultado.getInt("DefensaEsp"));
                s.setVelocidad(resultado.getInt("Velocidad"));
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

}








