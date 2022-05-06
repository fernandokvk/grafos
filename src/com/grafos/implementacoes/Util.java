package com.grafos.implementacoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Util {

    static ArrayList<Graph.Vertex> Q = new ArrayList<>();


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

            u.listaAdj.keySet().forEach(t -> t.grauEntrada++);

        }

    }

    public static void dfs(Graph grafo) {

        int tempo = 0;

        for (Graph.Vertex v : grafo.vertexesArray) {
            v.depth = Integer.MAX_VALUE;
            v.color = Graph.Color.WHITE;

        }

        for (Graph.Vertex v : grafo.vertexesArray) {
            if (v.color == Graph.Color.WHITE) {
                dfsVisit(v, tempo);
            }
        }
    }

    private static void dfsVisit(Graph.Vertex v, int tempo) {
        tempo++;
        v.color = Graph.Color.GRAY;
        v.depth = tempo;
        HashMap<Integer, Graph.Vertex> mapa = new HashMap<>();
        for (Graph.Vertex u : v.listaAdj.keySet()) {
               mapa.put(v.listaAdj.get(u), u);
            if (!mapa.isEmpty()){
                int minDist = Collections.min(mapa.keySet());
                Graph.Vertex minVertex = mapa.get(minDist);

                if (minVertex.color == Graph.Color.WHITE) {
                    System.out.println(v.name + ">" + minVertex.name);
                    minVertex.pai = v;
                    dfsVisit(minVertex, tempo);
                }
            }
        }
        v.color = Graph.Color.BLACK;
        tempo++;
    }

    public static void bfs(Graph grafo, Graph.Vertex origem) {

        for (Graph.Vertex v : grafo.vertexesArray) {
            if (v != origem) {
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

    public static boolean containsPair(List<Pair> list, Pair pair){
        for (Pair p: list) {
            if ((p.u == pair.u && p.v == pair.v) || (p.u == pair.v && p.v == pair.u)) return true;
        }
        return false;
    }
}
