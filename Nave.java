public class Nave {
    private float unidadesCombustible;
    private float eficienciaPropulsor;

    public Nave(){ // Constructor
        this.unidadesCombustible = 100;
        this.eficienciaPropulsor = 0;
    }

    public float get_unidadesCombustible(){ // Getter Unidades Combustible
        return this.unidadesCombustible;
    }
    public float get_eficienciaPropulsor(){ // Getter Eficiencia Propulsor
        return this.eficienciaPropulsor;
    }
    /*
    public void set_unidadesCombustible(float combustible){ // Setter Unidades Combustible
        this.unidadesCombustible = combustible;
        return;
    }
    public void set_eficienciaPropulsor(float eficiencia){ // Setter Eficiencia Propulsor
        this.eficienciaPropulsor = eficiencia;
        return;
    }
    */
    
    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto){
        int pos = MG.get_posicion();
        float comb = get_unidadesCombustible();
        float unidadesConsumidas = (float)(0.75 * tamanoSalto * tamanoSalto * (1-this.eficienciaPropulsor));
        if (direccion == 1){
            if ((pos+tamanoSalto) < MG.get_planetas().size()) {
                if (this.unidadesCombustible - unidadesConsumidas >= 0){
                    pos = pos+tamanoSalto;
                    comb = comb-unidadesConsumidas;
                    MG.set_posicion(pos);
                    this.unidadesCombustible = comb;
                    System.out.println("¡Felicidades! Has hecho un avance en el mapa.");
                    return true;
                } else{
                    System.out.println("¡Oh, no! El combustible disponible no es suficiente para el salto que se quiere dar.");
                    return false;
                }
            } else {
                System.out.println("El salto que quieres hacer está por encima del tamaño del mapa.");
                return false;
            }
        } else{
            if ((pos-tamanoSalto) >= 0) {
                if (this.unidadesCombustible - unidadesConsumidas >= 0) {
                    pos = pos-tamanoSalto;
                    comb = comb-unidadesConsumidas;
                    MG.set_posicion(pos);
                    this.unidadesCombustible = comb;
                    System.out.println("¡Felicidades! Has hecho un retroceso en el mapa.");
                    return true;
                } else{
                    System.out.println("El combustible disponible no es suficiente para el salto que se quiere dar");
                    return false;
                }
            } else {
                System.out.println("El retroceso que quieres hacer está por debajo del tamaño del mapa");
                return false;
            }
        }
    }

    public void recargarPropulsores(int hidrogeno){
        return;
    }
}
