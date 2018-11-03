package Modelo;

public class Canalera extends Punto {

    private String chipId;
    private String ciAfiliado;

    public Canalera(String chipId, String ciAfiliado, double coordX, double coordY) {
        super(coordX, coordY);
        this.chipId = chipId;
        this.ciAfiliado = ciAfiliado;
    }

    public String getChipId() {
        return chipId;
    }

    public String getCiAfiliado() {
        return ciAfiliado;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
     
    public String getColor(){
        return "red";
    };
    
    @Override
    public String queSoy() {
        return "C";
    };
}
