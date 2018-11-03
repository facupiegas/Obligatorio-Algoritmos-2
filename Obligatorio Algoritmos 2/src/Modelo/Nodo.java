package Modelo;

public class Nodo extends Punto {

    private String nodoId;

    public Nodo(String nodoId, double coordX, double coordY) {
        super(coordX, coordY);
        this.nodoId = nodoId;
    }

    public Nodo(double coordX, double coordY) {
        super(coordX, coordY);
    }

    public String getNodoId() {
        return nodoId;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getColor() {
        return "blue";
    };
    
    @Override
    public String queSoy() {
        return "N";
    };
}
