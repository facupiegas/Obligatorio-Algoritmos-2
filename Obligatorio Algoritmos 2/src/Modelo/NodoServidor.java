package Modelo;


public class NodoServidor {
    private String nodoId = "Servidor 001";
    private double coordX;
    private double coordY;

    public NodoServidor(double coordX, double coordY) {       
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public String getNodoId() {
        return nodoId;
    }

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }
}
