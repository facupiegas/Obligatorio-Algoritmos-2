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
    
    
    

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Nodo other = (Nodo) obj;
//        if (Double.doubleToLongBits(this.coordX) != Double.doubleToLongBits(other.coordX)) {
//            return false;
//        }
//        if (Double.doubleToLongBits(this.coordY) != Double.doubleToLongBits(other.coordY)) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 17 * hash + (int) (Double.doubleToLongBits(this.coordX) ^ (Double.doubleToLongBits(this.coordX) >>> 32));
//        hash = 17 * hash + (int) (Double.doubleToLongBits(this.coordY) ^ (Double.doubleToLongBits(this.coordY) >>> 32));
//        return hash;
//    }

    @Override
    public String toString() {
        return super.toString();
    }
}
