package Modelo;

public class Canalera {

    private String chipId;
    private String ciAfiliado;
    private double coordX;
    private double coordY;

    public Canalera(String chipId, String ciAfiliado, double coordX, double coordY) {
        this.chipId = chipId;
        this.ciAfiliado = ciAfiliado;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public String getChipId() {
        return chipId;
    }

    public String getCiAfiliado() {
        return ciAfiliado;
    }

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
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
        final Canalera other = (Canalera) obj;
        if (Double.doubleToLongBits(this.coordX) != Double.doubleToLongBits(other.coordX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.coordY) != Double.doubleToLongBits(other.coordY)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.coordX) ^ (Double.doubleToLongBits(this.coordX) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.coordY) ^ (Double.doubleToLongBits(this.coordY) >>> 32));
        return hash;
    }

}
