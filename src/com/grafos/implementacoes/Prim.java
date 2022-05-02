package com.grafos.implementacoes;

import java.util.ArrayList;

public class Prim{
    private Graph g;

    public Prim(Graph g){
        this.g = g;
    }

    public static void prim(Graph g, Graph.Vertex r){
        ArrayList<Vertex> q = g.vertexesArray;

        for (Graph.Vertex u: g.vertexesArray) {
            u.depth = Integer.MAX_VALUE;
            u.pai = null;
        }
        r.depth = 0;
        while ( !q.isEmpty()){
            /* u = extract-min(q)*/
            for (Graph.Vertex v: u.listaAdj.keySet()) {
                if ...
            }
        }


    }
}