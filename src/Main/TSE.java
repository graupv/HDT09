package Main;/**/

import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class TSE {

    final static String DELIMITADOR = " \t\n\r";
    final static String file_path = "guategrafo.txt";

    public static void main(String[] args) throws IOException {
        HashMap<String, Grafo> mis_grafos = new HashMap<String, Grafo>();
        StringTokenizer token = new StringTokenizer(getDataFile(), DELIMITADOR);
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
                placeholder.replacePath(ciudadB, distancia);
                mis_grafos.put(placeholder.getNombre(), placeholder);
            }


        }
        System.out.println(mis_grafos.size());
        Set s = mis_grafos.keySet();
        for (Object nombre: s) {
            System.out.println(mis_grafos.get(nombre));
        }
    }

    private static String getDataFile() throws IOException, FileNotFoundException {

        BufferedReader reader;
        File file;
        String linea,datos = "";
        try{
            if((new File(file_path)).exists()){


                reader = new BufferedReader(new FileReader(file_path));

                while((linea = reader.readLine()) != null){

                    datos += linea + "\t";
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
