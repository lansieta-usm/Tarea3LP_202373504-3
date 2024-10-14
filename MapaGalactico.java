import java.util.List;
import java.util.ArrayList;

public class MapaGalactico {
    private List<Planeta> planetas;
    private int posicion;
    private boolean hayCG = false; // Aún no hay Centro Galáctico

    public MapaGalactico(){ // Constructor
        this.planetas = new ArrayList<>();
        this.posicion = 0;
    }

    public List<Planeta> get_planetas(){ // Getter Lista Planetas
        return this.planetas;
    }
    public int get_posicion(){ // Getter Posición
        return this.posicion;
    }
    public void set_posicion(int position){ // Setter Posición
        if (position >= 0 && position < planetas.size()){
            this.posicion = position;
        } else{
            System.out.println("La posición está fuera de los límites.");
        }
    }

    public Planeta generadorPlaneta(){ // Genera un planeta (y su tipo) al azar acorde a las probabilidades entregadas en el enunciado y lo guarda en la lista de planetas
        Planeta planeta;
        int probabilidad = (int)(0 + Math.random() * ((100 - 0) + 1));
        //System.out.println("Probabilidad: "+probabilidad);
        if (this.hayCG == false){
            if(probabilidad <=30){
                planeta = new Helado();
            } else if(probabilidad <=60){
                planeta = new Oceanico();
            } else if(probabilidad <=80){
                planeta = new Radiactivo();
            } else if(probabilidad <=99){
                planeta = new Volcanico();
            } else{
                planeta = new CentroGalactico();
                this.hayCG = true; // Ahora hay Centro Galáctico
            }
        } else{ //Se redistribuyen las probabilidades para que no se pueda generar ningún otro Centro Galáctico
            if(probabilidad <=30){
                planeta = new Helado();
            } else if(probabilidad <=60){
                planeta = new Oceanico();
            } else if(probabilidad <=80){
                planeta = new Radiactivo();
            } else{
                planeta = new Volcanico();
            }
        }

        planetas.add(planeta);

        return planeta;
    }

    public void generadorPrimerosPlanetas(){ // Genera los 10 primeros planetas
        for(int i = 0; i<10; i++){
            generadorPlaneta();
        }
        return;
    }

    public Planeta planetaActual(){ // Getter planeta actual
        return planetas.get(posicion);
    }
}
