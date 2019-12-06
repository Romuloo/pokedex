/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.stats;
import java.util.ArrayList;

/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 *
 */

/**
 * Clase encargada de definir un Pokemon. Utilizada para almacenar consultas.
 */
public class Pokemon {
    private int id;
    private String path, name, categoria;
    private double peso;
    private double altura;
    private int ps;
    private int at;
    private int def;
    private int ate;
    private int defe;
    private int vel;
    private ArrayList<Integer> tipo = new ArrayList<>();
    private ArrayList<Integer> lineaEvo=new ArrayList<>();


    public Pokemon(){
    }
    public Pokemon(int id, String path, String name, String categoria, double peso, double altura, int ps, int at, int def, int ate, int defe, int vel) {
        this.id = id;
        this.path = path;
        this.name = name;
        this.categoria = categoria;
        this.peso = peso;
        this.altura = altura;
        this.ps = ps;
        this.at = at;
        this.def = def;
        this.ate = ate;
        this.defe = defe;
        this.vel = vel;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setTipo(Integer tipo){
        this.tipo.add(tipo);
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }


    public void setPath(String path) {
        this.path = path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public void setAt(int at) {
        this.at = at;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setAte(int ate) {
        this.ate = ate;
    }

    public void setDefe(int defe) {
        this.defe = defe;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }


    public int getId(){
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getPs() {
        return ps;
    }

    public int getAt() {
        return at;
    }

    public int getDef() {
        return def;
    }

    public int getAte() {
        return ate;
    }

    public int getDefe() {
        return defe;
    }

    public int getVel() {
        return vel;
    }
    public Integer getTipo(int indice){
        if(this.tipo.size()-1 < indice){
            return 0;
        }
        else{
            return this.tipo.get(indice);
        }
    }
    public void setLineaEvo(int x){
        this.lineaEvo.add(x);
    }
    public ArrayList getLineaEvo(){
        return this.lineaEvo;
    }

}
