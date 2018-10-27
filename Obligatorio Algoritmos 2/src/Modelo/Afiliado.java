package Modelo;


public class Afiliado {
    private String ci;
    private String nombre;
    private String email;

    public Afiliado(String ci, String nombre, String email) {
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

}

