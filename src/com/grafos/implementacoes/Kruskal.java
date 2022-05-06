package com.grafos.implementacoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Kruskal {
    private final Graph graph;
    private ArrayList<Pair> pairs = new ArrayList<>();
    private ArrayList<Pair> mst = new ArrayList<>();
    HashSet<Tree> disconnectedTrees = new HashSet<>();

    private class Tree {
        public Graph.Vertex vertex;
        public HashSet<Graph.Vertex> tree;

        public Tree(Graph.Vertex vertex) {
            this.vertex = vertex;
            this.tree = new HashSet<>();
            this.tree.add(vertex);
        }

    }


    public Kruskal(Graph graph) {
        this.graph = graph;
    }

    public void run() {
        for (Graph.Vertex u : graph.vertexesArray) {
            for (Graph.Vertex v : u.listaAdj.keySet()) {
                Pair pair = new Pair(u, v, u.listaAdj.get(v));
                if (!Util.containsPair(pairs, pair)) pairs.add(pair);
            }
        }

        for (Graph.Vertex v : graph.vertexesArray) {
            Tree tree = new Tree(v);
            disconnectedTrees.add(tree);
        }

        Collections.sort(pairs);
        for (int i = 0; i < pairs.size(); i++) {
            if (findSet(pairs.get(i).u) != findSet(pairs.get(i).v)) {
                mst.add(pairs.get(i));
                unionTrees(pairs.get(i).u, pairs.get(i).v);
            }
        }

        printResult();
    }

    public void printResult() {
        String divider = "---------------------------------------------------";
        System.out.println(divider.concat(divider));
        System.out.println("Grafo: " + graph.name + " | Kruskal");
        for (int i = 0; i < mst.size(); i++) {
            System.out.printf("<%s (%02d) %s> ", mst.get(i).u.name, mst.get(i).edgeWeight ,mst.get(i).v.name);
            if (i < mst.size() -1) System.out.print("| ");
        }
        System.out.println();
    }

    private void unionTrees(Graph.Vertex u, Graph.Vertex v) {
        Tree a = findSet(u);
        Tree b = findSet(v);

        if (a != null && b != null) {

            if (a.tree.size() > 1 && b.tree.size() > 1) {
                a.tree.addAll(b.tree);
                disconnectedTrees.remove(b);
            } else if (a.tree.size() == 1) {
                b.tree.add(u);
                disconnectedTrees.remove(a);
            } else {
                a.tree.add(v);
                disconnectedTrees.remove(b);
            }

        }
    }

    private Tree findSet(Graph.Vertex v) {
        for (Tree t : disconnectedTrees) {
            if (t.tree.contains(v)) return t;
        }
        return null;
    }
}
