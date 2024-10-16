public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    
    private float inv_floresSodio;
    private float inv_uranio;
    private float inv_platino;

    public Jugador(){ // Constructor
        this.unidadesEnergiaProteccion = 100;
        this.eficienciaEnergiaProteccion = 0;
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
    public void set_inv_floresSodio(float flores){ // Setter Flores Sodio del inventario
        this.inv_floresSodio = flores;
        return;
    }
    public void set_inv_uranio(float uranio){ // Setter Uranio del inventario
        this.inv_uranio = uranio;
        return;
    }
    public void set_inv_platino(float platino){ // Setter Platino del inventario
        this.inv_platino = platino;
        return;
    }

    public void recargarEnergiaProteccion(int sodio){
        if (sodio <= this.inv_floresSodio){
            float aRecargar = (float)(0.65 * sodio * (1+this.eficienciaEnergiaProteccion));
            this.unidadesEnergiaProteccion += aRecargar;
            this.inv_floresSodio -= sodio;
            System.out.println("Se han recargado "+aRecargar+" unidades de protección al exotraje usando "+sodio+" unidades de Flores de Sodio del inventario");
        } else{
            System.out.println("¡Oh, no! La cantidad de Flores de Sodio disponible en el inventario no es suficiente para hacer esta recarga");
            return;
        }
        return;
    }
}
