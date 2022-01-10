package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.Graph;
import com.leetcode.exercise.datastructure.Vertex;
import com.leetcode.exercise.utilities.JSONConverter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

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

    GraphOp graphOp = new GraphOp();

    @Test
    public void testIsTree () {
        assertTrue(graphOp.validTree(5, JSONConverter.convertJSONtoInt2DArray("[[0,1],[0,2],[0,3],[1,4]]")));
        assertFalse(graphOp.validTree(5, JSONConverter.convertJSONtoInt2DArray("[[0,1],[1,2],[2,3],[1,3],[1,4]]")));
        assertFalse(graphOp.validTree(4, JSONConverter.convertJSONtoInt2DArray("[[0,1],[2,3]]")));
        assertTrue(graphOp.validTree(4, JSONConverter.convertJSONtoInt2DArray("[[0,1],[1,2],[2,3]]")));
        assertTrue(graphOp.validTree(4, JSONConverter.convertJSONtoInt2DArray("[[0,1],[2,3],[1,2]]")));
        assertTrue(graphOp.validTree(1, JSONConverter.convertJSONtoInt2DArray("[]")));
    }

    @Test
    public void testCountComponents() {
        assertEquals(2, graphOp.countComponents(4, JSONConverter.convertJSONtoInt2DArray("[[2,3],[1,2],[1,3]]")));
    }

    @Test
    public void testLadderLetter() {
        assertEquals(5, graphOp.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        assertEquals(0, graphOp.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
        assertEquals(2, graphOp.ladderLength("a", "c", Arrays.asList("a","b","c")));
        assertEquals(3, graphOp.ladderLength("hot", "dog", Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot")));
    }
}
