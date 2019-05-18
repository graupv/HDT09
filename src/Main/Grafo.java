package Main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
    Boolean visited = false;
    String nombre;

    HashMap<String, Integer> destinos = new HashMap<String, Integer>();

    Grafo(String nom){
        this.nombre = nom;
    }

    public void addPath(String g, int n){
        if (destinos.containsKey(g)){
            destinos.replace(g, n);
        } else {
            destinos.put(g, n);
        }
    }

    public String getNombre(){
        return this.nombre;
    }
    public HashMap<String, Integer> getDestinos(){
        return this.destinos;
    }

    public boolean isConnected(String s){
        return destinos.containsKey(s);

    }

    public int getDistnace(String s){
        return destinos.get(s);
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
        return this.nombre + "\n mis destinos:\n" +
                destinos.toString();

    }

}
