public abstract class Planeta {
    private int radio;
    private int cristalesHidrogeno;
    private int floresSodio;
    private int consumoEnergia;
    private String identificador;
    private boolean indicadorVisita = false;

    public Planeta(){ // Constructor

    }

    public int get_radio(){ // Getter Radio
        return this.radio;
    }
    public int get_cristalesHidrogeno(){ // Getter Cristales de Hidrógeno
        return this.cristalesHidrogeno;
    }
    public int get_floresSodio(){ // Getter Flores de Sodio
        return this.floresSodio;
    }
    public int get_consumoEnergia(){ // Getter Consumo Energía
        return this.consumoEnergia;
    }
    public String get_identificador(){ // Getter Identificador
        return this.identificador;
    }
    public boolean get_indicadorVisita(){ // Getter indicador visita
        return this.indicadorVisita;
    }
    public void set_radio(int radius){ // Setter Radio
        this.radio = radius;
        return;
    }
    public void set_cristalesHidrogeno(int cristales){ // Setter Cristales de Hidrógeno
        this.cristalesHidrogeno = cristales;
        return;
    }
    public void set_floresSodio(int flores){ // Setter Flores de Sodio
        this.floresSodio = flores;
        return;
    }
    public void set_consumoEnergia(int consumo){ // Setter Consumo Energía
        this.consumoEnergia = consumo;
        return;
    }
    public void set_identificador(String id){ // Setter Identificador
        this.identificador = id;
        return;
    }
    public void set_indicadorVisita(boolean indicator){ // Setter Indicador de visita (no se usó en el código final)
        this.indicadorVisita = indicator;
        return;
    }

    public boolean visitar(Jugador jugador){
        this.indicadorVisita = true;
        // System.out.println("Consumo: "+this.consumoEnergia);
        float energia_final = jugador.get_unidadesEnergiaProteccion()-this.consumoEnergia;
        jugador.set_unidadesEnergiaProteccion(energia_final);
        return true;
    }

    public int extraerRecursos(int tipo){
        if (this.indicadorVisita == true){
            if(tipo == 1){
                System.out.println();
                System.out.println("Has seleccionado: 1. Cristales de Hidrógeno");
                System.out.println();
            } else if (tipo == 2){
                System.out.println();
                System.out.println("Has seleccionado: 2. Flores de Sodio");
                System.out.println();
            } else if (tipo == 3){
                System.out.println();
                System.out.println("Has seleccionado: 3. Uranio");
                System.out.println();
            } else if (tipo == 4){
                System.out.println();
                System.out.println("Has seleccionado: 4. Platino");
                System.out.println();
            }
            return 0;
        } else{
            System.out.println("¡No puedes extraer recursos de un planeta si no lo has visitado!");
            return 0;
        }
    }

    public abstract int caracteristicaPlaneta(); // Una especie de Getter para los atributos únicos de las clases hijas

    public boolean salir(){
        this.indicadorVisita = false;
        return true;
    }
}