package org.xflash.edd.edd2018_3.model;

public class Grid {
    public int w;
    public int h;
    public int[][] cells;

    public Grid(int w, int h) {
        this.w = w;
        this.h = h;
        this.cells = new int[h][w];
    }

    public Grid(int[][] cells) {
        this.h = cells.length;
        this.w = cells[0].length;
        this.cells = cells;
    }
}
