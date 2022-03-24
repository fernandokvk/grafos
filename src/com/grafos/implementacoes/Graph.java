package com.grafos.implementacoes;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    public ArrayList<Vertex> vertexesArray = new ArrayList<>();
    public int size;
    public String name;

    public Graph(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public enum Color {
        WHITE,
        GRAY,
        BLACK
    }

    public static class Vertex {
        public String name;
        public int depth;
        public int grauSaida;
        public int grauEntrada;
        HashMap<Vertex, Integer> listaAdj = new HashMap<>();
        Vertex pai;
        Color color;

        public Vertex() {
        }

        public Vertex(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "name='" + name + '\'' +
                    ", depth=" + depth +
                    ", grauSaida=" + grauSaida +
                    ", grauEntrada=" + grauEntrada +
                    ", pai=" + pai +
                    ", color=" + color +
                    '}';
        }
    }

    public void addEdge(Vertex u, Vertex v, int weight) {


        if (vertexesArray.stream().noneMatch(t -> t.name.equals(u.name))) vertexesArray.add(u);
        if (vertexesArray.stream().noneMatch(t -> t.name.equals(v.name))) vertexesArray.add(v);

        for (Vertex k:
             vertexesArray) {

            if (k.name.equals(u.name)){
                k.listaAdj.put(v ,weight);
            }

        }




//        else {
//            vertexesArray.stream().peek(t -> t.name.equals(u.name)).findAny().get().listaAdj.put(v, weight);
//        }


    }

}
