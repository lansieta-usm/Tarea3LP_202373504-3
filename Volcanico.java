public class Volcanico extends Planeta {
    private int temperatura;
    private int platino;

    public Volcanico(){
        super();
        this.temperatura = generarTemperatura();
        setearValores();
    }

    private int generarTemperatura(){ // Genera una temperatura al azar acorde a los valores entregados en el enunciado
        return (int)((120) + Math.random() * (((256) - (120)) + 1));
    }
    private int generarRadio(){ // Genera un radio al azar acorde a los valores entregados en el enunciado
        int radioGenerado = (int)(1000 + Math.random() * ((100000 - 1000) + 1));
        return radioGenerado;
    }
    private void setearValores(){ // Mediante Setters, actualiza los valores de la clase madre Planeta
        int radio = generarRadio();
        int cristales = (int)(0.3 * 4 * Math.PI * radio * radio);
        int flores = 0;
        int consumo = (int)(0.08 * this.temperatura);

        set_radio(radio);
        set_cristalesHidrogeno(cristales);
        set_floresSodio(flores);
        set_consumoEnergia(consumo);
        this.platino = (int)((0.25 * 4 * Math.PI * radio * radio) - (20.5 * this.temperatura));

        return;
    }

    public int get_temperatura(){ // Getter Temperatura
        return this.temperatura;
    }
    public int get_platino(){ // Getter Platino
        return this.platino;
    }
}
