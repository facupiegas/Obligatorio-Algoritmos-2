package Obligatorio;

import Interfaces.ISistema;
import Modelo.Grafo;
import Modelo.ListaAfiliado;
import Modelo.NodoServidor;
import Obligatorio.Retorno.Resultado;

public class Sistema implements ISistema {

    private ListaAfiliado afiliados;
    private Grafo red;

    //PRE: 
    //POS: 
    @Override
    public Retorno inicializarSistema(int maxPuntos, Double coordX, Double coordY) {
        if (maxPuntos <= 0) {
            return new Retorno(Resultado.ERROR_1);
        }

        red = new Grafo(maxPuntos);
        NodoServidor servidor = new NodoServidor(coordX, coordY);
        red.agregarVertice(servidor);
        afiliados = new ListaAfiliado();
        return new Retorno(Resultado.OK);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno destruirSistema() {
        afiliados = null;
        red = null;        
        return new Retorno(Resultado.OK);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno registrarAfiliado(String cedula, String nombre, String email) {
       
        
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno buscarAfiliado(String CI) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno listarAfiliados() {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno registrarCanalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno registrarNodo(String nodoid, Double coordX, Double coordY) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int perdidaCalidad) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno modificarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf,
            int nuevoValorPerdidaCalidad) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno calidadCanalera(Double coordX, Double coordY) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno nodosCriticos() {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno dibujarMapa() {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

}
