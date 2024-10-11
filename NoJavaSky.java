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
        boolean indicadorVisita = false;

        mapa.generadorPrimerosPlanetas();

        System.out.println("---------- PLANETAS EN EL MAPA GALÁCTICO ----------");
        System.out.println(mapa.get_planetas());
        System.out.println("---------- TU POSICIÓN EN EL MAPA ES: "+mapa.get_posicion()+" ----------");

        System.out.println();
        System.out.println("Los radares de la Nave indican que estás cerca de "+mapa.planetaActual()+"...");
        System.out.println("¿Qué te gustaría hacer?");
        System.out.println("1. Visitar "+mapa.planetaActual());
        System.out.println("2. Hacer un salto");
        System.out.println("Selecciona una opción (1 o 2):");
        seleccion = input.nextLine();
        while(!seleccion.equals("1") && !seleccion.equals("2")){
            System.out.println("Selección: "+seleccion);
            System.out.println("Error de selección, ingresa un input correcto (1 o 2):");
            seleccion = input.nextLine();
        }
        if(seleccion.equals("1")){
            indicadorVisita = mapa.planetaActual().visitar(jugador);
        } else{
            
        }
        
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
    public int funcionRandom(int min, int max){ // Genera un número random entre min y max
        int numeroGenerado = (int)(min + Math.random() * ((max - min) + 1));
        return numeroGenerado;
    }
    */