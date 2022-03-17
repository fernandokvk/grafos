package com.company;

public class Grafo {
    public Vertice[] vertices;

    public Grafo(int n) {
        vertices = new Vertice[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertice(i);
        }
    }

    public void addAresta(int u, int v, int peso){
        vertices[u].listaAdj.put(vertices[v], peso);
    }

    public void addAresta(int u, int v) {
        vertices[u].adj.add(vertices[v]);
    }
}
