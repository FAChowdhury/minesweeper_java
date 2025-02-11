package Board;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private int width;
    private int height;
    private List<Tile> grid;
    
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new ArrayList<>(width * height);
        for (int i = 0; i < width * height; ++ i) {
            grid.add(new Tile());
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

    public int getTileValue(int x, int y) {
        if (x < 0 || x > width - 1 || y < 0 || y > height - 1) {
            return 0;
        }
        return grid.get(x * height + y).getValue();
    }

    public void setTileValue(int x, int y, int value) {
        if (x < 0 || x > width - 1 || y < 0 || y > height - 1) {
            return;
        }
        grid.set(x * height + y, new Tile(value));
    }

    public int getTileValue(int idx) {
        if (idx < 0 || idx > width * height - 1) {
            return 0;
        }
        return grid.get(idx).getValue();
    }

    public void setTileValue(int idx, int value) {
        if (idx < 0 || idx > width * height - 1) {
            return;
        }
        grid.set(idx, new Tile(value));
    }

    public int containsNegativeInt(int x, int y) {
        return getTileValue(x, y) == -1 ? 1 : 0;
    }

    public Boolean containsNegativeBool(int x, int y) {
        return getTileValue(x, y) == -1 ? true : false;
    }
}
