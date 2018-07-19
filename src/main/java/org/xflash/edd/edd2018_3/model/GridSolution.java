package org.xflash.edd.edd2018_3.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GridSolution implements Iterable<GridPath> {

    private List<GridPath> paths = new ArrayList<>();

    public GridSolution() {

    }

    @Override
    public Iterator<GridPath> iterator() {
        return paths.listIterator();
    }
}
