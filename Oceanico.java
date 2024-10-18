public class Oceanico extends Planeta {
    private int profundidad;

    public Oceanico(){ // Constructor
        super();
        this.profundidad = generarProfundidad();
        setearValores();
    }

    public int get_profundidad(){ // Getter Profundidad
        return this.profundidad;
    }
    public void set_profundidad(int deep){ // Setter Profundidad (no se usó en el código final)
        this.profundidad = deep;
    }

    private int generarProfundidad(){ // Genera una profundidad al azar acorde a los valores entregados en el enunciado
        return (int)((30) + Math.random() * (((100) - (30)) + 1));
    }
    private int generarRadio(){ // Genera un radio al azar acorde a los valores entregados en el enunciado
        int radioGenerado = (int)(10000 + Math.random() * ((1000000 - 10000) + 1));
        return radioGenerado;
    }
    private void setearValores(){ // Mediante Setters, actualiza los valores de la clase madre Planeta
        int radio = generarRadio();
        int cristales = (int)(0.2 * 4 * Math.PI * radio * radio);
        int flores = (int)(0.65 * 4 * Math.PI * radio * radio);
        int consumo = (int)(0.002 * this.profundidad * this.profundidad);
        String id = "Oceanico";

        set_radio(radio);
        set_cristalesHidrogeno(cristales);
        set_floresSodio(flores);
        set_consumoEnergia(consumo);
        set_identificador(id);

        return;
    }

    @Override
    public int caracteristicaPlaneta() {
        return this.profundidad;
    }
}
