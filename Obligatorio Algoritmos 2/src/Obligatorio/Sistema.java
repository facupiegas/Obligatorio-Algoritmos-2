package Obligatorio;

import Interfaces.ISistema;
import Modelo.ABBAfiliado;
import Modelo.Canalera;
import Modelo.Grafo;
import Modelo.Nodo;
import Modelo.NodoArbolAfiliado;
import Modelo.NodoServidor;
import Obligatorio.Retorno.Resultado;
import Utils.Validators;

public class Sistema implements ISistema {

    private ABBAfiliado afiliados;
    private Grafo red;
    private Validators val;

    //PRE: N/A
    //POS: El sistema es inicializado
    @Override
    public Retorno inicializarSistema(int maxPuntos, Double coordX, Double coordY) {
        if (maxPuntos <= 0) {
            return new Retorno(Resultado.ERROR_1);
        }

        red = new Grafo(maxPuntos);
        NodoServidor servidor = new NodoServidor(coordX, coordY);
        red.agregarVertice(servidor);
        afiliados = new ABBAfiliado();
        val = new Validators();
        return new Retorno(Resultado.OK);
    }

    //PRE: Debe existir un sistema creado
    //POS: El sistema es destruido
    @Override
    public Retorno destruirSistema() {
        afiliados.destruir();
        afiliados = null;
        red.destruir();
        red = null;
        return new Retorno(Resultado.OK);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno registrarAfiliado(String cedula, String nombre, String email) {
        Retorno ret = new Retorno();
        if (!val.validateCi(cedula)) {
            return new Retorno(Resultado.ERROR_1);
        }

        if (!val.validateEmail(email)) {
            return new Retorno(Resultado.ERROR_2);
        }

        if (afiliados.pertenece(cedula, ret) != null) {
            return new Retorno(Resultado.ERROR_3);
        }

        //Si paso todas las validaciones, lo agrego porque tengo la certeza de que esta todo OK
        afiliados.insertar(cedula, nombre, email);

        return new Retorno(Resultado.OK);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno buscarAfiliado(String ci) {
        Retorno ret = new Retorno();
        if (!val.validateCi(ci)) {
            ret.resultado = Resultado.ERROR_1;
            return ret;
        }

        NodoArbolAfiliado afiliado = afiliados.pertenece(ci, ret);

        if (afiliado == null) {
            ret.resultado = Resultado.ERROR_2;
            return ret;
        } else {
            ret.valorString = afiliado.toString();
            ret.resultado = Resultado.OK;
            return ret;
        }

    }

    @Override
    public Retorno listarAfiliados() {
        Retorno ret = new Retorno();
        afiliados.listarAscendente(ret);
        ret.resultado = Resultado.OK;
        return ret;
    }

    //PRE: 
    //POS:
    @Override
    public Retorno registrarCanalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
        Retorno ret = new Retorno();
        if (afiliados.pertenece(CIafiliado, ret) == null) {
            ret.resultado = Resultado.ERROR_3;
            return ret;
        }
        if (red.esLleno()) {
            ret.resultado = Resultado.ERROR_1;
            return ret;
        }
        Canalera can = new Canalera(chipid, CIafiliado, coordX, coordY);
        if (red.existeVertice(can)) {
            ret.resultado = Resultado.ERROR_2;
            return ret;
        }
        // si llego aca no hay error, pudo agregar sin miedo
        red.agregarVertice(can);
        ret.resultado = Resultado.OK;
        return ret;

    }

    //PRE: 
    //POS:
    @Override
    public Retorno registrarNodo(String nodoid, Double coordX, Double coordY) {
        Retorno ret = new Retorno();
        if (red.esLleno()) {
            ret.resultado = Resultado.ERROR_1;
            return ret;
        }
        Nodo nod = new Nodo(nodoid, coordX, coordY);
        if (red.existeVertice(nod)) {
            ret.resultado = Resultado.ERROR_2;
            return ret;
        }
        // si llego aca no hay error, pudo agregar sin miedo
        red.agregarVertice(nod);
        ret.resultado = Resultado.OK;
        return ret;
    }

    //PRE: 
    //POS:
    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi,
             Double coordXf, Double coordYf,
             int perdidaCalidad
    ) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno modificarTramo(Double coordXi, Double coordYi,
             Double coordXf, Double coordYf,
             int nuevoValorPerdidaCalidad
    ) {
        return new Retorno(Resultado.NO_IMPLEMENTADA);
    }

    //PRE: 
    //POS:
    @Override
    public Retorno calidadCanalera(Double coordX, Double coordY
    ) {
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
