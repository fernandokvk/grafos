package com.grafos.implementacoes;

public class Pair implements Comparable<Pair>{
        public Graph.Vertex u;
        public Graph.Vertex v;
        public int edgeWeight;

    public Pair(Graph.Vertex u, Graph.Vertex v, int edgeWeight) {
        this.u = u;
        this.v = v;
        this.edgeWeight = edgeWeight;
    }

    @Override
        public int compareTo(Pair o) {
            return Integer.compare(edgeWeight, o.edgeWeight);
        }
}
