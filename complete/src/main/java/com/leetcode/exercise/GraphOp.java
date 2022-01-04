package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.Graph;
import com.leetcode.exercise.datastructure.Vertex;

import java.util.*;

public class GraphOp {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 1 ) return true;
        if (edges == null || edges.length == 0) return false;
        Set<Vertex> visited = new LinkedHashSet<Vertex>();
        Graph graph = new Graph();
        Vertex root = fillGraph(edges, graph);
        return isTreeDepthFirstTraversal(graph, root, visited) && visited.size() == n;
    }

    private Vertex fillGraph(int[][] edges, Graph graph) {
        Vertex root = null;
        for (int[] edge : edges) {
            Vertex v1 = new Vertex(edge[0]);
            Vertex v2 = new Vertex(edge[1]);
            graph.addVertex(v1);
            graph.addVertex(v2);
            graph.addEdge(v1, v2);
            if (root == null) root = v1;
        }
        return root;
    }

    private boolean isTreeDepthFirstTraversal(Graph g, Vertex root, Set<Vertex> visited) {
        Stack<Vertex> stack = new Stack<Vertex>();
        stack.push(root);
        Map<Vertex, Vertex> parent = new HashMap<>();
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : g.getAdjVertices(vertex)) {
                    stack.push(v);
                    if (!v.equals(parent.get(vertex)) && visited.contains(v)) {
                        return false;
                    }
                    parent.put(v, vertex);
                }
            }
        }
        return true;
    }

    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return n;
        Graph graph = new Graph();
        fillGraph(edges, graph);
        Set<Vertex> vertices = new HashSet<>(graph.getAdjVertices().keySet());
        int count = n - vertices.size();
        while(!vertices.isEmpty()) {
            Vertex root = vertices.iterator().next();
            Set<Vertex> visited = new LinkedHashSet<Vertex>();
            depthFirstTraversal(graph, root, visited);
            vertices.removeAll(visited);
            count++;
        }
        return count;
    }

    private void depthFirstTraversal(Graph g, Vertex root, Set<Vertex> visited) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : g.getAdjVertices(vertex)) {
                    if (!visited.contains(v)) stack.push(v);
                }
            }
        }
    }

}
