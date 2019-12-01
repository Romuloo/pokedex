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
 */
public class BarGraphModel {


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

    public BarGraphModel() {

    }

    public int getHorizontalGap() {
        return horizontalGap;
    }

    public Dimension getSize() {
        return size;
    }
    public void setSize(int width, int height) {
        size.width = width;
        size.height = height;
    }

    public void setLocation(int x, int y) {
        this.location.x = x;
        this.location.y = y;
    }

    public int getX() {
        return location.x;
    }

    public int getY() {
        return location.y;
    }

    public void addItem(BarItem item) {
        item.width = item.width == 0 ? DEFAULT_ITEM_WIDTH : item.width;
        items.add(item);
    }
}
