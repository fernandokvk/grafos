package com.grafos.implementacoes;

import java.util.ArrayList;

public class Util {

    ArrayList<Graph.Vertex> Q;

    public Util() {
        Q = new ArrayList<>();
    }

    public static void calcularGraus(Graph g) {
        calcularGrauDeEntrada(g);
        calcularGrausDeSaida(g);
    }

    public static void calcularGrausDeSaida(Graph g) {
        for (Graph.Vertex v : g.vertexesArray) {
            v.grauSaida = v.listaAdj.keySet().size();
        }
    }

    public static void calcularGrauDeEntrada(Graph g) {

        for (Graph.Vertex u : g.vertexesArray) {
            for (Graph.Vertex v: u.listaAdj.keySet()) {
                v.grauEntrada+=1;
            }
        }

    }


    public void dfs(Graph grafo) {

        int tempo = 0;

        for (Graph.Vertex v : grafo.vertexesArray) {
            v.color = Graph.Color.WHITE;
        }

        for (Graph.Vertex v : grafo.vertexesArray) {
            if (v.color == Graph.Color.WHITE) {
                dfsVisit(v, tempo);
            }
        }
    }

    private void dfsVisit(Graph.Vertex v, int tempo) {
        tempo++;
        v.color = Graph.Color.GRAY;
        System.out.println(v.name + 1);
        v.depth = tempo;

        for (Graph.Vertex u : v.listaAdj.keySet()) {
            if (u.color == Graph.Color.WHITE) {
                u.pai = v;
                dfsVisit(u, tempo);
            }
        }

        v.color = Graph.Color.BLACK;
        tempo++;
    }

    public void bfs(Graph grafo, Graph.Vertex origem) {

        for (Graph.Vertex v : grafo.vertexesArray) {
            if (v != origem) {
                v.depth = -1;
                v.color = Graph.Color.WHITE;
            }
        }

        origem.depth = 0;
        origem.color = Graph.Color.GRAY;
        Q.add(origem);
        Graph.Vertex u = new Graph.Vertex();

        while (!Q.isEmpty()) {

            u = Q.remove(0);

            for (Graph.Vertex v : u.listaAdj.keySet()) {
                if (v.color == Graph.Color.WHITE) {
                    v.depth = u.depth + 1;
                    v.pai = u;
                    v.color = Graph.Color.GRAY;
                    Q.add(v);
                }
            }
            u.color = Graph.Color.BLACK;
            System.out.println(u.name);
        }
    }
}
