package Main;

import java.util.HashMap;

public class Vertice {
    Boolean visited = false;
    String nombre;
    int num;

    HashMap<String, Integer> edges = new HashMap<String, Integer>();
    //  Ciudad, Distancia


    Vertice(String nom, int n){
        this.nombre = nom;
        this.num = n;
    }

    public void addPath(String g, int n){
        if (edges.containsKey(g)){
            edges.replace(g, n);
        } else {
            edges.put(g, n);
        }
    }

    public int getNum(){
        return this.num;
    }

    public String getNombre(){
        return this.nombre;
    }
    public HashMap<String, Integer> getEdges(){
        return this.edges;
    }

    public boolean isConnected(String s){
        return edges.containsKey(s);

    }

    public int getDistnace(String s){
        return edges.get(s);
    }

    public void replacePath(String s, int d){

    }

    public void visit(){
        this.visited = true;
    }

    public boolean isVisited(){
        return this.visited;
    }

    public String toString(){
        return this.nombre + " #" + this.num + "\n mis edges:\n" +
                edges.toString();

    }

}
