public class tieneAsentamientos {
    public tieneAsentamientos(){ //Constructor
    }

    public static int generarPrecioHelado(){
        int precio = (int)(2000 + Math.random() * ((20000 - 2000) + 1)); // Precios de 2500 a 40000
        return precio;
    }
    public static int generarPrecioOceanco(){
        int precio = (int)(5000 + Math.random() * ((15000 - 5000) + 1)); // Precios de 6000 a 20000
        return precio;
    }
    public static float generarMejora(){
        float mejora = (float)(Math.random()*0.1);
        return mejora;
    }

    public void visitarAsentamientos(Jugador jugador){
        // No utilicé esta función, pues todos los intercambios de recursos se hacen desde el main.
    }
}
