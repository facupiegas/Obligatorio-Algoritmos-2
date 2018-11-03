package Modelo;

public class NodoArbolAfiliado {

    private String ci;
    private String nombre;
    private String email;

    private int dato;
    private NodoArbolAfiliado izq;
    private NodoArbolAfiliado der;

    public NodoArbolAfiliado(String ci, String nombre, String email, NodoArbolAfiliado izq, NodoArbolAfiliado der) {
        this.ci = ci;
        this.nombre = nombre;
        this.email = email;

        this.izq = izq;
        this.der = der;
    }

    public NodoArbolAfiliado(String ci, String nombre, String email) {
        this.ci = ci;
        this.nombre = nombre;
        this.email = email;
    }

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public NodoArbolAfiliado getIzq() {
        return izq;
    }

    public void setIzq(NodoArbolAfiliado izq) {
        this.izq = izq;
    }

    public NodoArbolAfiliado getDer() {
        return der;
    }

    public void setDer(NodoArbolAfiliado der) {
        this.der = der;
    }

    @Override
    public String toString() {
        return ci+';'+nombre+';'+email;
    }

}
