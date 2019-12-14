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
