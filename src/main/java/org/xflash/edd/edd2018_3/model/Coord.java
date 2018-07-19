package org.xflash.edd.edd2018_3.model;

public class Coord {

    public final int x;
    public final int y;

    private Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coord c(int x, int y) {
        return new Coord(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coord coord = (Coord) o;

        if (x != coord.x) return false;
        return y == coord.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "{" + x + "," + y + '}';
    }
}
