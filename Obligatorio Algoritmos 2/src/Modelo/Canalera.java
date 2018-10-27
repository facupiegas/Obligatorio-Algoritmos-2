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
    
    
    
}
