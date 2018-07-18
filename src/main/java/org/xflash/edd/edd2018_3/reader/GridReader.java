package org.xflash.edd.edd2018_3.reader;

import org.xflash.edd.edd2018_3.model.Grid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GridReader {
    public static Grid load(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            int[] ints = readNextIntRow(br);
            if (ints.length != 2)
                throw new IllegalArgumentException("Header line length should be 2");

            int h = ints[1];
            int w = ints[0];
            Grid grid = new Grid(w, h);
            for (int i = 0; i < h; i++) {
                System.arraycopy(readNextIntRow(br), 0, grid.cells[i], 0, w);
            }

            return grid;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static int[] readNextIntRow(BufferedReader br) throws IOException {
        String line = nextReadableLine(br);
        if (line == null) throw new IllegalArgumentException("Could not read an additional Line");
        String[] strings = line.split("\\s+");
        int[] integers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.valueOf(strings[i]);
        }
        return integers;
    }


    private static String nextReadableLine(BufferedReader br) throws IOException {
        String s = br.readLine();
        if (s == null) return null;
        while (s.trim().startsWith("#")) {
            s = br.readLine();
            if (s == null) return null;
        }

        return s.trim();
    }
}
