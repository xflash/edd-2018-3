package org.xflash.edd.edd2018_3;

import org.xflash.edd.edd2018_3.model.Grid;

public class GridFixtures {
    public static Grid createTestGrid() {
        return new Grid(new int[][]{
                {0, 6, 0, 0, 0, 0},
                {0, 0, 5, 0, 1, 0},
                {0, 4, 0, 0, 0, 0},
                {0, -1, 0, 0, 0, 2},
                {0, 0, 0, -1, 0, 0},
                {0, 3, 0, 0, 0, 0},
        });
    }
}
