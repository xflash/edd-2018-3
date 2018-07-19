package org.xflash.edd.edd2018_3.solver;

import org.xflash.edd.edd2018_3.browser.GridBrowser;
import org.xflash.edd.edd2018_3.model.Coord;
import org.xflash.edd.edd2018_3.model.Grid;
import org.xflash.edd.edd2018_3.model.GridSolution;

import java.util.List;

class BrutforceGridSolver implements GridSolver {
    private final Grid grid;

    BrutforceGridSolver(Grid grid) {
        this.grid = grid;
    }

    @Override
    public List<GridSolution> solve() {
        GridBrowser gb = new GridBrowser(grid);
        Coord start = gb.findMandatoryCoordFor(1);
        gb.buildOptions(1, start);

        return null;
    }

}
