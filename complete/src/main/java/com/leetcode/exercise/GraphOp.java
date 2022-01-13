package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.Graph;
import com.leetcode.exercise.datastructure.Point;
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

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Graph graph = new Graph();
        Vertex<String> bv = new Vertex<>(beginWord);
        graph.addVertex(bv);
        Vertex<String> ev = null;
        for (String s : wordList) {
            Vertex<String> vertex = new Vertex(s);
            graph.addVertex(vertex);
            if (s.equals(endWord)) {
                ev = vertex;
            }
        }
        if (ev == null) return 0;

        List<Vertex> vertices = new ArrayList<>(graph.getAdjVertices().keySet());
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = i + 1; j < vertices.size(); j++) {
                Vertex v1 = vertices.get(i);
                Vertex v2 = vertices.get(j);
                if (isEdge(v1, v2)) {
                    graph.addEdge(v1, v2);
                }
            }
        }

        return breadthFirstTraversal(graph, bv, ev);
    }

    private int breadthFirstTraversal(Graph g, Vertex begin, Vertex end) {
        Set<Vertex> visited = new LinkedHashSet<Vertex>();
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(begin);
        visited.add(begin);
        int n = 0;
        while (!queue.isEmpty()) {
            n++;
            int level_size = queue.size();
            while (level_size-- > 0) {
                Vertex vertex = queue.poll();
                for (Vertex v : g.getAdjVertices(vertex)) {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        queue.add(v);
                        if (v.equals(end)) return n + 1;
                    }
                }
            }
        }
        return 0;
    }

    private boolean isEdge(Vertex<String> v1, Vertex<String> v2) {
        String s1 = v1.getValue();
        String s2 = v2.getValue();
        int c = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) c++;
            if (c > 1) return false;
        }
        return c == 1;
    }

    public int minKnightMoves(int x, int y) {
        Point start = new Point(0, 0);
        Point end = new Point(x, y);
        return breadthFirstKnight(start, end);
    }

    private int breadthFirstKnight(Point start, Point end) {
        Set<Point> visited = new LinkedHashSet<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        int n = 0;
        while (!queue.isEmpty()) {
            n++;
            int level_size = queue.size();
            while (level_size-- > 0) {
                Point vertex = queue.poll();
                for (Point v : getAdjVertices(vertex)) {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        queue.add(v);
                        if (v.equals(end)) return n + 1;
                    }
                }
            }
        }
        return 0;
    }

    Set<Point> getAdjVertices(Point p) {
        Set<Point> adjSet = new HashSet<>();
        int x = p.getX();
        int y = p.getY();
        adjSet.add(new Point(x - 2, y - 1));
        adjSet.add(new Point(x - 2, y + 1));
        adjSet.add(new Point(x + 2, y - 1));
        adjSet.add(new Point(x + 2, y + 1));
        adjSet.add(new Point(x - 1, y - 2));
        adjSet.add(new Point(x - 1, y + 2));
        adjSet.add(new Point(x + 1, y - 2));
        adjSet.add(new Point(x + 1, y + 2));
        return adjSet;
    }

    public int longestStrChain(String[] words) {
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> noStart = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j ++) {
                int link = isLink(words[i], words[j]);
                if (link != 0) {
                    String wStart = link > 0 ? words[i] : words[j];
                    String wEnd = link > 0 ? words[j] : words[i];
                    if (!map.containsKey(wStart)) map.put(wStart, new HashSet<>());
                    map.get(wStart).add(wEnd);
                    noStart.add(wEnd);
                }
            }
        }

        Set<String> starts = new HashSet<>();
        starts.addAll(map.keySet());
        starts.removeAll(noStart);

        return 0;
    }

    private int isLink(String w1, String w2) {
        int val = 0;
        if (Math.abs(w1.length() - w2.length()) != 1) {
            return 0;
        } else {
            String wl, ws;
            if (w1.length() > w2.length()) {
                wl = w1;
                ws = w2;
                val = -1;
            } else {
                wl = w2;
                ws = w1;
                val = 1;
            }
            int mismatch = 0;
            int i = 0, j = 0;
            while (i < wl.length() && j < ws.length()) {
                if (w1.charAt(i) != ws.charAt(j)) {
                    mismatch++;
                    if (mismatch > 1) return 0;
                    i++;
                } else {
                    i++;
                    j++;
                }
            }
            return val;
        }
    }

}
