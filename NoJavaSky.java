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
                    if(jugador.get_unidadesEnergiaProteccion() <= 0){ // Si el jugador sucumbe
                        System.out.println();
                        System.out.println("--------------------------------------------");
                        System.out.println("¡ALERTA! ¡ALERTA! ¡ALERTA! ¡ALERTA! ¡ALERTA!");
                        System.out.println("--------------------------------------------");
                        System.out.println("Tu exotraje se ha quedado sin energía protectora... Has sucumbido ante las adverisidades de "+mapa.planetaActual());
                        System.out.println("¡PERO EY! Las risas no faltaron... ¡Nah, tranquilo(a), valiente explorador(a)! La Nave activó su sistema de emergencia y te salvó la vida... La energía protectora del exotraje y el combustible se han recargado, pero has perdido todo tu inventario, se han restablecido las eficiencias del exotraje y de la Nave a 0 y has vuelto a estar en la misma órbita dónde empezó tu aventura");
                        System.out.println("¡Ánimo, no te rindas... Estás cada vez mas cerca de concluir tu aventura!");
                        mapa.set_posicion(0);
                        nave.set_inv_cristalesHidrogeno(0);
                        jugador.set_inv_floresSodio(0);
                        jugador.set_inv_uranio(0);
                        jugador.set_inv_platino(0);
                        nave.set_unidadesCombustible(100);
                        nave.set_eficienciaPropulsor(0);
                        jugador.set_unidadesEnergiaProteccion(100);
                        jugador.set_eficienciaEnergiaProteccion(0);
                    } else{
                        System.out.println("Tras llegar a "+mapa.planetaActual()+", la energía protectora disponible en el exotraje es "+jugador.get_unidadesEnergiaProteccion());
                        System.out.println();
                        System.out.println("¡Te damos la bienvenida a "+mapa.planetaActual()+"!");
                        while(true){
                            if(jugador.get_unidadesEnergiaProteccion() <= 0){ // Si el jugador sucumbe
                                System.out.println();
                                System.out.println("--------------------------------------------");
                                System.out.println("¡ALERTA! ¡ALERTA! ¡ALERTA! ¡ALERTA! ¡ALERTA!");
                                System.out.println("--------------------------------------------");
                                System.out.println("Tu exotraje se ha quedado sin energía protectora... Has sucumbido ante las adverisidades de "+mapa.planetaActual());
                                System.out.println("¡PERO EY! Las risas no faltaron... ¡Nah, tranquilo(a), valiente explorador(a)! La Nave activó su sistema de emergencia y te salvó la vida... La energía protectora del exotraje y el combustible se han recargado, pero has perdido todo tu inventario, se han restablecido las eficiencias del exotraje y de la Nave a 0 y has vuelto a estar en la misma órbita dónde empezó tu aventura");
                                System.out.println("¡Ánimo, no te rindas... Estás cada vez mas cerca de concluir tu aventura!");
                                mapa.set_posicion(0);
                                nave.set_inv_cristalesHidrogeno(0);
                                jugador.set_inv_floresSodio(0);
                                jugador.set_inv_uranio(0);
                                jugador.set_inv_platino(0);
                                nave.set_unidadesCombustible(100);
                                nave.set_eficienciaPropulsor(0);
                                jugador.set_unidadesEnergiaProteccion(100);
                                jugador.set_eficienciaEnergiaProteccion(0);
                                break;
                            } else{
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
                                        System.out.println();
                                        System.out.println("Has seleccionado: 1. Extraer recursos");
                                        System.out.println();
                                        System.out.println("¿Qué recursos te gustaría extraer?");
                                        System.out.println("1. Cristales de Hidrógeno");
                                        System.out.println("2. Flores de Sodio");
                                        System.out.print("Selecciona una opción (1 o 2): ");
                                        seleccion = input.nextLine();
                                        while(!seleccion.equals("1") && !seleccion.equals("2")){
                                            System.out.print("Error de selección, ingresa un input correcto (1 o 2): ");
                                            seleccion = input.nextLine();
                                        }
                                        if(seleccion.equals("1")){
                                            mapa.planetaActual().extraerRecursos(1);
                                            System.out.println("¿Cuántos Cristales de Hidrógeno quieres extraer?");
                                            System.out.print("Ingresa un número: ");
                                            String extraccion = input.nextLine();
                                            int int_extraccion = Integer.parseInt(extraccion);

                                            mapa.planetaActual().set_cristalesHidrogeno(mapa.planetaActual().get_cristalesHidrogeno()-int_extraccion); // Re-cálculo de los recursos disponibles
                                            float gastoEnergia = (float)(0.5 * int_extraccion * (mapa.planetaActual().get_consumoEnergia() * 0.01) * (1-jugador.get_eficienciaEnergiaProteccion())); // Cálculo del gasto energético
                                            nave.set_inv_cristalesHidrogeno(nave.get_inv_cristalesHidrogeno()+int_extraccion); // Añade al inventario la extracción
                                            jugador.set_unidadesEnergiaProteccion(jugador.get_unidadesEnergiaProteccion()-gastoEnergia); // Disminuye la energía tras la extracción
                                            System.out.println();
                                            System.out.println("Has hecho una extracción de "+int_extraccion+" Cristales de Hidrógeno");
                                            System.out.println("Tras la extracción, la energía protectora disponible en el exotraje es "+jugador.get_unidadesEnergiaProteccion());
                                            System.out.println();
                                        } else{
                                            mapa.planetaActual().extraerRecursos(2);
                                            System.out.println("¿Cuántas Flores de Sodio quieres extraer?");
                                            System.out.print("Ingresa un número: ");
                                            String extraccion = input.nextLine();
                                            int int_extraccion = Integer.parseInt(extraccion);

                                            mapa.planetaActual().set_floresSodio(mapa.planetaActual().get_floresSodio()-int_extraccion); // Re-cálculo de los recursos disponibles
                                            float gastoEnergia = (float)(0.5 * int_extraccion * (mapa.planetaActual().get_consumoEnergia() * 0.01) * (1-jugador.get_eficienciaEnergiaProteccion())); // Cálculo del gasto energético
                                            jugador.set_inv_floresSodio(jugador.get_inv_floresSodio()+int_extraccion); // Añade al inventario la extracción
                                            jugador.set_unidadesEnergiaProteccion(jugador.get_unidadesEnergiaProteccion()-gastoEnergia); // Disminuye la energía tras la extracción
                                            System.out.println();
                                            System.out.println("Has hecho una extracción de "+int_extraccion+" Flores de Sodio");
                                            System.out.println("Tras la extracción, la energía protectora disponible en el exotraje es "+jugador.get_unidadesEnergiaProteccion());
                                            System.out.println();
                                        }
                                    } else if(seleccion.equals("2")){
                                        //tieneAsentamientos(jugador);
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
                                        System.out.println();
                                        System.out.println("Has seleccionado: 1. Extraer recursos");
                                        System.out.println();
                                        System.out.println("¿Qué recursos te gustaría extraer?");
                                        System.out.println("1. Cristales de Hidrógeno");
                                        System.out.println("2. Flores de Sodio");
                                        System.out.println("3. Uranio");
                                        System.out.println("4. Platino");
                                        System.out.print("Selecciona una opción (1, 2, 3 o 4): ");
                                        seleccion = input.nextLine();
                                        while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3") && !seleccion.equals("4")){
                                            System.out.print("Error de selección, ingresa un input correcto (1, 2, 3 o 4): ");
                                            seleccion = input.nextLine();
                                        }
                                        if(seleccion.equals("1")){
                                            mapa.planetaActual().extraerRecursos(1);
                                            System.out.println("¿Cuántos Cristales de Hidrógeno quieres extraer?");
                                            System.out.print("Ingresa un número: ");
                                            String extraccion = input.nextLine();
                                            int int_extraccion = Integer.parseInt(extraccion);

                                            mapa.planetaActual().set_cristalesHidrogeno(mapa.planetaActual().get_cristalesHidrogeno()-int_extraccion); // Re-cálculo de los recursos disponibles
                                            float gastoEnergia = (float)(0.5 * int_extraccion * (mapa.planetaActual().get_consumoEnergia() * 0.01) * (1-jugador.get_eficienciaEnergiaProteccion())); // Cálculo del gasto energético
                                            nave.set_inv_cristalesHidrogeno(nave.get_inv_cristalesHidrogeno()+int_extraccion); // Añade al inventario la extracción
                                            jugador.set_unidadesEnergiaProteccion(jugador.get_unidadesEnergiaProteccion()-gastoEnergia); // Disminuye la energía tras la extracción
                                            System.out.println();
                                            System.out.println("Has hecho una extracción de "+int_extraccion+" Cristales de Hidrógeno");
                                            System.out.println("Tras la extracción, la energía protectora disponible en el exotraje es "+jugador.get_unidadesEnergiaProteccion());
                                            System.out.println();
                                        } else if(seleccion.equals("2")){
                                            mapa.planetaActual().extraerRecursos(2);
                                            if(mapa.planetaActual().get_identificador().equals("Volcanico")){
                                                System.out.println("¡Advertencia! Nuestros estudios de Planetas Volcánicos han confirmado que su suelo poco fértil no permite que crezcan Flores de Sodio en él");
                                                System.out.println();
                                            } else{
                                                System.out.println("¿Cuántas Flores de Sodio quieres extraer?");
                                                System.out.print("Ingresa un número: ");
                                                String extraccion = input.nextLine();
                                                int int_extraccion = Integer.parseInt(extraccion);

                                                mapa.planetaActual().set_floresSodio(mapa.planetaActual().get_floresSodio()-int_extraccion); // Re-cálculo de los recursos disponibles
                                                float gastoEnergia = (float)(0.5 * int_extraccion * (mapa.planetaActual().get_consumoEnergia() * 0.01) * (1-jugador.get_eficienciaEnergiaProteccion())); // Cálculo del gasto energético
                                                jugador.set_inv_floresSodio(jugador.get_inv_floresSodio()+int_extraccion); // Añade al inventario la extracción
                                                jugador.set_unidadesEnergiaProteccion(jugador.get_unidadesEnergiaProteccion()-gastoEnergia); // Disminuye la energía tras la extracción
                                                System.out.println();
                                                System.out.println("Has hecho una extracción de "+int_extraccion+" Flores de Sodio");
                                                System.out.println("Tras la extracción, la energía protectora disponible en el exotraje es "+jugador.get_unidadesEnergiaProteccion());
                                                System.out.println();
                                            }
                                        } else if(seleccion.equals("3")){
                                            mapa.planetaActual().extraerRecursos(3);
                                            if(!mapa.planetaActual().get_identificador().equals("Radiactivo")){
                                                System.out.println("¡Advertencia! Nuestros estudios galácticos han confirmado que el Uranio es un recurso exclusivo de los planetas Radiactivos");
                                                System.out.println();
                                            } else{
                                                System.out.println("¿Cuántas unidades de Uranio quieres extraer?");
                                                System.out.print("Ingresa un número: ");
                                                String extraccion = input.nextLine();
                                                int int_extraccion = Integer.parseInt(extraccion);

                                                //mapa.planetaActual().set_cristalesHidrogeno(mapa.planetaActual().get_cristalesHidrogeno()-int_extraccion); // Re-cálculo de los recursos disponibles
                                                float gastoEnergia = (float)(0.5 * int_extraccion * (mapa.planetaActual().get_consumoEnergia() * 0.01) * (1-jugador.get_eficienciaEnergiaProteccion())); // Cálculo del gasto energético
                                                jugador.set_inv_uranio(jugador.get_inv_uranio()+int_extraccion); // Añade al inventario la extracción
                                                jugador.set_unidadesEnergiaProteccion(jugador.get_unidadesEnergiaProteccion()-gastoEnergia); // Disminuye la energía tras la extracción
                                                System.out.println();
                                                System.out.println("Has hecho una extracción de "+int_extraccion+" unidades de Uranio");
                                                System.out.println("Tras la extracción, la energía protectora disponible en el exotraje es "+jugador.get_unidadesEnergiaProteccion());
                                                System.out.println();
                                            }
                                        } else{
                                            mapa.planetaActual().extraerRecursos(4);
                                            if(!mapa.planetaActual().get_identificador().equals("Volcanico")){
                                                System.out.println("¡Advertencia! Nuestros estudios galácticos han confirmado que el Platino es un recurso exclusivo de los planetas Volcánicos");
                                                System.out.println();
                                            } else{
                                                System.out.println("¿Cuántas unidades de Platino quieres extraer?");
                                                System.out.print("Ingresa un número: ");
                                                String extraccion = input.nextLine();
                                                int int_extraccion = Integer.parseInt(extraccion);

                                                //mapa.planetaActual().set_cristalesHidrogeno(mapa.planetaActual().get_cristalesHidrogeno()-int_extraccion); // Re-cálculo de los recursos disponibles
                                                float gastoEnergia = (float)(0.5 * int_extraccion * (mapa.planetaActual().get_consumoEnergia() * 0.01) * (1-jugador.get_eficienciaEnergiaProteccion())); // Cálculo del gasto energético
                                                jugador.set_inv_platino(jugador.get_inv_platino()+int_extraccion); // Añade al inventario la extracción
                                                jugador.set_unidadesEnergiaProteccion(jugador.get_unidadesEnergiaProteccion()-gastoEnergia); // Disminuye la energía tras la extracción
                                                System.out.println();
                                                System.out.println("Has hecho una extracción de "+int_extraccion+" unidades de Platino");
                                                System.out.println("Tras la extracción, la energía protectora disponible en el exotraje es "+jugador.get_unidadesEnergiaProteccion());
                                                System.out.println();
                                            }
                                        }
                                    } else{
                                        mapa.planetaActual().salir();
                                        break;
                                    }
                                }
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
                System.out.println("2. Recargar energía protectora del exotraje y volver atrás");
                System.out.println("3. Recargar propulsores de la Nave y volver atrás");
                System.out.print("Selecciona una opción (1, 2 o 3): ");
                seleccion = input.nextLine();
                while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3")){
                    System.out.print("Error de selección, ingresa un input correcto (1, 2 o 3): ");
                    seleccion = input.nextLine();
                }
                if(seleccion.equals("1")){
                    System.out.println();
                    System.out.println("Has seleccionado: 1. Ver tu inventario y volver atrás");
                    System.out.println();
                    System.out.println("----------------------------");
                    System.out.println("¡HOLA! ESTE ES TU INVENTARIO");
                    System.out.println("----------------------------");
                    System.out.println("Cristales de Hidrógeno: "+nave.get_inv_cristalesHidrogeno()+" unidades");
                    System.out.println("Flores de Sodio: "+jugador.get_inv_floresSodio()+" unidades");
                    System.out.println("Uranio: "+jugador.get_inv_uranio()+" unidades");
                    System.out.println("Platino: "+jugador.get_inv_platino()+" unidades");
                } else if(seleccion.equals("2")){
                    String recarga;
                    int recarga_int;
                    System.out.println();
                    System.out.println("Has seleccionado: 2. Recargar energía protectora del exotraje y volver atrás");
                    System.out.println();
                    System.out.println("¿Cuántas unidades de Flores de Sodio quieres usar para hacer la recarga?");
                    System.out.print("Ingresa un número: ");
                    recarga = input.nextLine();
                    recarga_int = Integer.parseInt(recarga);
                    jugador.recargarEnergiaProteccion(recarga_int);
                } else{
                    String recarga;
                    int recarga_int;
                    System.out.println();
                    System.out.println("Has seleccionado: 3. Recargar propulsores de la Nave y volver atrás");
                    System.out.println();
                    System.out.println("¿Cuántas unidades de Cristales de Hidrógeno quieres usar para hacer la recarga?");
                    System.out.print("Ingresa un número: ");
                    recarga = input.nextLine();
                    recarga_int = Integer.parseInt(recarga);
                    nave.recargarPropulsores(recarga_int);
                }
            }
        }

        System.out.println();
        System.out.println("¡Felcidades, valiente explorador(a)... Has llegado al Centro Galáctico! :DDD");
        System.out.println();
        System.out.println("--------------- STATS Y CRÉDITOS ---------------");
        System.out.println("Energía protectora restante del exotraje: "+jugador.get_unidadesEnergiaProteccion());
        System.out.println("Eficiencia de la energía protectora del exotraje: "+jugador.get_eficienciaEnergiaProteccion());
        System.out.println("Cristales de Hidrógeno en el inventario: "+nave.get_inv_cristalesHidrogeno());
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