package domain.movimientos;

/**
 * Clase encargada de definir una Máquina téctina o Oculta. Utilizada para hacer consultas y en la clase Movimiento.
 */
public class Maquina  {

    protected String nombre;
    protected String nombreAtaque;

    public Maquina(){

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getNombreAtaque() {
        return nombreAtaque;
    }

    public void setNombreAtaque(String nombreAtaque) {
        this.nombreAtaque = nombreAtaque;
    }


    @Override
    public boolean equals(Object o) {
        Maquina maquina = (Maquina) o;
        return this.nombreAtaque.equals(maquina.getNombreAtaque());
    }

}
