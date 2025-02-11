package Board;

public class Tile {
    private int value;
    private Boolean isVisible;
    private Boolean isFlagged;

    public Tile(int value) {
        this.value = value;
        this.isVisible = false;
        this.isFlagged = false;
    }

    public Tile() {
        this.value = 0;
        this.isVisible = false;
        this.isFlagged = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Boolean getIsFlagged() {
        return isFlagged;
    }
    
    public void setIsFlagged(Boolean isFlagged) {
        this.isFlagged = isFlagged;
    }
}
