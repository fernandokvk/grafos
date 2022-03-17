package com.company;

public class MinPath {
    private Grafo g;

    public MinPath(Grafo g) {
        this.g = g;
    }

    private void initializeSingleSoiurce(Grafo g, Vertice s){
        for (Vertice v: g.vertices) {
            v.depth = -1;
        }
        s.depth = 0;
    }

    private void relax(Vertice u, Vertice v){
        if (v.depth > u.depth + v.listaAdj.get(u)){
            v.depth = u.depth + v.listaAdj.get(u);
            v.pai = u;

        }
    }
    
    public void teste(){
        initializeSingleSoiurce(g, g.vertices[0]);

        for (Vertice v: g.vertices)
              {
                relax(v, (Vertice) v.listaAdj.keySet().toArray()[0]);


        }
        
    }


    //3 algos
}
