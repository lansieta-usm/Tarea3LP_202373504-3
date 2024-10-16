public class Radiactivo extends Planeta {
    private int radiacion;
    private int uranio;

    public Radiactivo(){
        super();
        this.radiacion = generarRadiacion();
        setearValores();
    }

    public int get_radiacion(){ // Getter Radiación
        return this.radiacion;
    }
    public int get_uranio(){ // Getter Uranio
        return this.uranio;
    }
    public void set_uranio(int uranum){
        this.uranio = uranum;
        return;
    }

    private int generarRadiacion(){ // Genera una radiación al azar acorde a los valores entregados en el enunciado
        return (int)((10) + Math.random() * (((50) - (10)) + 1));
    }
    private int generarRadio(){ // Genera un radio al azar acorde a los valores entregados en el enunciado
        int radioGenerado = (int)(10000 + Math.random() * ((100000 - 10000) + 1));
        return radioGenerado;
    }
    private void setearValores(){ // Mediante Setters, actualiza los valores de la clase madre Planeta
        int radio = generarRadio();
        int cristales = (int)(0.2 * 4 * Math.PI * radio * radio);
        int flores = (int)(0.2 * 4 * Math.PI * radio * radio);
        int consumo = (int)(0.3 * this.radiacion);
        String id = "Radiactivo";

        set_radio(radio);
        set_cristalesHidrogeno(cristales);
        set_floresSodio(flores);
        set_consumoEnergia(consumo);
        set_identificador(id);
        this.uranio = (int)(0.25 * 4 * Math.PI * radio * radio);

        return;
    }
}
