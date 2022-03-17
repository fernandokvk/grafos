package com.company;

public class Graus {
    public static void calcularGrausDeSaida(Grafo g) {
        for (Vertice v : g.vertices) {
            v.grauSaida = 0;
        }

        for (Vertice v : g.vertices) {
            for (Vertice u : v.adj) {
                v.grauSaida += 1;
            }
        }
    }

    public static void mostrarGrausDeSaida(Grafo g) {
        for (Vertice v : g.vertices) {
            System.out.printf("%s.grauSaida = %d\n", v, v.grauSaida);
        }
    }

    public static void calcularGrauDeEntrada(Grafo g){
        for (Vertice v : g.vertices) {
            v.grauEntrada = 0;
        }

        for (Vertice v : g.vertices) {

        }
    }
}
