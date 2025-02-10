package Board;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private int width;
    private int height;
    private List<Integer> grid;
    
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new ArrayList<>(width * height);
        for (int i = 0; i < width * height; ++ i) {
            grid.add(0);
        }
    }

    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int get(int x, int y) {
        if (x < 0 || x > width - 1 || y < 0 || y > height - 1) {
            return 0;
        }
        return grid.get(x * height + y);
    }

    public void set(int x, int y, int value) {
        if (x < 0 || x > width - 1 || y < 0 || y > height - 1) {
            return;
        }
        grid.set(x * height + y, value);
    }

    public int get(int idx) {
        if (idx < 0 || idx > width * height - 1) {
            return 0;
        }
        return grid.get(idx);
    }

    public void set(int idx, int value) {
        if (idx < 0 || idx > width * height - 1) {
            return;
        }
        grid.set(idx, value);
    }

    public int containsNegativeInt(int x, int y) {
        return get(x, y) == -1 ? 1 : 0;
    }

    public Boolean containsNegativeBool(int x, int y) {
        return get(x, y) == -1 ? true : false;
    }
}
