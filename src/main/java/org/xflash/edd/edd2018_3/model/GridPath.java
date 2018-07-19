package org.xflash.edd.edd2018_3.model;

import java.util.ArrayList;
import java.util.List;

public class GridPath {
    final PathNode from;
    final PathNode to;
    final List<Segment> segments = new ArrayList<>();

    private GridPath(PathNode from, PathNode to) {
        this.from = from;
        this.to = to;
    }

    public static GridPath c(PathNode from, PathNode to) {
        return new GridPath(from, to);
    }

    public void addSegment(Segment segment) {
        segments.add(segment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GridPath gridPath = (GridPath) o;

        if (from != null ? !from.equals(gridPath.from) : gridPath.from != null) return false;
        if (to != null ? !to.equals(gridPath.to) : gridPath.to != null) return false;
        return segments.equals(gridPath.segments);
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + segments.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "[" + from + " - " + to + " segments " + segments + "]";
    }
}
