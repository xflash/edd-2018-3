package org.xflash.edd.edd2018_3.reader;


import org.junit.Assert;
import org.junit.Test;
import org.xflash.edd.edd2018_3.model.Grid;

public class GridReaderTest {

    @Test
    public void checkReadingWH() throws Exception {
        Grid grid = GridReader.load("data/grid1.txt");
        Assert.assertEquals("w", 6, grid.w);
        Assert.assertEquals("h", 6, grid.h);
    }

    @Test
    public void checkReadingCells() throws Exception {
        Grid grid = GridReader.load("data/grid1.txt");
        Assert.assertArrayEquals("cells", new int[][]{
                {0, 6, 0, 0, 0, 0},
                {0, 0, 5, 0, 1, 0},
                {0, 4, 0, 0, 0, 0},
                {0, -1, 0, 0, 0, 2},
                {0, 0, 0, -1, 0, 0},
                {0, 3, 0, 0, 0, 0},

        }, grid.cells);
        Assert.assertEquals("h", 6, grid.h);
    }
}