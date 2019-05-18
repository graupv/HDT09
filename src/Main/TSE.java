/*

HDT09   -   Grafos & DFS

Gerardo Pineda
18848

*/

package Main;

import java.io.*;
import java.util.*;

public class TSE {

    final static String DELIMITADOR = " \t\n\r";
    final static String file_path = "guategrafo.txt";

    public static void main(String[] args) throws IOException {
        HashMap<String, Grafo> mis_grafos = new HashMap<String, Grafo>();

        StringTokenizer token = new StringTokenizer(getDataFile(), DELIMITADOR);
        Stack<String> visits;
        ArrayList<String> order = new ArrayList<String>();
        String ciudadA;
        String ciudadB;
//        Grafo placeholder;
        Integer distancia = 0;

//        System.out.println(System.getProperty("user.dir"));
//        getcwd()
        while(token.hasMoreTokens()){
            ciudadA = token.nextToken();

            ciudadB = token.nextToken();

            distancia = Integer.valueOf(token.nextToken());

            if (!mis_grafos.containsKey(ciudadA)){
                System.out.println("got city: " + ciudadA);
                System.out.println("got city: " + ciudadB);
                System.out.println("got distance: " + distancia);
                System.out.println(ciudadA + " no existe.");
                Grafo placeholder = new Grafo(ciudadA);
                placeholder.addPath(ciudadB, distancia);
                mis_grafos.put(ciudadA, placeholder);
            } else {
                System.out.println(ciudadA + " si existe.");
                Grafo placeholder = mis_grafos.remove(ciudadA);
                placeholder.addPath(ciudadB, distancia);
                mis_grafos.put(placeholder.getNombre(), placeholder);
            }

        }

        System.out.println("grafos procesados, calculando matriz");
        int [][] matrix = createMatrix(mis_grafos);
        //  matriz vacia con 0's en diagonal

        Set s = mis_grafos.keySet();
        Object[] s2 = s.toArray();
        ArrayList<String> notVisited = new ArrayList<String>();
        for (int i = 0; i <s2.length; i++) {
            notVisited.add((String)s2[i]);

        }
        //  Lista de ciudades sin visitar

        ArrayList<String> visited = new ArrayList<String>();
        //  Lista de ciudades ya visitadas
        Grafo G = mis_grafos.get(notVisited.get(0));
        //   tomar un grafo incial

        depthFirst(G, visited, matrix, notVisited, mis_grafos);



//        System.out.println(s[3]);

//        for (Object nombre: s) {
//            System.out.println(mis_grafos.get(nombre));
//        }
    }

    private static void depthFirst(Grafo G, ArrayList<String> visits, int[][] matrix, ArrayList<String> notVisited, HashMap<String, Grafo> mis_grafos){
        while (notVisited.size() > 0){
            /*
            DFS(Grafo G):
                G <- Grafo

            If Grafo not in visited:
                add_to_visited
                add_destinations_to_ToVisit
                DFS (Next in ToVisit Queue)
            Else
                Visit Next in ToVisit Queue
                HashMap<String, Integer> destinos = G.getDestinos();
            * */
            depthFirst(G, visits, matrix, notVisited, mis_grafos);

        }
        return;

    }

    private static int[][] createMatrix(HashMap<String, Grafo> H){
        // post generacion de grafos
        int n = H.size();
        Set s = H.keySet();
        int pos = 0;
        ArrayList<String> visits = new ArrayList<String>(n);
        Object[] s2 = s.toArray();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
            //  diagonal de matriz == 0's
        }

//        for (Object nombre: s) {
//            Grafo G = H.get(nombre);
//            depthFirst(G, visits, matrix, s2);
//            if (!visits.contains(nombre)){
//                for (int i = 0; i <n ; i++) {
//                    if (s2[i].equals(nombre)){
//                        pos = i;
//                        break;
//                    }
//                }
//
//            }
//
//        }
        return matrix;
    }

    private static String getDataFile() throws IOException, FileNotFoundException {

        BufferedReader reader;
        File file;
        String linea,datos = "";
        try{
            if((new File(file_path)).exists()){


                reader = new BufferedReader(new FileReader(file_path));

                while((linea = reader.readLine()) != null){

                    datos += linea.toLowerCase() + "\t";
                }

                reader.close();
            }
            else{
                System.out.println("El archivo ingresado no fue encontrado.");
            }

        }

        catch(Exception e){
            e.printStackTrace();
        }

        return datos;
    }
}
