package com.leetcode.exercise;

/*
While your players are waiting for a game, you've developed a solitaire game for the players to pass the time with.
The player is given an NxM board of tiles from 0 to 9 like this:
  4   4   4   4
  5   5   5   4
  2   5   7   5
The player selects one of these tiles, and that tile will disappear, along with any tiles with the same number that are connected with that tile (up, down, left, or right), and any tiles with the same number connected with those, and so on. For example, if the 4 in the upper left corner is selected, these five tiles disappear
 >4< >4< >4< >4<
  5   5   5  >4<
  2   5   7   5
If the 5 just below it is selected, these four tiles disappear. Note that tiles are not connected diagonally.
  4   4   4   4
 >5< >5< >5<  4
  2  >5<  7   5
Write a function that, given a grid of tiles and a selected row and column of a tile, returns how many tiles will disappear.
grid1 = [[4, 4, 4, 4],
         [5, 5, 5, 4],
         [2, 5, 7, 5]]
disappear(grid1, 0, 0)  => 5
disappear(grid1, 1, 1)  => 4
disappear(grid1, 1, 0)  => 4
This is the grid from above.

Additional Inputs
grid2 = [[0, 3, 3, 3, 3, 3, 3],
         [0, 1, 1, 1, 1, 1, 3],
         [0, 2, 2, 0, 2, 1, 4],
         [0, 1, 2, 2, 2, 1, 3],
         [0, 1, 1, 1, 1, 1, 3],
         [0, 0, 0, 0, 0, 0, 0]]

grid3 = [[0]]

grid4 = [[1, 1, 1],
         [1, 1, 1],
         [1, 1, 1]]

All Test Cases
disappear(grid1, 0, 0)  => 5
disappear(grid1, 1, 1)  => 4
disappear(grid1, 1, 0)  => 4
disappear(grid2, 0, 0)  => 12
disappear(grid2, 3, 0)  => 12
disappear(grid2, 1, 1)  => 13
disappear(grid2, 2, 2)  => 6
disappear(grid2, 0, 3)  => 7
disappear(grid3, 0, 0)  => 1
disappear(grid4, 0, 0)  => 9

N - Width of the grid
M - Height of the grid




*/

import com.leetcode.exercise.datastructure.Graph;
import com.leetcode.exercise.datastructure.Point;
import com.leetcode.exercise.datastructure.Vertex;

import java.io.*;
import java.util.*;

public class Dispear {

    public static void main(String[] argv) {
//     for (int i = 1; i <= 16; i ++) {
//       String tile = "tiles" + i;
//       System.out.println("Hand is Full for tile" + i + " = " + isHand(tiles[i]));
//     }
    }

    private static boolean isHand (String s) {
        Map<Character, Integer> cMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!cMap.containsKey(c)) cMap.put(c, 0);
            cMap.put(c, cMap.get(c) + 1);
        }

        int pair = 0;
        for (Map.Entry<Character, Integer> e : cMap.entrySet()) {
            int count = e.getValue();
            int r = count % 3;
            if (r == 1) return false;
            if (r == 2) pair++;
            if (pair > 1) return false;
        }

        return pair == 1;
    }


    public int disappear(int[][]grid, int x, int y) {
        Graph g = new Graph();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Vertex<Point> vertex1 = new Vertex<>(new Point(i, j));
                if (!g.getAdjVertices().containsKey(vertex1)) g.addVertex(vertex1);
                if (i + 1 < grid.length && grid[i][j] == grid[i + 1][j]) {
                    Vertex<Point> vertex2 = new Vertex<>(new Point(i + 1, j));
                    if (!g.getAdjVertices().containsKey(vertex2)) g.addVertex(vertex2);
                    g.addEdge(vertex1, vertex2);
                }
                if (j + 1 < grid[0].length && grid[i][j] == grid[i][j + 1]) {
                    Vertex<Point> vertex2 = new Vertex<>(new Point(i, j + 1));
                    if (!g.getAdjVertices().containsKey(vertex2)) g.addVertex(vertex2);
                    g.addEdge(vertex1, vertex2);
                }
            }
        }

        Vertex<Point> vertex = new Vertex<>(new Point(x, y));
        Set<Vertex> visited = g.depthFirstTraversal(vertex);
        return visited.size();
    }

//    private static int disappear(int[][]grid, int i, int j) {
//        int[][] dp = new int[grid.length][grid[0].length];
//        return travese(grid, dp, i, j);
//    }
//
//    // direction 1 left, 2, right, 3 up, 4 down
//    private static int travese(int[][] grid, int[][] dp, int i, int j) {
//        int subtotal = 0;
//        if (i > 0) {
//            if (dp[i - 1][j] > 0 ) {
//                subtotal += dp[i - 1][j];
//            } else {
//                if (grid[i - 1][j] == grid[i][j]) {
//                    subtotal += travese(grid, dp, i - 1, j);
//                } else {
//                    dp[i - 1][j] = -1;
//                }
//            }
//        }
//    }
//
//    // replicate 3 times
//   return subtotal;
//
//}
//  }
//          }
}