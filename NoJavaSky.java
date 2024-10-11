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
        System.out.print("Selecciona una opción (1 o 2): ");
        String seleccion = input.nextLine();
        while(!seleccion.equals("1") && !seleccion.equals("2")){
            System.out.print("Error de selección, ingresa un input correcto (1 o 2): ");
            seleccion = input.nextLine();
        }
        if(seleccion.equals("2")){
            System.out.println("No Java’s Sky es un juego de supervivencia y de exploración planetaria. Donde puedes visitar diversos planetas, extraer recursos únicos y sobrevivir a las adversidades climáticas, con el objetivo de llegar al centro de la galaxia.");
            System.out.println("Dicen que no hay mejor manera de aprender que poniendo en práctica... ¡Así que, valiente explorador, empecemos una partida!");
        }
        // ----- EMPIEZA EL JUEGO ----- //
        MapaGalactico mapa = new MapaGalactico();
        Jugador jugador = new Jugador();
        Nave nave = new Nave();
        boolean indicadorVisita = false;

        mapa.generadorPrimerosPlanetas();

        while(jugador.get_unidadesEnergiaProteccion() != 0){
            System.out.println();
            System.out.println("---------- PLANETAS EN EL MAPA GALÁCTICO: "+mapa.get_planetas().size()+" ----------");
            System.out.println(mapa.get_planetas());
            System.out.println("---------- LA POSICIÓN ACTUAL EN EL MAPA: "+mapa.get_posicion()+" ----------");

            System.out.println();
            System.out.println("Los radares de la Nave indican que estás cerca de "+mapa.planetaActual()+"...");
            System.out.println("¿Qué te gustaría hacer?");
            System.out.println("1. Visitar "+mapa.planetaActual());
            System.out.println("2. Hacer un salto");
            System.out.print("Selecciona una opción (1 o 2): ");
            seleccion = input.nextLine();
            while(!seleccion.equals("1") && !seleccion.equals("2")){
                //System.out.println("Selección: "+seleccion);
                System.out.print("Error de selección, ingresa un input correcto (1 o 2): ");
                seleccion = input.nextLine();
            }

            System.out.println();
            if(seleccion.equals("1")){
                System.out.println("Has seleccionado: 1. Visitar "+mapa.planetaActual()+".");
                indicadorVisita = mapa.planetaActual().visitar(jugador);
            } else{
                System.out.println("Has seleccionado: 2. Hacer un salto.");
                System.out.println("¿En qué dirección quieres hacer el salto? | Selecciona 1 si el salto será hacia la derecha, o -1 si el salto será hacia la izquierda.");
                System.out.print("Selecciona una opción (1 o -1): ");
                String direccion = input.nextLine();
                int int_direccion = Integer.parseInt(direccion);
                while(!direccion.equals("1") && !direccion.equals("-1")){
                    //System.out.println("Dirección: "+direccion);
                    System.out.print("Error de selección, ingresa un input correcto (1 o -1): ");
                    direccion = input.nextLine();
                    int_direccion = Integer.parseInt(direccion);
                }
                System.out.println("¡Genial! Ahora ingresa el tamaño que tendrá el salto que quieres hacer. ¡Recuerda que no debes exceder los límites del mapa!");
                System.out.print("Ingresa un número: ");
                String jumpSize = input.nextLine();
                int int_jumpSize = Integer.parseInt(jumpSize);
                while((mapa.get_posicion()+(int_direccion*int_jumpSize)) > mapa.get_planetas().size()){
                    System.out.println("Oye... ¡Tranquilo viejo! Te excediste en el tamaño del salto, reinténtalo ingresando un número diferente.");
                    System.out.print("Ingresa un número: ");
                    jumpSize = input.nextLine();
                    int_jumpSize = Integer.parseInt(jumpSize);
                }
                if ((mapa.get_posicion()+(int_direccion*int_jumpSize)) == mapa.get_planetas().size()){
                    mapa.generadorPlaneta();
                    nave.viajarPlaneta(mapa, int_direccion, int_jumpSize);
                    System.out.println("¡Eureka! Has encontrado un nuevo planeta al saltar hacia el límite del Mapa Galáctico conocido.");
                } else{
                    nave.viajarPlaneta(mapa, int_direccion, int_jumpSize);
                    System.out.println("¡Buen viaje, valiente explorador! Hemos llegado a destino.");
                }
                System.out.println("Los sensores de combustible de la nave indican un nivel de "+nave.get_unidadesCombustible()+" unidades restantes.");
            }
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