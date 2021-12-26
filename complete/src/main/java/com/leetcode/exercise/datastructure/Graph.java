package com.leetcode.exercise.datastructure;

import com.leetcode.exercise.datastructure.Vertex;

import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }

    public void addVertex(Vertex vertex) {
        adjVertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void removeVertex(Vertex v) {
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(v);
    }

    public void addEdge(Vertex v1, Vertex v2) {
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    public void removeEdge(Vertex v1, Vertex v2) {
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    public List<Vertex> getAdjVertices(Vertex v) {
        return adjVertices.get(v);
    }

    public Set<Vertex> depthFirstTraversal(Vertex root) {
        Set<Vertex> visited = new LinkedHashSet<Vertex>();
        Stack<Vertex> stack = new Stack<Vertex>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : getAdjVertices(vertex)) {
                    stack.push(v);
                }
            }
        }
        return visited;
    }

    public Set<Vertex> breadthFirstTraversal(Vertex root) {
        Set<Vertex> visited = new LinkedHashSet<Vertex>();
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            for (Vertex v : getAdjVertices(vertex)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
        return visited;
    }

}
