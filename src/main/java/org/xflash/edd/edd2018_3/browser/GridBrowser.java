package org.xflash.edd.edd2018_3.browser;

import org.xflash.edd.edd2018_3.model.Coord;
import org.xflash.edd.edd2018_3.model.Grid;
import org.xflash.edd.edd2018_3.model.Segment;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GridBrowser {
    private final Grid grid;
    private List<Coord> coords;

    public GridBrowser(Grid grid) {
        this.grid = grid;
        coords = buildCoords();
    }

    /*
    https://blog.codefx.org/java/stream-findfirst-findany-reduce/
     */
    public Optional<Coord> findCoord(int val) {
        return streamCells()
                .filter(c -> pick(c) == val)
                .reduce((c, other) -> {
                    throw new IllegalArgumentException("Multiple coord found for val " + val + " - " + c + " and " + other);
                });
    }

    public Collection<Coord> listCross() {
        return streamCells()
                .filter(c -> pick(c) == -1)
                .collect(Collectors.toList());
    }

    public int pick(Coord coord) {
        return grid.cells[coord.y][coord.x];
    }

    private Stream<Coord> streamCells() {
        return coords.stream();
    }

    private List<Coord> buildCoords() {
        List<Coord> coords = new ArrayList<>();
        for (int y = 0; y < grid.h; y++) {
            for (int x = 0; x < grid.w; x++) {
                coords.add(Coord.c(x, y));
            }
        }
        return coords;
    }

    public Coord findMandatoryCoordFor(final int val) {
        Optional<Coord> opt = findCoord(val);
        if (!opt.isPresent())
            throw new IllegalArgumentException("no value " + val + " for this grid");
        return opt.get();
    }

    public Collection<Segment> buildOptions(int initial, Coord coord) {

        List<Segment> segs = new ArrayList<>();

        Set<Coord> crosses = new HashSet<Coord>();
        for (int x = 0; x < coord.x; x++) {
            Coord c = Coord.c(x, coord.y);
            Collection<Segment> segs2 = ensure4(c, coord, initial, crosses);
            if (segs2 == null)
                break;
            segs.addAll(segs2);
        }
        for (int x = coord.x; x < grid.w; x++) {
            Coord c = Coord.c(x, coord.y);
            Collection<Segment> segs2 = ensure4(c, coord, initial, crosses);
            if (segs2 == null)
                break;
            segs.addAll(segs2);
        }
        for (int y = 0; y < coord.y; y++) {
            Coord c = Coord.c(coord.x, y);
            Collection<Segment> segs2 = ensure4(c, coord, initial, crosses);
            if (segs2 == null)
                break;
            segs.addAll(segs2);
        }
        for (int y = coord.y; y < grid.h; y++) {
            Coord c = Coord.c(coord.x, y);
            Collection<Segment> segs2 = ensure4(c, coord, initial, crosses);
            if (segs2 == null)
                break;
            segs.addAll(segs2);
        }

        return segs;
    }

    Collection<Segment> ensure4(Coord c, Coord coord, int initial, Set<Coord> crosses) {
        ArrayList<Segment> segs = new ArrayList<>();
        if (c.equals(coord)) return Collections.emptyList();

        int pick = pick(c);
        if (pick > initial + 1)
            return null;
        if (pick == initial + 1 || pick == 0 || (pick == -1 && !crosses.contains(c))) {
            segs.add(Segment.c(coord, c));
            if (pick == -1) {
                crosses.add(c);
            }
        }


        return segs;
    }


}
