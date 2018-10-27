package Interfaces;

import Modelo.Afiliado;

public interface IListaAfiliado {
    public boolean esVacia();
    public void agregar(Afiliado afiliado);
    public void borrar(Afiliado afiliado);  
    public void listar();
}
