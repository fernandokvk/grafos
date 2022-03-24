package com.grafos.implementacoes;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {
    public ArrayList<Vertice> vertices = new ArrayList<>();

    public enum Cor {
        BRANCO,
        CINZA,
        PRETO
    }

    public static class Vertice {
        public int num, depth, fim, grauSaida, grauEntrada;
        HashMap<Vertice, Integer> listaAdj = new HashMap<>();
        ;
        Vertice pai;
        Cor cor;

        public String toString() {
            return "Vertice(" + num + ")";
        }
    }

    public Grafo(int tamanho) {

        for (int i = 0; i < tamanho - 1; i++) {
            vertices.add(i, new Vertice());
        }

    }

    public void addAresta(int u, int v, int peso) {
        vertices.get(u).listaAdj
                .put(vertices.get(v), peso);
    }

    public void addAresta(int u, int v) {
        vertices.get(u).listaAdj
                .put(vertices.get(v), null);
    }


}
