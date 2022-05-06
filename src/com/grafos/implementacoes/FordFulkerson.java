package com.grafos.implementacoes;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.min;

public class FordFulkerson {
    private final Graph graph;
    private ArrayList<Graph.Vertex> network;
    private ArrayList<Graph.Vertex> queue = new ArrayList<>();
    private Graph.Vertex source;
    private Graph.Vertex sink;
    private int maxFlow = 0;


    public FordFulkerson(Graph graph) {
        this.graph = graph;
        this.network = graph.vertexesArray;
        initialize();
    }

    /**
     * A partir dos valores do arquivo txt, transfere cada valor para a capacidade correspondente.
     * Os valores em listaAdj serão utilizados para indicar o fluxo na aresta.
     * Já os valores em capacity, a capacidade máxima da aresta.
     * Também (tenta) atribuir os vértices de fonte e sumidouro
     */
    private void initialize() {
        for (Graph.Vertex u : graph.vertexesArray) {
            for (Graph.Vertex v : u.listaAdj.keySet()) {
                u.capacity.put(v, u.listaAdj.get(v));
                u.listaAdj.replace(v, 0);
            }
        }
        for (Graph.Vertex v : network) {
            if (v.name.equals("s")) source = v;
            else if (v.name.equals("t")) sink = v;
        }
    }

    public void run() {

        while (bfs()) {
            ArrayList<Graph.Vertex> path = new ArrayList<>();
            int flow = Integer.MAX_VALUE / 2;
            Graph.Vertex v = sink;
            Graph.Vertex u;

            //Montando o caminho ao mesmo tempo que verifica-se o valor do gargalo
            while (v != source) {
                u = v.pai;
                path.add(u);
                flow = min(flow, u.capacity.get(v) - u.listaAdj.get(v));
                v = v.pai;
            }

            //O caminho montado está de trás pra frente
            Collections.reverse(path);

            //Atualizando os valores em todas as arestas do caminho para o flow (gargalo)
            for (int i = 0; i < path.size() - 1; i++) {
                u = path.get(i);
                v = path.get(i + 1);
                u.listaAdj.replace(v, flow + u.listaAdj.get(v));
            }
            v.listaAdj.replace(sink, flow + v.listaAdj.get(sink));

            maxFlow += flow;
        }
        printResult();
    }

    private void printResult() {
        String divider = "---------------------------------------------------";
        System.out.println(divider.concat(divider));
        System.out.println("Grafo: " + graph.name + " | Ford-Fulkerson");
        System.out.println("Fluxo máximo: " + maxFlow);
        for (Graph.Vertex u : network) {
            for (Graph.Vertex v : u.listaAdj.keySet()) {
                System.out.printf("<%s (%02d/%02d) %s> ", String.format("%-2s", u.name), u.listaAdj.get(v), u.capacity.get(v), String.format("%2s", v.name));
            }
            System.out.println();
        }
    }


    public boolean bfs() {
        for (Graph.Vertex v : network) {
            if (v != source) {
                v.color = Graph.Color.WHITE;
            }
        }
        source.depth = 0;
        source.color = Graph.Color.GRAY;
        queue.add(source);
        Graph.Vertex u = new Graph.Vertex();

        while (!queue.isEmpty()) {

            u = queue.remove(0);

            for (Graph.Vertex v : u.listaAdj.keySet()) {
                if (v.color == Graph.Color.WHITE && residual(u, v) > 0) {
                    v.depth = u.depth + 1;
                    v.pai = u;
                    v.color = Graph.Color.GRAY;
                    queue.add(v);
                }
            }
        }
        if (sink.color == Graph.Color.GRAY) {
            return true;
        } else {
            return false;
        }


       /* while (!Q.isEmpty()) {

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
        }
        System.out.println("FordFulkerson.bfs");*/
    }

    private int residual(Graph.Vertex u, Graph.Vertex v) {
        return (u.capacity.get(v) - u.listaAdj.get(v));
    }
}
