package org.xflash.edd.edd2018_3.browser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xflash.edd.edd2018_3.GridFixtures;
import org.xflash.edd.edd2018_3.model.Coord;
import org.xflash.edd.edd2018_3.model.Grid;
import org.xflash.edd.edd2018_3.model.GridSegment;

import java.util.Collection;
import java.util.Optional;

public class GridBrowserTest {

    private GridBrowser gb;

    @Before
    public void setup() {
        Grid grid1 = GridFixtures.createTestGrid();
        gb = new GridBrowser(grid1);
    }

    @Test
    public void findCoords() throws Exception {
//        assertValIn(-1, Coord.c(4, 1));
        assertValIn(1, Coord.c(4, 1));
        assertValIn(2, Coord.c(5, 3));
        assertValIn(3, Coord.c(1, 5));
        assertValIn(4, Coord.c(1, 2));
        assertValIn(5, Coord.c(2, 1));
        assertValIn(6, Coord.c(1, 0));
        assertNoValFor(7);
    }

    @Test
    public void buildOptions() throws Exception {
        Collection<GridSegment> segments = gb.buildOptions(1, Coord.c(0, 0));
        System.out.println("segments = " + segments);
        Assert.assertEquals(5, segments.size());
        Assert.assertTrue(segments.contains(GridSegment.c(Coord.c(0, 0), Coord.c(0, 1))));
        Assert.assertTrue(segments.contains(GridSegment.c(Coord.c(0, 0), Coord.c(0, 2))));
        Assert.assertTrue(segments.contains(GridSegment.c(Coord.c(0, 0), Coord.c(0, 3))));
        Assert.assertTrue(segments.contains(GridSegment.c(Coord.c(0, 0), Coord.c(0, 4))));
        Assert.assertTrue(segments.contains(GridSegment.c(Coord.c(0, 0), Coord.c(0, 5))));


    }

    @Test
    public void buildOptionsIncludingCross() throws Exception {
        Collection<GridSegment> segments = gb.buildOptions(1, Coord.c(1, 5));
        System.out.println("segments = " + segments);
//        Assert.assertEquals(5, segments.size());
        Assert.assertTrue(segments.contains(GridSegment.c(Coord.c(0, 0), Coord.c(0, 1))));
        Assert.assertTrue(segments.contains(GridSegment.c(Coord.c(0, 0), Coord.c(0, 2))));
        Assert.assertTrue(segments.contains(GridSegment.c(Coord.c(0, 0), Coord.c(0, 3))));
        Assert.assertTrue(segments.contains(GridSegment.c(Coord.c(0, 0), Coord.c(0, 4))));
        Assert.assertTrue(segments.contains(GridSegment.c(Coord.c(0, 0), Coord.c(0, 5))));

    }

    @Test
    public void findCross() throws Exception {
        Collection<Coord> coords = gb.listCross();
        System.out.println("coords = " + coords);
        Assert.assertEquals(2, coords.size());
        Assert.assertTrue(coords.contains(Coord.c(1, 3)));
        Assert.assertTrue(coords.contains(Coord.c(3, 4)));
    }

    private void assertNoValFor(int val) {
        Assert.assertFalse(gb.findCoord(val).isPresent());
    }

    private void assertValIn(final int val, final Coord c) {
        Optional<Coord> coord = gb.findCoord(val);
        Assert.assertTrue(coord.isPresent());
        Assert.assertEquals(c, coord.get());
    }

}