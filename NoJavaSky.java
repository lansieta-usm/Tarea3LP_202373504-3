import java.util.Scanner;

public class NoJavaSky {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------");
        System.out.println("Te damos la bienvenida a NoJavaSky v1.0");
        System.out.println("---------------------------------------");
        System.out.println("¿Qué te gustaría hacer?");
        System.out.println("1. Nueva Partida");
        System.out.println("2. Breve introducción a NoJavaSky");
        System.out.println("Selecciona una opción (1 o 2):");
        String seleccion = input.nextLine();
        while(!seleccion.equals("1") && !seleccion.equals("2")){
            System.out.println("Selección: "+seleccion);
            System.out.println("Error de selección, ingresa un input correcto (1 o 2):");
            seleccion = input.nextLine();
        }
        if(seleccion.equals("2")){
            System.out.println("No Java’s Sky es un juego de supervivencia y de exploración planetaria. Donde puedes visitar diversos planetas, extraer recursos únicos y sobrevivir a las adversidades climáticas, con el objetivo de llegar al centro de la galaxia.");
            System.out.println("Dicen que no hay mejor manera de aprender que poniendo en práctica... ¡Así que, valiente explorador, empecemos una partida!");
        }
        // ----- EMPIEZA EL JUEGO ----- //
        System.out.println();
        MapaGalactico mapa = new MapaGalactico();
        Jugador jugador = new Jugador();
        Nave nave = new Nave();
        /*
        mapa.generadorPrimerosPlanetas();
        System.out.println(mapa.get_planetas());
        System.out.println();
        System.out.println("Posición: "+mapa.get_posicion());
        System.out.println("Combustible: "+nave.get_unidadesCombustible());
        System.out.println(mapa.planetaActual());
        System.out.println();
        nave.viajarPlaneta(mapa, 1, 5);
        System.out.println("Posición: "+mapa.get_posicion());
        System.out.println("Combustible: "+nave.get_unidadesCombustible());
        System.out.println(mapa.planetaActual());
        System.out.println();
        nave.viajarPlaneta(mapa, -1, 3);
        System.out.println("Posición: "+mapa.get_posicion());
        System.out.println("Combustible: "+nave.get_unidadesCombustible());
        System.out.println(mapa.planetaActual());
        */

        input.close();
    }
}

    /*
    public static int funcionRandom(int min, int max){ // Genera un número random entre min y max
        int numeroGenerado = (int)(min + Math.random() * ((max - min) + 1));
        return numeroGenerado;
    }
    */