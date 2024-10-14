public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private float inv_cristalesHidrogeno;
    private float inv_floresSodio;
    private float inv_uranio;
    private float inv_platino;

    public Jugador(){ // Constructor
        this.unidadesEnergiaProteccion = 100;
        this.eficienciaEnergiaProteccion = 0;
        this.inv_cristalesHidrogeno = 0;
        this.inv_floresSodio = 0;
        this.inv_uranio = 0;
        this.inv_platino = 0;
    }

    public float get_unidadesEnergiaProteccion(){ // Getter Unidades Energía Protección
        return this.unidadesEnergiaProteccion;
    }
    public float get_eficienciaEnergiaProteccion(){ // Getter Eficiencia Enegería Protección
        return this.eficienciaEnergiaProteccion;
    }
    public float get_inv_cristalesHidrogeno(){ // Getter Cristales de Hidrógeno del inventario
        return this.inv_cristalesHidrogeno;
    }
    public float get_inv_floresSodio(){ // Getter Flores de Sodio del inventario
        return this.inv_floresSodio;
    }
    public float get_inv_uranio(){ // Getter Uranio del inventario
        return this.inv_uranio;
    }
    public float get_inv_platino(){ // Getter Platino del inventario
        return this.inv_platino;
    }
    public void set_unidadesEnergiaProteccion(float uep){ // Setter Unidades Energía Protección
        this.unidadesEnergiaProteccion = uep;
        return;
    }
    public void set_eficienciaEnergiaProteccion(float eep){ // Setter Eficiencia Energía Protección
        this.eficienciaEnergiaProteccion = eep;
        return;
    }

    public void recargarEnergiaProteccion(int sodio){
        if (sodio <= this.inv_floresSodio){
            float aRecargar = (float)(0.65 * sodio * (1+this.eficienciaEnergiaProteccion));
            this.unidadesEnergiaProteccion += aRecargar;
            this.inv_floresSodio -= sodio;
            System.out.println("Se han recargado "+aRecargar+" unidades de protección al exotraje usando "+sodio+" unidades de Flores de Sodio del inventario");
        } else{
            System.out.println("¡Oh, no! La cantidad de Flores de Sodio disponible en el inventario no es suficiente para recargar la protección del exotraje");
            return;
        }
        return;
    }
}
