package org.xflash.edd.edd2018_3.printer;

import org.xflash.edd.edd2018_3.model.Grid;
import org.xflash.edd.edd2018_3.model.GridSegment;
import org.xflash.edd.edd2018_3.model.GridSolution;

import java.io.PrintStream;

public class GridPrinter {
    private final Grid grid;

    public GridPrinter(Grid grid) {
        this.grid = grid;
    }

    public void print(PrintStream os) {
        printSepRow(os);
        for (int i = 0; i < grid.h; i++) {
            for (int j = 0; j < grid.w; j++) {
                os.print("|");
                int cell = grid.cells[i][j];
                if (cell == 0)
                    os.print("  ");
                else if (cell == -1)
                    os.print("+ ");
                else if (cell > 0 && cell <= 9)
                    os.print(String.format("%d ", cell));
                else if (cell > 9 && cell <= 99)
                    os.print(String.format("%d", cell));
            }
            os.println("|");
        }
        printSepRow(os);
    }

    private void printSepRow(PrintStream os) {
        os.print("+");
        for (int j = 0; j < grid.w; j++) {
            os.print("---");
        }
        os.println("+");
    }

    public void print(GridSolution solution, PrintStream out) {
        for (GridSegment segment : solution) {
            out.println(segment);
        }
    }
}
