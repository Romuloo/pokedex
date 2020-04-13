/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.stats;
import DAO.Conexion;

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

    private String path, name, categoria;
    private double peso, altura;
    private int id, ps, at, def, ate, defe, vel;


    private ArrayList<Integer> tipo = new ArrayList<>();
    private ArrayList<Integer> lineaEvo=new ArrayList<>();

    private ArrayList<Integer> inmus = new ArrayList<>();
    private ArrayList<Integer> efis = new ArrayList<>();
    private ArrayList<Integer> debs = new ArrayList<>();

    public Pokemon(){
    }


    public ArrayList<Integer> getInmus() {
        return inmus;
    }

    public void setInmus(ArrayList<Integer> inmus) {
        this.inmus = inmus;
    }

    public ArrayList<Integer> getEfis() {
        return efis;
    }

    public void setEfis(ArrayList<Integer> efis) {
        this.efis = efis;
    }

    public ArrayList<Integer> getDebs() {
        return debs;
    }

    public void setDebs(ArrayList<Integer> debs) {
        this.debs = debs;
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
    public ArrayList getLineaEvo() {
        return this.lineaEvo;
    }




}
