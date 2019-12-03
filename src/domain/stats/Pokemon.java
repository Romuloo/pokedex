package domain.stats;

public class Pokemon {

    private String path, name, categoria;
    private double peso;
    private double altura;
    private int ps;
    private int at;
    private int def;
    private int ate;
    private int defe;
    private int vel;


    public Pokemon(){
    }
    public Pokemon(String path, String name, String categoria, double peso, double altura, int ps, int at, int def, int ate, int defe, int vel) {
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
}
