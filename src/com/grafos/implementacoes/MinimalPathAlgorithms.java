package com.grafos.implementacoes;

public class MinimalPathAlgorithms {
    private Graph g;

    public MinimalPathAlgorithms(Graph g) {
        this.g = g;
    }

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

    public void bellman_ford(Graph g, Graph.Vertex s){
        initializeSingleSource(g, s);
        relaxGraph(g);


        g.vertexesArray.forEach(u -> {
            u.listaAdj.keySet().forEach(v -> {
                if (v.depth > u.depth + u.listaAdj.get(v))
                    v.depth = u.depth + u.listaAdj.get(v);
            });
        });

    }


}
