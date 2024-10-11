public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;

    public Jugador(){
        this.unidadesEnergiaProteccion = 100;
        this.eficienciaEnergiaProteccion = 0;
    }

    public void recargarEnergiaProteccion(int sodio){
        return;
    }

    public float get_unidadesEnergiaProteccion(){ // Getter Unidades Energía Protección
        return this.unidadesEnergiaProteccion;
    }
    public float get_eficienciaEnergiaProteccion(){ // Getter Eficiencia Enegería Protección
        return this.eficienciaEnergiaProteccion;
    }
    public void set_unidadesEnergiaProteccion(float uep){ // Setter Unidades Energía Protección
        this.unidadesEnergiaProteccion = uep;
        return;
    }
    public void set_eficienciaEnergiaProteccion(float eep){ // Setter Eficiencia Energía Protección
        this.eficienciaEnergiaProteccion = eep;
        return;
    }
}
