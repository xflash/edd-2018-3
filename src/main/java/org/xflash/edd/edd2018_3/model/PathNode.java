package org.xflash.edd.edd2018_3.model;

public class PathNode {

    private final Coord coord;
    private final int val;

    private PathNode(Coord coord, int val) {
        this.coord = coord;
        this.val = val;
    }

    public static PathNode c(Coord coord, int val) {
        return new PathNode(coord, val);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PathNode pathNode = (PathNode) o;

        if (val != pathNode.val) return false;
        return coord != null ? coord.equals(pathNode.coord) : pathNode.coord == null;
    }

    @Override
    public int hashCode() {
        int result = coord != null ? coord.hashCode() : 0;
        result = 31 * result + val;
        return result;
    }

    @Override
    public String toString() {
        return "{" + coord + " / " + val + '}';
    }
}
