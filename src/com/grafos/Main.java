package com.grafos;

import com.grafos.implementacoes.Buscas;
import com.grafos.implementacoes.Grafo;
import com.grafos.implementacoes.MinPath;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Grafo g = new Grafo(6);
        MinPath mp = new MinPath(g);

        fillGrafoPeso(g);



        mp.teste();
        System.out.println(g.vertices.get(0).depth);
        System.out.println(g.vertices.get(1).depth);
        System.out.println(g.vertices.get(2).depth);


        //Graus.calcularGrausDeSaida(g);
        Buscas buscas = new Buscas();
        //buscas.bfs(g, g.vertices[0]);
        //buscas.dfs(g);


        //mostrarGrausDeSaida(g);

    }

    public static void fillGrafoPeso(Grafo g) {

//        g.addAresta(0, 4, 10);
//        g.addAresta(0, 1, 30);
//        g.addAresta(1, 4, 20);
//        g.addAresta(1, 2, 15);
//        g.addAresta(2, 3, 25);
//        g.addAresta(3, 4, 5);
//        g.addAresta(3, 5, 10);

        g.addAresta(0, 1, 10);
        g.addAresta(0, 2, 5);
        g.addAresta(1, 2, 3);
        g.vertices.get(1).depth = 10;
        g.vertices.get(2).depth = 5;

    }

    public static void inserirGrafo(Grafo g) {
        int vert, arestas;
        int varesta1, varesta2;

        Scanner leitura = new Scanner(System.in); //novo
        System.out.println("Digite a quantidade de vertices: ");
        vert = leitura.nextInt();

        System.out.println("Digite a quantidade de arestas: ");
        arestas = leitura.nextInt();


        for (int i = 1; i <= arestas; i++) {
            System.out.println("Digite o vértice 1 da aresta " + i + ": ");
            varesta1 = leitura.nextInt();
            System.out.println("Digite o vértice 2 da aresta " + i + ": ");
            varesta2 = leitura.nextInt();

            g.addAresta(varesta1, varesta2);

        }


    }

}
