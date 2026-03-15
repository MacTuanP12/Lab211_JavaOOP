package test;

import graph.*;
import util.*;
import java.util.List;
import java.util.Arrays;

public class GraphTest {

    public static void run() {
        testNumberOfIslands();
        testRottingOranges();
    }

    private static void testNumberOfIslands() {
        System.out.println("==== Number Of Islands ====");
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '1', '0', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '0', '1'}
        };
        int result = solution.numIslands(grid);
        System.out.println(result);
    }

    private static void testRottingOranges() {
        System.out.println("==== Rotting Oranges ====");
        RottingOranges solution = new RottingOranges();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(solution.orangesRotting(grid));
    }
}

