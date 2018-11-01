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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.coordX) ^ (Double.doubleToLongBits(this.coordX) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.coordY) ^ (Double.doubleToLongBits(this.coordY) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodoServidor other = (NodoServidor) obj;
        if (Double.doubleToLongBits(this.coordX) != Double.doubleToLongBits(other.coordX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.coordY) != Double.doubleToLongBits(other.coordY)) {
            return false;
        }
        return true;
    }
    
    
}
