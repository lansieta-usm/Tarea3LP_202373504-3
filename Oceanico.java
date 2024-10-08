public class Oceanico extends Planeta {
    private int profundidad;

    public Oceanico(){
        super();
        this.profundidad = generarProfundidad();
        setearValores();
    }

    private int generarProfundidad(){ // Genera una profundidad al azar acorde a los valores entregados en el enunciado
        return (int)((30) + Math.random() * (((1000) - (30)) + 1));
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

        set_radio(radio);
        set_cristalesHidrogeno(cristales);
        set_floresSodio(flores);
        set_consumoEnergia(consumo);

        return;
    }

    public int get_profundidad(){ // Getter Profundidad
        return this.profundidad;
    }
}
