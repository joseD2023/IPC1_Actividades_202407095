
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Pais {
    private String id;
    private String nombre;


    public Pais(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

public class Juegoipc1 {
    private static ArrayList<Pais> paises = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();





    public static void main(String[] args) {
        //Implementamos carga del archivo csv 


        cargarPaises(); //lamamos a la funcion para que nos cargue el archivo y lo coloque directo en el arrayList


        String respuesta;

        do {
            jugarRonda();
            System.out.println("\n¿Quieres seguir jugando? (Escribe 'salir' para terminar)");
            respuesta = scanner.nextLine();

        } while (!respuesta.equalsIgnoreCase("salir"));




        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }







    private static void cargarPaises() {

        // Lectura mínima robusta: UTF-8, skip posible encabezado y validación simple
        String path = "data.csv";
        int lineNum = 0;

        try (BufferedReader leer = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {

            String linea;
            while ((linea = leer.readLine()) != null) {
                lineNum++;
                linea = linea.trim();


                if (linea.isEmpty()) {
                    continue; // saltar líneas vacías
                }

                // detectar y saltar encabezado simple
                if (lineNum == 1) {
                    String low = linea.toLowerCase();
                    if (low.contains("nombre") || low.contains("id") || low.contains("pais")) {
                        continue;
                    }
                }



                String[] datos = linea.split(",");
                if (datos.length < 2) {
                    System.out.println("Línea " + lineNum + " ignorada (formato incorrecto): " + linea);
                    continue;
                }


                String id = datos[1].trim();
                String nombre = datos[0].trim(); 


                if (id.isEmpty() || nombre.isEmpty()) {
                    System.out.println("Línea " + lineNum + " con campos vacíos, ignorada.");
                    continue;
                }

                paises.add(new Pais(id, nombre));
            }

            System.out.println("Países cargados: " + paises.size());

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + path + ". Coloca 'data.csv' en la carpeta del proyecto o modifica la ruta.");
        } catch (IOException e) {
            System.out.println("Error leyendo archivo CSV: " + e.getMessage());
        }



    }

    private static void jugarRonda() {
        boolean acierto = false; 
        int cantidad_intentos =0; 

        if (paises.isEmpty()) { //si esta vacio el arraylist mostramos no hay paises cargados
            System.out.println("No hay países cargados en el juego.");
            return;
        }

        //implementamos la logica del jeugo 
        Pais paisElegido = paises.get(random.nextInt(paises.size()));
        System.out.println("El país que elegí tiene este código: " + paisElegido.getId());



        //ahora vmaos a implementar la logica del juego 

        while(true){
         System.out.println("¿Cual crees que el pais? (Si no lo sabe escriba pasar/salir)");
         
         String intento = scanner.nextLine();

         //consejo hecho por la IA

         if (intento.isEmpty()) {
             System.out.println("Entrada invalida, Dejo espacio en Blanco");
             continue;
         }

         if (intento.equalsIgnoreCase("Salir")) {
          System.out.println("Has decidido salir del juego !!");
          break;
             
         }

         intento = intento.trim();

         if (paisElegido.getNombre().equalsIgnoreCase(intento)) {
          System.out.println("Corecto ¡Has adivinado el pais!" + ":"+paisElegido.getNombre() + " "+ "Lo lograste en el intento Numero" + " " + cantidad_intentos);
          acierto = true; 
          break;
             
         }else if (intento.equalsIgnoreCase("Pasar")) {
          System.out.println("Has decidido pasar. El pais era:" + paisElegido.getNombre());
          break;

             
         }else{
          System.out.println("Incorrecto, intenta de neuvo.");
          cantidad_intentos++; 
         }
            
        } 

        




        

    }
}
