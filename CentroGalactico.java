public class CentroGalactico extends Planeta {
    public CentroGalactico(){ // Constructor
        super();
        setearID();
    }

    private void setearID(){ // Mediante Setters, actualiza los valores de la clase madre Planeta
        String id = "Centro Galactico";

        set_identificador(id);

        return;
    }
}
