package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.Graph;
import com.leetcode.exercise.datastructure.Point;
import com.leetcode.exercise.datastructure.Vertex;

import java.util.*;

public class NumberIsland {
    public int numIslands(char[][] grid) {
        Graph graph = new Graph();

        for (int i = 0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    Vertex vertex = new Vertex(new Point(i, j));
                    graph.addVertex(vertex);
                    if (j > 0 && grid[i][j -1] == '1') {
                        Vertex vertex2 = new Vertex(new Point(i, j-1));
                        graph.addEdge(vertex, vertex2);
                    }
                    if (i > 0 && grid[i - 1][j] == '1') {
                        Vertex vertex2 = new Vertex(new Point(i - 1, j));
                        graph.addEdge(vertex, vertex2);
                    }
                }
            }
        }

        LinkedHashSet<Vertex> vertexSet = new LinkedHashSet<>();
        vertexSet.addAll(graph.getAdjVertices().keySet());

        int islands = 0;
        while(!vertexSet.isEmpty()) {
            Set<Vertex> visited = graph.breadthFirstTraversal(vertexSet.iterator().next());
            islands++;
            vertexSet.removeAll(visited);
        }

        return islands;
    }

}
