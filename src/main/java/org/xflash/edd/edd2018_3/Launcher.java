package org.xflash.edd.edd2018_3;

import org.xflash.edd.edd2018_3.model.Grid;
import org.xflash.edd.edd2018_3.model.GridSolution;
import org.xflash.edd.edd2018_3.printer.GridPrinter;
import org.xflash.edd.edd2018_3.reader.GridReader;
import org.xflash.edd.edd2018_3.solver.GridSolver;
import org.xflash.edd.edd2018_3.solver.GridSolverFactory;

public class Launcher {

    public static void main(String[] args) {
        Grid grid = GridReader.load("data/grid2.txt");

        GridPrinter printer = new GridPrinter(grid);
        printer.print(System.out);

        GridSolverFactory gridSolverFactory = new GridSolverFactory();

        GridSolver gridSolver = gridSolverFactory.bruteForce(grid);
        for (GridSolution solution : gridSolver.solve()) {
            printer.print(solution, System.out);
        }
    }
}
