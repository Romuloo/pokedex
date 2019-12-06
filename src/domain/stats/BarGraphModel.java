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
package domain.stats;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 *
 */

/**
 * Clase encargada de definir el modelo para la clase Bargraph.
 */
public class BarGraphModel {

    /**
     * Esta nested class define un BarItem.
     */
    public static class BarItem {
        public int percentage;
        public int width;
        public String title;
        public Color background;

        public BarItem(String title) {
            this.title = title;
        }
    }

    public static final int DEFAULT_ITEM_WIDTH = 40;

    protected List<BarItem> items = new ArrayList<BarItem>();
    protected Point location = new Point();
    protected Dimension size = new Dimension();
    protected int horizontalGap = DEFAULT_ITEM_WIDTH * 2;

    /**
     * Constructor de BargraphModel, según Mariano, el abogado de oficio.
     */
    public BarGraphModel() {

    }

    /**
     *
     * @return el espacio entre barras.
     */
    public int getHorizontalGap() {
        return horizontalGap;
    }

    /**
     *
     * @return size definido por la clase Dimension.
     */
    public Dimension getSize() {
        return size;
    }

    /**
     * Establece el size.
     * @param width
     * @param height
     */
    public void setSize(int width, int height) {
        size.width = width;
        size.height = height;
    }

    /**
     * Establece la localización.
     * @param x
     * @param y
     */
    public void setLocation(int x, int y) {
        this.location.x = x;
        this.location.y = y;
    }

    /**
     *
     * @return la localización en x.
     */
    public int getX() {
        return location.x;
    }

    /**
     *
     * @return la localización en y.
     */
    public int getY() {
        return location.y;
    }

    /**
     * Annade un BarItem.
     * @param item
     */
    public void addItem(BarItem item) {
        item.width = item.width == 0 ? DEFAULT_ITEM_WIDTH : item.width;
        items.add(item);
    }
}
