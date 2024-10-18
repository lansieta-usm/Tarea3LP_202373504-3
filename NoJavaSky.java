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
            System.out.println();
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
                        System.out.println("HINT: Mejora la eficiencia del propulsor de tu Nave");
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
                                        System.out.println();
                                        System.out.println("Has seleccionado: 2. Intercambiar recursos");
                                        System.out.println();
                                        if(mapa.planetaActual().get_identificador().equals("Helado")){ // Intercambios en un Planeta Helado
                                            int randint = (int)(0 + Math.random() * ((100 - 0) + 1)); // Probabilidad
                                            System.out.println("¡Te damos la bienvenida al MercadoHelado... Un lugar donde TE CONGELARÁS del asombro al ver las ofertas!");
                                            System.out.println();
                                            int puestos;
                                            if(randint < 33){
                                                puestos = 1;
                                            } else if(randint < 66){
                                                puestos = 2;
                                            } else{
                                                puestos = 3;
                                            }
                                            if(puestos == 1){
                                                System.out.println("Hoy sólo hay un puesto abierto en el MercadoHelado");
                                                System.out.println();
                                                float mejora1 = tieneAsentamientos.generarMejora();
                                                float mejora2 = tieneAsentamientos.generarMejora();
                                                int precio1 = tieneAsentamientos.generarPrecioHelado();
                                                int precio2 = tieneAsentamientos.generarPrecioHelado();
                                                System.out.println("-------------------- PUESTO #1 --------------------");
                                                System.out.println("Opción 1: +"+mejora1*100+"% de eficiencia de propulsor de la Nave por "+precio1+" unidades de Uranio");
                                                System.out.println("Opción 2: +"+mejora2*100+"% de eficiencia de energía protectora del exotraje por "+precio2+" unidades de Platino");
                                                System.out.println("---------------------------------------------------");
                                                System.out.println();
                                                System.out.println("¿Qué te gustaría hacer?");
                                                System.out.println("1. Comprar opción 1");
                                                System.out.println("2. Comprar opción 2");
                                                System.out.println("3. Salir del MercadoHelado");
                                                System.out.print("Selecciona una opción (1, 2 o 3): ");
                                                seleccion = input.nextLine();
                                                while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3")){
                                                    System.out.print("Error de selección, ingresa un input correcto (1, 2 o 3): ");
                                                    seleccion = input.nextLine();
                                                }
                                                if(seleccion.equals("1")){
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 1. Comprar opción 1");
                                                    System.out.println();
                                                    if(jugador.get_inv_uranio()-precio1 >= 0){
                                                        nave.set_eficienciaPropulsor(nave.get_eficienciaPropulsor()+mejora1);
                                                        jugador.set_inv_uranio(jugador.get_inv_uranio()-precio1);
                                                        System.out.println("¡Excelente alternativa! Has mejorado en un "+mejora1*100+"% la eficiencia del propulsor de la Nave usando "+precio1+" unidades de Uranio del inventario");
                                                        System.out.println();
                                                    } else{
                                                        System.out.println("¡Oh, no! Parece ser que no te alcanza... Vuelve otro día");
                                                        System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                        System.out.println();
                                                    }
                                                } else if(seleccion.equals("2")){
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 2. Comprar opción 2");
                                                    System.out.println();
                                                    if(jugador.get_inv_platino()-precio2 >= 0){
                                                        jugador.set_eficienciaEnergiaProteccion(jugador.get_eficienciaEnergiaProteccion()+mejora2);
                                                        jugador.set_inv_platino(jugador.get_inv_platino()-precio2);
                                                        System.out.println("¡Excelente alternativa! Has mejorado en un "+mejora2*100+"% la eficiencia del propulsor de la Nave usando "+precio2+" unidades de Platino del inventario");
                                                        System.out.println();
                                                    } else{
                                                        System.out.println("¡Oh, no! Parece ser que no te alcanza... Vuelve otro día");
                                                        System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                        System.out.println();
                                                    }
                                                } else{
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 3. Salir del MercadoHelado");
                                                    System.out.println();
                                                    System.out.println("El MercadoHelado ha cerrado sus puertas por hoy... ¡Esperamos volver a verte pronto!");
                                                    System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                    System.out.println();
                                                }
                                            } else if(puestos == 2){
                                                System.out.println("Hoy hay dos puestos abiertos en el MercadoHelado");
                                                System.out.println();
                                                float mejora1 = tieneAsentamientos.generarMejora();
                                                float mejora2 = tieneAsentamientos.generarMejora();
                                                float mejora3 = tieneAsentamientos.generarMejora();
                                                float mejora4 = tieneAsentamientos.generarMejora();
                                                int precio1 = tieneAsentamientos.generarPrecioHelado();
                                                int precio2 = tieneAsentamientos.generarPrecioHelado();
                                                int precio3 = tieneAsentamientos.generarPrecioHelado();
                                                int precio4 = tieneAsentamientos.generarPrecioHelado();
                                                System.out.println("-------------------- PUESTO #1 --------------------");
                                                System.out.println("Opción 1: +"+mejora1*100+"% de eficiencia de propulsor de la Nave por "+precio1+" unidades de Uranio");
                                                System.out.println("Opción 2: +"+mejora2*100+"% de eficiencia de energía protectora del exotraje por "+precio2+" unidades de Platino");
                                                System.out.println("---------------------------------------------------");
                                                System.out.println();
                                                System.out.println("-------------------- PUESTO #2 --------------------");
                                                System.out.println("Opción 1: +"+mejora1*100+"% de eficiencia de propulsor de la Nave por "+precio1+" unidades de Uranio");
                                                System.out.println("Opción 2: +"+mejora2*100+"% de eficiencia de energía protectora del exotraje por "+precio2+" unidades de Platino");
                                                System.out.println("---------------------------------------------------");
                                                System.out.println();
                                                System.out.println("¿A qué puesto te quieres dirigir?");
                                                System.out.println("1. PUESTO #1");
                                                System.out.println("2. PUESTO #2");
                                                System.out.print("Selecciona una opción (1 o 2): ");
                                                seleccion = input.nextLine();
                                                while(!seleccion.equals("1") && !seleccion.equals("2")){
                                                    System.out.print("Error de selección, ingresa un input correcto (1 o 2): ");
                                                    seleccion = input.nextLine();
                                                }
                                                int puesto_seleccionado = Integer.parseInt(seleccion);
                                                System.out.println();
                                                System.out.println("¿Qué te gustaría hacer?");
                                                System.out.println("1. Comprar opción 1");
                                                System.out.println("2. Comprar opción 2");
                                                System.out.println("3. Salir del MercadoHelado");
                                                System.out.print("Selecciona una opción (1, 2 o 3): ");
                                                seleccion = input.nextLine();
                                                while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3")){
                                                    System.out.print("Error de selección, ingresa un input correcto (1, 2 o 3): ");
                                                    seleccion = input.nextLine();
                                                }
                                                if(seleccion.equals("1")){
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 1. Comprar opción 1");
                                                    System.out.println();
                                                    int precio_final;
                                                    float mejora_final;
                                                    if(puesto_seleccionado == 1){
                                                        precio_final = precio1;
                                                        mejora_final = mejora1;
                                                    } else{
                                                        precio_final = precio3;
                                                        mejora_final = mejora3;
                                                    }
                                                    if(jugador.get_inv_uranio()-precio_final >= 0){
                                                        nave.set_eficienciaPropulsor(nave.get_eficienciaPropulsor()+mejora_final);
                                                        jugador.set_inv_uranio(jugador.get_inv_uranio()-precio_final);
                                                        System.out.println("¡Excelente alternativa! Has mejorado en un "+mejora_final*100+"% la eficiencia del propulsor de la Nave usando "+precio_final+" unidades de Uranio del inventario");
                                                        System.out.println();
                                                    } else{
                                                        System.out.println("¡Oh, no! Parece ser que no te alcanza... Vuelve otro día");
                                                        System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                        System.out.println();
                                                    }
                                                } else if(seleccion.equals("2")){
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 2. Comprar opción 2");
                                                    System.out.println();
                                                    int precio_final;
                                                    float mejora_final;
                                                    if(puesto_seleccionado == 1){
                                                        precio_final = precio2;
                                                        mejora_final = mejora2;
                                                    } else{
                                                        precio_final = precio4;
                                                        mejora_final = mejora4;
                                                    }
                                                    if(jugador.get_inv_platino()-precio_final >= 0){
                                                        jugador.set_eficienciaEnergiaProteccion(jugador.get_eficienciaEnergiaProteccion()+mejora_final);
                                                        jugador.set_inv_platino(jugador.get_inv_platino()-precio_final);
                                                        System.out.println("¡Excelente alternativa! Has mejorado en un "+mejora_final*100+"% la eficiencia del propulsor de la Nave usando "+precio_final+" unidades de Platino del inventario");
                                                        System.out.println();
                                                    } else{
                                                        System.out.println("¡Oh, no! Parece ser que no te alcanza... Vuelve otro día");
                                                        System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                        System.out.println();
                                                    }
                                                } else{
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 3. Salir del MercadoHelado");
                                                    System.out.println();
                                                    System.out.println("El MercadoHelado ha cerrado sus puertas por hoy... ¡Esperamos volver a verte pronto!");
                                                    System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                    System.out.println();
                                                }
                                            } else{
                                                System.out.println("Hoy los 3 puestos están abiertos en el MercadoHelado");
                                                System.out.println();
                                                float mejora1 = tieneAsentamientos.generarMejora();
                                                float mejora2 = tieneAsentamientos.generarMejora();
                                                float mejora3 = tieneAsentamientos.generarMejora();
                                                float mejora4 = tieneAsentamientos.generarMejora();
                                                float mejora5 = tieneAsentamientos.generarMejora();
                                                float mejora6 = tieneAsentamientos.generarMejora();
                                                int precio1 = tieneAsentamientos.generarPrecioHelado();
                                                int precio2 = tieneAsentamientos.generarPrecioHelado();
                                                int precio3 = tieneAsentamientos.generarPrecioHelado();
                                                int precio4 = tieneAsentamientos.generarPrecioHelado();
                                                int precio5 = tieneAsentamientos.generarPrecioHelado();
                                                int precio6 = tieneAsentamientos.generarPrecioHelado();
                                                System.out.println("-------------------- PUESTO #1 --------------------");
                                                System.out.println("Opción 1: +"+mejora1*100+"% de eficiencia de propulsor de la Nave por "+precio1+" unidades de Uranio");
                                                System.out.println("Opción 2: +"+mejora2*100+"% de eficiencia de energía protectora del exotraje por "+precio2+" unidades de Platino");
                                                System.out.println("---------------------------------------------------");
                                                System.out.println();
                                                System.out.println("-------------------- PUESTO #2 --------------------");
                                                System.out.println("Opción 1: +"+mejora1*100+"% de eficiencia de propulsor de la Nave por "+precio1+" unidades de Uranio");
                                                System.out.println("Opción 2: +"+mejora2*100+"% de eficiencia de energía protectora del exotraje por "+precio2+" unidades de Platino");
                                                System.out.println("---------------------------------------------------");
                                                System.out.println();
                                                System.out.println("-------------------- PUESTO #3 --------------------");
                                                System.out.println("Opción 1: +"+mejora1*100+"% de eficiencia de propulsor de la Nave por "+precio1+" unidades de Uranio");
                                                System.out.println("Opción 2: +"+mejora2*100+"% de eficiencia de energía protectora del exotraje por "+precio2+" unidades de Platino");
                                                System.out.println("---------------------------------------------------");
                                                System.out.println();
                                                System.out.println("¿A qué puesto te quieres dirigir?");
                                                System.out.println("1. PUESTO #1");
                                                System.out.println("2. PUESTO #2");
                                                System.out.println("3. PUESTO #3");
                                                System.out.print("Selecciona una opción (1, 2 o 3): ");
                                                seleccion = input.nextLine();
                                                while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3")){
                                                    System.out.print("Error de selección, ingresa un input correcto (1, 2 o 3): ");
                                                    seleccion = input.nextLine();
                                                }
                                                int puesto_seleccionado = Integer.parseInt(seleccion);
                                                System.out.println();
                                                System.out.println("¿Qué te gustaría hacer?");
                                                System.out.println("1. Comprar opción 1");
                                                System.out.println("2. Comprar opción 2");
                                                System.out.println("3. Salir del MercadoHelado");
                                                System.out.print("Selecciona una opción (1, 2 o 3): ");
                                                seleccion = input.nextLine();
                                                while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3")){
                                                    System.out.print("Error de selección, ingresa un input correcto (1, 2 o 3): ");
                                                    seleccion = input.nextLine();
                                                }
                                                if(seleccion.equals("1")){
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 1. Comprar opción 1");
                                                    System.out.println();
                                                    int precio_final;
                                                    float mejora_final;
                                                    if(puesto_seleccionado == 1){
                                                        precio_final = precio1;
                                                        mejora_final = mejora1;
                                                    } else if(puesto_seleccionado == 2){
                                                        precio_final = precio3;
                                                        mejora_final = mejora3;
                                                    } else{
                                                        precio_final = precio5;
                                                        mejora_final = mejora5;
                                                    }
                                                    if(jugador.get_inv_uranio()-precio_final >= 0){
                                                        nave.set_eficienciaPropulsor(nave.get_eficienciaPropulsor()+mejora_final);
                                                        jugador.set_inv_uranio(jugador.get_inv_uranio()-precio_final);
                                                        System.out.println("¡Excelente alternativa! Has mejorado en un "+mejora_final*100+"% la eficiencia del propulsor de la Nave usando "+precio_final+" unidades de Uranio del inventario");
                                                        System.out.println();
                                                    } else{
                                                        System.out.println("¡Oh, no! Parece ser que no te alcanza... Vuelve otro día");
                                                        System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                        System.out.println();
                                                    }
                                                } else if(seleccion.equals("2")){
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 2. Comprar opción 2");
                                                    System.out.println();
                                                    int precio_final;
                                                    float mejora_final;
                                                    if(puesto_seleccionado == 1){
                                                        precio_final = precio2;
                                                        mejora_final = mejora2;
                                                    } else if(puesto_seleccionado == 2){
                                                        precio_final = precio4;
                                                        mejora_final = mejora4;
                                                    } else{
                                                        precio_final = precio6;
                                                        mejora_final = mejora6;
                                                    }
                                                    if(jugador.get_inv_platino()-precio_final >= 0){
                                                        jugador.set_eficienciaEnergiaProteccion(jugador.get_eficienciaEnergiaProteccion()+mejora_final);
                                                        jugador.set_inv_platino(jugador.get_inv_platino()-precio_final);
                                                        System.out.println("¡Excelente alternativa! Has mejorado en un "+mejora_final*100+"% la eficiencia del propulsor de la Nave usando "+precio_final+" unidades de Platino del inventario");
                                                        System.out.println();
                                                    } else{
                                                        System.out.println("¡Oh, no! Parece ser que no te alcanza... Vuelve otro día");
                                                        System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                        System.out.println();
                                                    }
                                                } else{
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 3. Salir del MercadoHelado");
                                                    System.out.println();
                                                    System.out.println("El MercadoHelado ha cerrado sus puertas por hoy... ¡Esperamos volver a verte pronto!");
                                                    System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                    System.out.println();
                                                }
                                            }
                                        } else{ // Intercambios en un planeta Oceanico
                                            int randint = (int)(0 + Math.random() * ((100 - 0) + 1)); // Probabilidad
                                            System.out.println("¡Te damos la bienvenida al AquaMarket... Un lugar donde los altos precios SE EVAPORAN como el agua de los océanos!");
                                            System.out.println();
                                            int puestos;
                                            if(randint < 33){
                                                puestos = 1;
                                            } else if(randint < 66){
                                                puestos = 2;
                                            } else{
                                                puestos = 3;
                                            }
                                            if(puestos == 1){
                                                System.out.println("Hoy sólo hay un puesto abierto en el AquaMarket");
                                                System.out.println();
                                                float mejora1 = tieneAsentamientos.generarMejora();
                                                float mejora2 = tieneAsentamientos.generarMejora();
                                                int precio1 = tieneAsentamientos.generarPrecioOceanco();
                                                int precio2 = tieneAsentamientos.generarPrecioOceanco();
                                                System.out.println("-------------------- PUESTO #1 --------------------");
                                                System.out.println("Opción 1: +"+mejora1*100+"% de eficiencia de propulsor de la Nave por "+precio1+" unidades de Uranio");
                                                System.out.println("Opción 2: +"+mejora2*100+"% de eficiencia de energía protectora del exotraje por "+precio2+" unidades de Platino");
                                                System.out.println("---------------------------------------------------");
                                                System.out.println();
                                                System.out.println("¿Qué te gustaría hacer?");
                                                System.out.println("1. Comprar opción 1");
                                                System.out.println("2. Comprar opción 2");
                                                System.out.println("3. Salir del AquaMarket");
                                                System.out.print("Selecciona una opción (1, 2 o 3): ");
                                                seleccion = input.nextLine();
                                                while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3")){
                                                    System.out.print("Error de selección, ingresa un input correcto (1, 2 o 3): ");
                                                    seleccion = input.nextLine();
                                                }
                                                if(seleccion.equals("1")){
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 1. Comprar opción 1");
                                                    System.out.println();
                                                    if(jugador.get_inv_uranio()-precio1 >= 0){
                                                        nave.set_eficienciaPropulsor(nave.get_eficienciaPropulsor()+mejora1);
                                                        jugador.set_inv_uranio(jugador.get_inv_uranio()-precio1);
                                                        System.out.println("¡Excelente alternativa! Has mejorado en un "+mejora1*100+"% la eficiencia del propulsor de la Nave usando "+precio1+" unidades de Uranio del inventario");
                                                        System.out.println();
                                                    } else{
                                                        System.out.println("¡Oh, no! Parece ser que no te alcanza... Vuelve otro día");
                                                        System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                        System.out.println();
                                                    }
                                                } else if(seleccion.equals("2")){
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 2. Comprar opción 2");
                                                    System.out.println();
                                                    if(jugador.get_inv_platino()-precio2 >= 0){
                                                        jugador.set_eficienciaEnergiaProteccion(jugador.get_eficienciaEnergiaProteccion()+mejora2);
                                                        jugador.set_inv_platino(jugador.get_inv_platino()-precio2);
                                                        System.out.println("¡Excelente alternativa! Has mejorado en un "+mejora2*100+"% la eficiencia del propulsor de la Nave usando "+precio2+" unidades de Platino del inventario");
                                                        System.out.println();
                                                    } else{
                                                        System.out.println("¡Oh, no! Parece ser que no te alcanza... Vuelve otro día");
                                                        System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                        System.out.println();
                                                    }
                                                } else{
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 3. Salir del AquaMarket");
                                                    System.out.println();
                                                    System.out.println("El AquaMarket ha cerrado sus puertas por hoy... ¡Esperamos volver a verte pronto!");
                                                    System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                    System.out.println();
                                                }
                                            } else if(puestos == 2){
                                                System.out.println("Hoy hay dos puestos abiertos en el AquaMarket");
                                                System.out.println();
                                                float mejora1 = tieneAsentamientos.generarMejora();
                                                float mejora2 = tieneAsentamientos.generarMejora();
                                                float mejora3 = tieneAsentamientos.generarMejora();
                                                float mejora4 = tieneAsentamientos.generarMejora();
                                                int precio1 = tieneAsentamientos.generarPrecioOceanco();
                                                int precio2 = tieneAsentamientos.generarPrecioOceanco();
                                                int precio3 = tieneAsentamientos.generarPrecioOceanco();
                                                int precio4 = tieneAsentamientos.generarPrecioOceanco();
                                                System.out.println("-------------------- PUESTO #1 --------------------");
                                                System.out.println("Opción 1: +"+mejora1*100+"% de eficiencia de propulsor de la Nave por "+precio1+" unidades de Uranio");
                                                System.out.println("Opción 2: +"+mejora2*100+"% de eficiencia de energía protectora del exotraje por "+precio2+" unidades de Platino");
                                                System.out.println("---------------------------------------------------");
                                                System.out.println();
                                                System.out.println("-------------------- PUESTO #2 --------------------");
                                                System.out.println("Opción 1: +"+mejora1*100+"% de eficiencia de propulsor de la Nave por "+precio1+" unidades de Uranio");
                                                System.out.println("Opción 2: +"+mejora2*100+"% de eficiencia de energía protectora del exotraje por "+precio2+" unidades de Platino");
                                                System.out.println("---------------------------------------------------");
                                                System.out.println();
                                                System.out.println("¿A qué puesto te quieres dirigir?");
                                                System.out.println("1. PUESTO #1");
                                                System.out.println("2. PUESTO #2");
                                                System.out.print("Selecciona una opción (1 o 2): ");
                                                seleccion = input.nextLine();
                                                while(!seleccion.equals("1") && !seleccion.equals("2")){
                                                    System.out.print("Error de selección, ingresa un input correcto (1 o 2): ");
                                                    seleccion = input.nextLine();
                                                }
                                                int puesto_seleccionado = Integer.parseInt(seleccion);
                                                System.out.println();
                                                System.out.println("¿Qué te gustaría hacer?");
                                                System.out.println("1. Comprar opción 1");
                                                System.out.println("2. Comprar opción 2");
                                                System.out.println("3. Salir del AquaMarket");
                                                System.out.print("Selecciona una opción (1, 2 o 3): ");
                                                seleccion = input.nextLine();
                                                while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3")){
                                                    System.out.print("Error de selección, ingresa un input correcto (1, 2 o 3): ");
                                                    seleccion = input.nextLine();
                                                }
                                                if(seleccion.equals("1")){
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 1. Comprar opción 1");
                                                    System.out.println();
                                                    int precio_final;
                                                    float mejora_final;
                                                    if(puesto_seleccionado == 1){
                                                        precio_final = precio1;
                                                        mejora_final = mejora1;
                                                    } else{
                                                        precio_final = precio3;
                                                        mejora_final = mejora3;
                                                    }
                                                    if(jugador.get_inv_uranio()-precio_final >= 0){
                                                        nave.set_eficienciaPropulsor(nave.get_eficienciaPropulsor()+mejora_final);
                                                        jugador.set_inv_uranio(jugador.get_inv_uranio()-precio_final);
                                                        System.out.println("¡Excelente alternativa! Has mejorado en un "+mejora_final*100+"% la eficiencia del propulsor de la Nave usando "+precio_final+" unidades de Uranio del inventario");
                                                        System.out.println();
                                                    } else{
                                                        System.out.println("¡Oh, no! Parece ser que no te alcanza... Vuelve otro día");
                                                        System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                        System.out.println();
                                                    }
                                                } else if(seleccion.equals("2")){
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 2. Comprar opción 2");
                                                    System.out.println();
                                                    int precio_final;
                                                    float mejora_final;
                                                    if(puesto_seleccionado == 1){
                                                        precio_final = precio2;
                                                        mejora_final = mejora2;
                                                    } else{
                                                        precio_final = precio4;
                                                        mejora_final = mejora4;
                                                    }
                                                    if(jugador.get_inv_platino()-precio_final >= 0){
                                                        jugador.set_eficienciaEnergiaProteccion(jugador.get_eficienciaEnergiaProteccion()+mejora_final);
                                                        jugador.set_inv_platino(jugador.get_inv_platino()-precio_final);
                                                        System.out.println("¡Excelente alternativa! Has mejorado en un "+mejora_final*100+"% la eficiencia del propulsor de la Nave usando "+precio_final+" unidades de Platino del inventario");
                                                        System.out.println();
                                                    } else{
                                                        System.out.println("¡Oh, no! Parece ser que no te alcanza... Vuelve otro día");
                                                        System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                        System.out.println();
                                                    }
                                                } else{
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 3. Salir del AquaMarket");
                                                    System.out.println();
                                                    System.out.println("El AquaMarket ha cerrado sus puertas por hoy... ¡Esperamos volver a verte pronto!");
                                                    System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                    System.out.println();
                                                }
                                            } else{
                                                System.out.println("Hoy los 3 puestos están abiertos en el AquaMarket");
                                                System.out.println();
                                                float mejora1 = tieneAsentamientos.generarMejora();
                                                float mejora2 = tieneAsentamientos.generarMejora();
                                                float mejora3 = tieneAsentamientos.generarMejora();
                                                float mejora4 = tieneAsentamientos.generarMejora();
                                                float mejora5 = tieneAsentamientos.generarMejora();
                                                float mejora6 = tieneAsentamientos.generarMejora();
                                                int precio1 = tieneAsentamientos.generarPrecioOceanco();
                                                int precio2 = tieneAsentamientos.generarPrecioOceanco();
                                                int precio3 = tieneAsentamientos.generarPrecioOceanco();
                                                int precio4 = tieneAsentamientos.generarPrecioOceanco();
                                                int precio5 = tieneAsentamientos.generarPrecioOceanco();
                                                int precio6 = tieneAsentamientos.generarPrecioOceanco();
                                                System.out.println("-------------------- PUESTO #1 --------------------");
                                                System.out.println("Opción 1: +"+mejora1*100+"% de eficiencia de propulsor de la Nave por "+precio1+" unidades de Uranio");
                                                System.out.println("Opción 2: +"+mejora2*100+"% de eficiencia de energía protectora del exotraje por "+precio2+" unidades de Platino");
                                                System.out.println("---------------------------------------------------");
                                                System.out.println();
                                                System.out.println("-------------------- PUESTO #2 --------------------");
                                                System.out.println("Opción 1: +"+mejora1*100+"% de eficiencia de propulsor de la Nave por "+precio1+" unidades de Uranio");
                                                System.out.println("Opción 2: +"+mejora2*100+"% de eficiencia de energía protectora del exotraje por "+precio2+" unidades de Platino");
                                                System.out.println("---------------------------------------------------");
                                                System.out.println();
                                                System.out.println("-------------------- PUESTO #3 --------------------");
                                                System.out.println("Opción 1: +"+mejora1*100+"% de eficiencia de propulsor de la Nave por "+precio1+" unidades de Uranio");
                                                System.out.println("Opción 2: +"+mejora2*100+"% de eficiencia de energía protectora del exotraje por "+precio2+" unidades de Platino");
                                                System.out.println("---------------------------------------------------");
                                                System.out.println();
                                                System.out.println("¿A qué puesto te quieres dirigir?");
                                                System.out.println("1. PUESTO #1");
                                                System.out.println("2. PUESTO #2");
                                                System.out.println("3. PUESTO #3");
                                                System.out.print("Selecciona una opción (1, 2 o 3): ");
                                                seleccion = input.nextLine();
                                                while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3")){
                                                    System.out.print("Error de selección, ingresa un input correcto (1, 2 o 3): ");
                                                    seleccion = input.nextLine();
                                                }
                                                int puesto_seleccionado = Integer.parseInt(seleccion);
                                                System.out.println();
                                                System.out.println("¿Qué te gustaría hacer?");
                                                System.out.println("1. Comprar opción 1");
                                                System.out.println("2. Comprar opción 2");
                                                System.out.println("3. Salir del AquaMarket");
                                                System.out.print("Selecciona una opción (1, 2 o 3): ");
                                                seleccion = input.nextLine();
                                                while(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3")){
                                                    System.out.print("Error de selección, ingresa un input correcto (1, 2 o 3): ");
                                                    seleccion = input.nextLine();
                                                }
                                                if(seleccion.equals("1")){
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 1. Comprar opción 1");
                                                    System.out.println();
                                                    int precio_final;
                                                    float mejora_final;
                                                    if(puesto_seleccionado == 1){
                                                        precio_final = precio1;
                                                        mejora_final = mejora1;
                                                    } else if(puesto_seleccionado == 2){
                                                        precio_final = precio3;
                                                        mejora_final = mejora3;
                                                    } else{
                                                        precio_final = precio5;
                                                        mejora_final = mejora5;
                                                    }
                                                    if(jugador.get_inv_uranio()-precio_final >= 0){
                                                        nave.set_eficienciaPropulsor(nave.get_eficienciaPropulsor()+mejora_final);
                                                        jugador.set_inv_uranio(jugador.get_inv_uranio()-precio_final);
                                                        System.out.println("¡Excelente alternativa! Has mejorado en un "+mejora_final*100+"% la eficiencia del propulsor de la Nave usando "+precio_final+" unidades de Uranio del inventario");
                                                        System.out.println();
                                                    } else{
                                                        System.out.println("¡Oh, no! Parece ser que no te alcanza... Vuelve otro día");
                                                        System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                        System.out.println();
                                                    }
                                                } else if(seleccion.equals("2")){
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 2. Comprar opción 2");
                                                    System.out.println();
                                                    int precio_final;
                                                    float mejora_final;
                                                    if(puesto_seleccionado == 1){
                                                        precio_final = precio2;
                                                        mejora_final = mejora2;
                                                    } else if(puesto_seleccionado == 2){
                                                        precio_final = precio4;
                                                        mejora_final = mejora4;
                                                    } else{
                                                        precio_final = precio6;
                                                        mejora_final = mejora6;
                                                    }
                                                    if(jugador.get_inv_platino()-precio_final >= 0){
                                                        jugador.set_eficienciaEnergiaProteccion(jugador.get_eficienciaEnergiaProteccion()+mejora_final);
                                                        jugador.set_inv_platino(jugador.get_inv_platino()-precio_final);
                                                        System.out.println("¡Excelente alternativa! Has mejorado en un "+mejora_final*100+"% la eficiencia del propulsor de la Nave usando "+precio_final+" unidades de Platino del inventario");
                                                        System.out.println();
                                                    } else{
                                                        System.out.println("¡Oh, no! Parece ser que no te alcanza... Vuelve otro día");
                                                        System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                        System.out.println();
                                                    }
                                                } else{
                                                    System.out.println();
                                                    System.out.println("Has seleccionado: 3. Salir del AquaMarket");
                                                    System.out.println();
                                                    System.out.println("El AquaMarket ha cerrado sus puertas por hoy... ¡Esperamos volver a verte pronto!");
                                                    System.out.println("NOTA: Debido a la economía inestable que se vive en "+mapa.planetaActual()+", los precios varían todos los días");
                                                    System.out.println();
                                                }
                                            }
                                        }
                                    } else{
                                        System.out.println();
                                        System.out.println("Saliendo de "+mapa.planetaActual()+"... ¡Esa fue una buena expedición!");
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
                                        System.out.println();
                                        System.out.println("Saliendo de "+mapa.planetaActual()+"... ¡Esa fue una buena expedición!");
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