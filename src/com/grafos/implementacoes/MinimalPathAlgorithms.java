package com.grafos.implementacoes;

public class MinimalPathAlgorithms {
    private Graph g;



    private static void initializeSingleSource(Graph g, Graph.Vertex s) {
        for (Graph.Vertex v : g.vertexesArray) {
            v.depth = -1;
        }
        s.depth = 0;
    }

    private static void relax(Graph.Vertex u, Graph.Vertex v) {

        if (v.listaAdj.containsKey(u)) {
            if (v.depth > u.depth + v.listaAdj.get(u)) {
                v.depth = u.depth + v.listaAdj.get(u);
                v.pai = u;
            }
        }


    }

    public static void relaxGraph(Graph g) {
        initializeSingleSource(g, g.vertexesArray.get(0));

        for (Graph.Vertex v : g.vertexesArray) {
            for (Graph.Vertex u : v.listaAdj.keySet()) {
                relax(v, u);
            }
        }

    }

}
