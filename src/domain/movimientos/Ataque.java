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

package domain.movimientos;

/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 *
 */

/**
 * Clase encargada de definir un Ataque. Utilizada en las consultas.
 */

public class Ataque  {

    private String nombre;
    private String descripcion;
    private int pp;
    private int potencia;
    private int precision;
    private int prioridad;
    private String tipo;

    /**
     *
     * @return tipo del ataque.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return nombre del ataque.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return descripción del ataque.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return puntos de poder del ataque.
     */
    public int getPp() {
        return pp;
    }

    /**
     *
     * @param pp
     */
    public void setPp(int pp) {
        this.pp = pp;
    }

    /**
     *
     * @return potencia del ataque.
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     *
     * @param potencia
     */
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    /**
     *
     * @return precisión del ataque.
     */
    public int getPrecision() {
        return precision;
    }

    /**
     *
     * @param precision
     */
    public void setPrecision(int precision) {
        this.precision = precision;
    }


}
