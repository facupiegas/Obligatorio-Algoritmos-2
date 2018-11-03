package Modelo;

public class NodoServidor extends Punto {

    private String nodoId = "Servidor 001";

    public NodoServidor(double coordX, double coordY) {
        super(coordX, coordY);
    }

    public String getNodoId() {
        return nodoId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    public String getColor(){
        return "green";
    };
    
    @Override
    public String queSoy() {
        return "S";
    };
}
