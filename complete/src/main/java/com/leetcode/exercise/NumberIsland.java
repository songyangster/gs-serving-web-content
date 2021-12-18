package com.leetcode.exercise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

public class NumberIsland {
    public int numIslands(char[][] grid) {
        Set<Vertex> vertexSet = new HashSet<>();
        Set<Edge> edgeSet = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    Vertex vertex = new Vertex(i, j);
                    vertexSet.add(vertex);
                    if (j > 0 && grid[i][j -1] == '1') {
                        Vertex vertex2 = new Vertex(i, j-1);
                        addToSet(vertexSet, edgeSet, vertex, vertex2);
                    }
                    if (i > 0 && grid[i - 1][j] == '1') {
                        Vertex vertex2 = new Vertex(i - 1, j);
                        addToSet(vertexSet, edgeSet, vertex, vertex2);
                    }
                }
            }
        }

        Set<Set<Vertex>> islands = new HashSet<>();
        for (Edge edge : edgeSet) {
            Vertex vertex1 = edge.getV1();
            Vertex vertex2 = edge.getV2();
            Set<Vertex> isLand = new HashSet<Vertex>() {{
                add(vertex1);
                add(vertex2);
            }};

        }


        return 0;
    }

    private void addToSet(Set<Vertex> vertexSet, Set<Edge> edgeSet, Vertex vertex, Vertex vertex2) {
        Edge edge = new Edge(vertex, vertex2);
        vertexSet.add(vertex2);
        edgeSet.add(edge);
    }

    public static class Vertex{
        private int i;
        private int j;

        public Vertex(int i, int j){
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return i == vertex.i && j == vertex.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public String toString() {
            return "(" + i + ", " + j + ")";
        }
    }

    public static class Edge{
        private Vertex v1;
        private Vertex v2;
        public Edge(Vertex v1, Vertex v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public Vertex getV1() {
            return v1;
        }

        public Vertex getV2() {
            return v2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return Objects.equals(v1, edge.v1) && Objects.equals(v2, edge.v2) || Objects.equals(v1, edge.v2) && Objects.equals(v2, edge.v1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(v1, v2);
        }
    }
}
