package Modelo;


public class Nodo {
    private String nodoId;
    private double coordX;
    private double coordY;

    public Nodo(String nodoId, double coordX, double coordY) {
        this.nodoId = nodoId;
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
