package com.grafos.implementacoes;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    public String name;
    public int size;
    public ArrayList<Vertex> vertexesArray = new ArrayList<>();

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
        public int grauSaida = 0;
        public int grauEntrada = 0;
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
                    ", pai=" + pai() +
                    ", color=" + color +
                    '}';
        }

        public String pai(){
            if (pai != null) return pai.name;
            return null;
        }
    }

    public void addEdge(Vertex u, Vertex v, int weight) {

        if (vertexesArray.stream().noneMatch(t -> t.name.equals(u.name))) vertexesArray.add(u);
        if (vertexesArray.stream().noneMatch(t -> t.name.equals(v.name))) vertexesArray.add(v);

        for (Vertex k : vertexesArray) {
            if (k.name.equals(u.name)) {
                k.listaAdj.put(v, weight);
            }
        }
    }

    @Override
    public String toString() {
        return '\n'+"Graph{" +
                "name='" + name + '\'' +
                ", size=" + size +"}"+
                " vertexesArray:"+'\n' + arrVertex();
    }

    public String arrVertex(){
        String str = "";

        for (Graph.Vertex v: vertexesArray
             ) {
            str = str.concat(v.toString() + '\n');

        }
        return str;
    }
}
