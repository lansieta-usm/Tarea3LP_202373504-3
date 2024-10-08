public class Helado extends Planeta {
    private int temperatura = generarTemperatura();

    public Helado(){ // Constructor
        super();
        this.temperatura = generarTemperatura();
        setearValores();
    }

    private int generarTemperatura(){ // Genera una temperatura al azar acorde a los valores entregados en el enunciado
        return (int)((-120) + Math.random() * (((-30) - (-120)) + 1));
    }
    private int generarRadio(){ // Genera un radio al azar acorde a los valores entregados en el enunciado
        int radioGenerado = (int)(1000 + Math.random() * ((1000000 - 1000) + 1));
        return radioGenerado;
    }
    private void setearValores(){ // Mediante Setters, actualiza los valores de la clase madre Planeta
        int radio = generarRadio();
        int cristales = (int)(0.65 * 4 * Math.PI * radio * radio);
        int flores = (int)(0.35 * 4 * Math.PI * radio * radio);
        int consumo = (int)(0.15 * Math.abs(this.temperatura));

        set_radio(radio);
        set_cristalesHidrogeno(cristales);
        set_floresSodio(flores);
        set_consumoEnergia(consumo);

        return;
    }
    
    public int get_temperatura(){ // Getter Temperatura
        return this.temperatura;
    }
}
