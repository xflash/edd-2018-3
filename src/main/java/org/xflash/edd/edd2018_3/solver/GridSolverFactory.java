package org.xflash.edd.edd2018_3.solver;

import org.xflash.edd.edd2018_3.model.Grid;

public class GridSolverFactory {
    public static GridSolver bruteForce(Grid grid) {
        return new BrutforceGridSolver(grid);
    }
}
