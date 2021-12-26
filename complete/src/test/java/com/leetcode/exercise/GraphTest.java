package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.Graph;
import com.leetcode.exercise.datastructure.Vertex;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {
    Vertex bob = new Vertex("Bob");
    Vertex alice = new Vertex("Alice");
    Vertex mark = new Vertex("Mark");
    Vertex rob = new Vertex("Rob");
    Vertex maria = new Vertex("Maria");

    @Test
    public void testGraph() {

        Graph graph = createGraph();
        assertEquals("[Bob, Rob, Maria, Alice, Mark]", graph.depthFirstTraversal(new Vertex("Bob")).toString());
        assertEquals("[Bob, Alice, Rob, Mark, Maria]", graph.breadthFirstTraversal(new Vertex("Bob")).toString());
        assertEquals(new LinkedHashSet<Vertex>(){{add(bob); add(rob); add(maria); add(alice); add(mark);}}, graph.depthFirstTraversal(bob));
        assertEquals(new LinkedHashSet<Vertex>(){{add(bob); add(rob); add(maria); add(alice); add(mark);}}, graph.breadthFirstTraversal(bob));
    }

    Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex(bob);
        graph.addVertex(alice);
        graph.addVertex(mark);
        graph.addVertex(rob);
        graph.addVertex(maria);
        graph.addEdge(bob, alice);
        graph.addEdge(bob, rob);
        graph.addEdge(alice, mark);
        graph.addEdge(rob, mark);
        graph.addEdge(alice, maria);
        graph.addEdge(rob, maria);
        return graph;
    }

}
