public abstract class Planeta {
    private int radio;
    private int cristalesHidrogeno;
    private int floresSodio;
    private int consumoEnergia;

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

    /*
    public boolean visitar(Jugador jugador){
    
    }

    public int extraerRecursos(int tipo){

    }

    public boolean salir(){

    }
    */
}
