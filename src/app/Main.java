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

package app;
import DAO.Conexion;
import app.before.Begin;

/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 * @author Samuel Aragonés Lozano
 *
 */

/**
 * Clase principal donde comienza el programa.
 */
public class Main {

    /**
     *
     * Método Main desde donde se ejecuta la app.
     */
    public static void main(String[] args){
            Conexion.conectar();
            Begin.init();
    }
}
