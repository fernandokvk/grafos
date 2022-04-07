package com.grafos.implementacoes;

public class MinimalPathAlgorithms {
    private Graph g;

    public MinimalPathAlgorithms(Graph g) {
        this.g = g;
    }

    private static void initializeSingleSource(Graph g, Graph.Vertex s) {
        for (Graph.Vertex v : g.vertexesArray) {
            v.depth = Integer.MAX_VALUE;
        }
        s.depth = 0;
    }

    private static void relax(Graph.Vertex u, Graph.Vertex v) {

        if (u.listaAdj.containsKey(v)){
            if (v.depth > u.depth + u.listaAdj.get(v)) {
                v.depth = u.depth + u.listaAdj.get(v);
                v.pai = u;
            }
        }



    }

    public static void relaxGraph(Graph g) {

        for (Graph.Vertex u : g.vertexesArray) {
            for (Graph.Vertex v : u.listaAdj.keySet()) {
                relax(u, v);
            }
        }

    }

    public boolean bellman_ford(Graph g, Graph.Vertex s){
        initializeSingleSource(g, s);
        relaxGraph(g);

        for (Graph.Vertex u: g.vertexesArray) {
            for (Graph.Vertex v: u.listaAdj.keySet()) {
                if (v.depth > u.depth + u.listaAdj.get(v)) return false;
            }
        }
        return true;
    }


}
