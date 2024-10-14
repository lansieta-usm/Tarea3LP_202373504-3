import java.util.Scanner;

public class NoJavaSky {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------");
        System.out.println("¡SIIII PAPUS :v! Esto es NoJavaSky v1.0");
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
            System.out.println("Dicen que no hay mejor manera de aprender que en la práctica... ¡Así que, valiente explorador(a), empecemos una partida!");
        }
        // ----- EMPIEZA EL JUEGO ----- //
        MapaGalactico mapa = new MapaGalactico();
        Jugador jugador = new Jugador();
        Nave nave = new Nave();

        mapa.generadorPrimerosPlanetas();

        while(true){
            System.out.println();
            System.out.println("---------- PLANETAS EN EL MAPA GALÁCTICO: "+mapa.get_planetas().size()+" ----------");
            System.out.println(mapa.get_planetas());
            System.out.println("---------- LA POSICIÓN ACTUAL EN EL MAPA: "+mapa.get_posicion()+" ----------");

            System.out.println();
            System.out.println("Los radares de la Nave indican que estás cerca la órbita de "+mapa.planetaActual()+"...");
            System.out.println("¿Qué te gustaría hacer?");
            System.out.println("1. Visitar "+mapa.planetaActual());
            System.out.println("2. Hacer un salto");
            System.out.println("3. Otras opciones");
            System.out.print("Selecciona una opción (1, 2 o 3): ");
            seleccion = input.nextLine();
            while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3")){
                System.out.print("Error de selección, ingresa un input correcto (1, 2 o 3): ");
                seleccion = input.nextLine();
            }
            // ----- VISITANDO UN PLANETA ----- //
            System.out.println();
            if(seleccion.equals("1")){
                mapa.planetaActual().visitar(jugador);
                System.out.println("Has seleccionado: 1. Visitar "+mapa.planetaActual());
                if(mapa.planetaActual().get_identificador().equals("Centro Galactico")){
                    if (nave.get_eficienciaPropulsor() > 0.5){
                        break;
                    } else{
                        System.out.println("Solo las mejores naves pueden llegar hasta aquí... ¿Estás seguro(a) de que la tuya tiene lo necesario?");
                        System.out.println("HINT: Sigue mejorando la eficiencia");
                    }
                } else{
                    System.out.println("Tras llegar a "+mapa.planetaActual()+", la energía protectora disponible en el exotraje es "+jugador.get_unidadesEnergiaProteccion());
                    System.out.println();
                    System.out.println("¡Te damos la bienvenida a "+mapa.planetaActual()+"!");
                    while(jugador.get_unidadesEnergiaProteccion() > 0){
                        if((mapa.planetaActual().get_identificador().equals("Helado")) || (mapa.planetaActual().get_identificador().equals("Oceanico"))){
                            System.out.println("¿Qué te gustaría hacer?");
                            System.out.println("1. Extraer recursos");
                            System.out.println("2. Intercambiar recursos");
                            System.out.println("3. Salir de "+mapa.planetaActual()+" y volver a la Nave");
                            System.out.print("Selecciona una opción (1, 2 o 3): ");
                            seleccion = input.nextLine();
                            while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3")){
                                System.out.print("Error de selección, ingresa un input correcto (1, 2 o 3): ");
                                seleccion = input.nextLine();
                            }
                            if(seleccion.equals("1")){

                            } else if(seleccion.equals("2")){

                            } else{
                                mapa.planetaActual().salir();
                                break;
                            }
                        } else{
                            System.out.println("¿Qué te gustaría hacer?");
                            System.out.println("1. Extraer recursos");
                            System.out.println("2. Salir de "+mapa.planetaActual()+" y volver a la Nave");
                            System.out.print("Selecciona una opción (1 o 2): ");
                            seleccion = input.nextLine();
                            while(!seleccion.equals("1") && !seleccion.equals("2")){
                                System.out.print("Error de selección, ingresa un input correcto (1 o 2): ");
                                seleccion = input.nextLine();
                            }
                            if(seleccion.equals("1")){

                            } else{
                                mapa.planetaActual().salir();
                                break;
                            }
                        }
                    }
                }
            } else if (seleccion.equals("2")){
                System.out.println("Has seleccionado: 2. Hacer un salto");
                System.out.println();
                System.out.println("¿En qué dirección quieres hacer el salto? | Selecciona 1 si el salto será hacia la derecha, o -1 si el salto será hacia la izquierda.");
                System.out.print("Selecciona una opción (1 o -1): ");
                String direccion = input.nextLine();
                int int_direccion = Integer.parseInt(direccion);
                while(!direccion.equals("1") && !direccion.equals("-1")){
                    System.out.print("Error de selección en la dirección, ingresa un input correcto (1 o -1): ");
                    direccion = input.nextLine();
                    int_direccion = Integer.parseInt(direccion);
                }
                System.out.println("¡Genial! Ahora ingresa el tamaño que tendrá el salto que quieres hacer. ¡Recuerda que no debes exceder los límites del mapa!");
                System.out.print("Ingresa un número: ");
                String jumpSize = input.nextLine();
                int int_jumpSize = Integer.parseInt(jumpSize);
                while((mapa.get_posicion()+(int_direccion*int_jumpSize)) > mapa.get_planetas().size()){
                    System.out.println("Oye... ¡Tranquilo viejo! Te excediste en el tamaño del salto, reinténtalo ingresando un número diferente");
                    System.out.print("Ingresa un número: ");
                    jumpSize = input.nextLine();
                    int_jumpSize = Integer.parseInt(jumpSize);
                }
                System.out.println();
                if ((mapa.get_posicion()+(int_direccion*int_jumpSize)) == mapa.get_planetas().size()){
                    mapa.generadorPlaneta();
                    nave.viajarPlaneta(mapa, int_direccion, int_jumpSize);
                    System.out.println("¡Eureka! Has encontrado un nuevo planeta al saltar hacia el límite del Mapa Galáctico conocido");
                } else{
                    nave.viajarPlaneta(mapa, int_direccion, int_jumpSize);
                    System.out.println("¡Buen viaje, valiente explorador! Hemos llegado a destino");
                }
                System.out.println("Los sensores de combustible de la nave indican un nivel de "+nave.get_unidadesCombustible()+" unidades restantes");
            } else{
                System.out.println("Has seleccionado: 3. Otras opciones");
                System.out.println();
                System.out.println("1. Ver tu inventario y volver atrás");
                System.out.println("2. Recargar energía protectora del exotraje");
                System.out.println("3. Recargar propulsores de la Nave");
                System.out.print("Selecciona una opción (1, 2 o 3): ");
                seleccion = input.nextLine();
                while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3")){
                    System.out.print("Error de selección, ingresa un input correcto (1, 2 o 3): ");
                    seleccion = input.nextLine();
                }

            }
        }

        System.out.println();
        System.out.println("¡Felcidades, valiente explorador(a)... Has llegado al Centro Galáctico! :DDD");
        System.out.println();
        System.out.println("--------------- STATS Y CRÉDITOS ---------------");
        System.out.println("Energía protectora restante del exotraje: "+jugador.get_unidadesEnergiaProteccion());
        System.out.println("Eficiencia de la energía protectora del exotraje: "+jugador.get_eficienciaEnergiaProteccion());
        System.out.println("Cristales de Hidrógeno en el inventario: "+jugador.get_inv_cristalesHidrogeno());
        System.out.println("Flores de Sodio en el inventario: "+jugador.get_inv_floresSodio());
        System.out.println("Uranio en el inventario: "+jugador.get_inv_uranio());
        System.out.println("Platino en el inventario: "+jugador.get_inv_platino());
        System.out.println("Combustible restante en la Nave: "+nave.get_unidadesCombustible());
        System.out.println("Eficiencia del propulsor de la Nave: "+nave.get_eficienciaPropulsor());
        System.out.println();
        System.out.println("Idea original: Departamento de Informática | Universidad Técnica Federico Santa María");
        System.out.println("Tarea creada por: Lucas Ansieta M.");
        System.out.println("Idea de implementación: Lucas Ansieta M.");
        System.out.println("Frontend (no hay frontend): Lucas Ansieta M.");
        System.out.println("Backend: Lucas Ansieta M.");
        System.out.println("Créditos: Lucas Ansieta M.");
        System.out.println("INF253 - Lenguajes de programación | © Todos los derechos reservados");
        System.out.println("------------------------------------------------");


        input.close();
    }
}

        /*
        // ----- TEST PARA ENTREGA MINIMA ----- //
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

    /*
    public int funcionRandom(int min, int max){ // Genera un número random entre min y max
        int numeroGenerado = (int)(min + Math.random() * ((max - min) + 1));
        return numeroGenerado;
    }
    */