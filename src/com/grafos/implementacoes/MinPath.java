package com.grafos.implementacoes;

public class MinPath {
    private Grafo g;

    public MinPath(Grafo g) {
        this.g = g;
    }

    private void initializeSingleSource(Grafo g, Grafo.Vertice s) {
        for (Grafo.Vertice v : g.vertices) {
            v.depth = -1;
        }
        s.depth = 0;
    }

    private void relax(Grafo.Vertice u, Grafo.Vertice v) {

        if (v.listaAdj.containsKey(u)){
            if (v.depth > u.depth + v.listaAdj.get(u)) {
                v.depth = u.depth + v.listaAdj.get(u);
                v.pai = u;
            }
        }


    }

    public void teste() {
        initializeSingleSource(g, g.vertices.get(0));

        for (Grafo.Vertice v : g.vertices) {

            relax(v, v.listaAdj.keySet().stream().toList().get(0));

        }

    }

}
