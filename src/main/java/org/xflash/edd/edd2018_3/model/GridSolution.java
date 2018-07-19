package org.xflash.edd.edd2018_3.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GridSolution implements Iterable<GridSegment> {

    private List<GridSegment> segments = new ArrayList<>();

    public GridSolution() {

    }

    @Override
    public Iterator<GridSegment> iterator() {
        return segments.listIterator();
    }
}
