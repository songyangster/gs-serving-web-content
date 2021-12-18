package com.leetcode.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    @Test
    public void testGraph() {
        Graph graph = createGraph();
        assertEquals("[Bob, Rob, Maria, Alice, Mark]", graph.depthFirstTraversal(new Graph.Vertex("Bob")).toString());
        assertEquals("[Bob, Alice, Rob, Mark, Maria]", graph.breadthFirstTraversal(new Graph.Vertex("Bob")).toString());
    }

    Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }

}
