package org.xflash.edd.edd2018_3.model;

public class GridSegment {
    final Coord from;
    final Coord to;

    private GridSegment(Coord from, Coord to) {
        this.from = from;
        this.to = to;
    }

    public static GridSegment c(Coord from, Coord to) {
        return new GridSegment(from, to);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GridSegment that = (GridSegment) o;

        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        return to != null ? to.equals(that.to) : that.to == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "[" + from + " - " + to + ']';
    }
}
