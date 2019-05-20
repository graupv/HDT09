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
        HashMap<String, Vertice> mis_vertices = new HashMap<String, Vertice>();


        StringTokenizer token = new StringTokenizer(getDataFile(), DELIMITADOR);
        Stack<String> visits = new Stack<>();
        ArrayList<String> order = new ArrayList<String>();
        String ciudadA;
        String ciudadB;

        Grafo graph = new Grafo();
//        graph.addVert();
//        Vertice placeholder;
        Integer distancia = 0;
        int nums = 1;

//        System.out.println(System.getProperty("user.dir"));
//        getcwd()
        while(token.hasMoreTokens()){
            ciudadA = token.nextToken();

            ciudadB = token.nextToken();

            distancia = Integer.valueOf(token.nextToken());

            if (!mis_vertices.containsKey(ciudadA)){
//                System.out.println("got city: " + ciudadA);
//                System.out.println("got city: " + ciudadB);
//                System.out.println("got distance: " + distancia);
//                System.out.println(ciudadA + " no existe.");
                Vertice placeholder = new Vertice(ciudadA, nums);
                nums++;
                placeholder.addPath(ciudadB, distancia);
                mis_vertices.put(ciudadA, placeholder);
            } else {
//                System.out.println(ciudadA + " si existe.");
                Vertice placeholder = mis_vertices.get(ciudadA);
                placeholder.addPath(ciudadB, distancia);
                mis_vertices.put(placeholder.getNombre(), placeholder);
            }

        }

        System.out.println("grafos procesados, calculando matriz");
        int [][] matrix = createMatrix(mis_vertices);
        //  matriz vacia con 0's en diagonal

        Set s = mis_vertices.keySet();
        Object[] s2 = s.toArray();  // lista de todos los nombres de vertices
        Object[] s3;
        ArrayList<String> notVisited = new ArrayList<String>();


        //  Lista de ciudades sin visitar

//        ArrayList<String> visited = new ArrayList<String>();
        //  Lista de ciudades ya visitadas
//        Vertice G = mis_grafos.get(notVisited.get(0));
        //   tomar un grafo incial

//        depthFirst(G, visited, matrix, notVisited, mis_grafos);



//        System.out.println(s[3]);

        for (Object nombre: s) {
            System.out.println(mis_vertices.get(nombre));
        }

        System.out.println("prints done\n");
        for (int i = 0; i < s2.length - 1; i++) {
            notVisited.add((String)s2[i]);
            System.out.println("unvis");
            //  popular no visitados

            Vertice placeholder = mis_vertices.get((String)s2[i]);
            HashMap<String, Integer> eds = placeholder.getEdges();
            Set ed = eds.keySet();
            s3 = ed.toArray();
            String nom;
            int x = placeholder.getNum();
            int y;
            for (int j = 0; j < s3.length - 1 ; j++) {
                nom = (String)s3[j];
                y = mis_vertices.get(nom).getNum();
                System.out.println("edge: " + eds.get(nom));
                matrix[x][y] = eds.get(nom);
            }


        }
        System.out.println("not visited: " + notVisited.size());

        for (int i = 0; i < matrix.length - 1; i++) {

            for (int j = 0; j < matrix.length - 1; j++) {
                System.out.print(matrix[i][j] + "\t\t");

            }
            System.out.print("\n");

        }

    }

    private static void depthFirst(Vertice G, ArrayList<String> visits, int[][] matrix, ArrayList<String> notVisited, HashMap<String, Vertice> mis_grafos){
        while (notVisited.size() > 0){
            /*
            DFS(Vertice G):
                G <- Vertice

            If Vertice not in visited:
                add_to_visited
                add_destinations_to_ToVisit
                DFS (Next in ToVisit Queue)
            Else
                Visit Next in ToVisit Queue
                HashMap<String, Integer> edges = G.getEdges();
            * */
            depthFirst(G, visits, matrix, notVisited, mis_grafos);

        }
        return;

    }

    private static int[][] createMatrix(HashMap<String, Vertice> H){
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
//            Vertice G = H.get(nombre);
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
