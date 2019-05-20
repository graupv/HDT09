package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Grafo<V, E> {
    PriorityQueue<Vertice> search_queue = new PriorityQueue<Vertice>();
    ArrayList<Vertice> vertices = new ArrayList<Vertice>();
//    HashMap<String, Integer> arcos = new HashMap<String, Integer>();
    //

    public void addVert(Vertice v){
        vertices.add(v);
    }

}
