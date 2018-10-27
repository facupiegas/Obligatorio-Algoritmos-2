package Modelo;

public class Arista {

    private boolean existe;
    private int valor;

    public Arista(int valor) {
        this.existe = true;
        this.valor = valor;
    }

    public Arista() {

    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor + "";
    }

}
