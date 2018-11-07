package Obligatorio;

import Interfaces.ISistema;
import Modelo.ABBAfiliado;
import Modelo.Canalera;
import Modelo.Grafo;
import Modelo.Nodo;
import Modelo.NodoArbolAfiliado;
import Modelo.NodoServidor;
import Modelo.Punto;
import Obligatorio.Retorno.Resultado;
import Utils.Validators;
import java.awt.Desktop;
import java.net.URL;

public class Sistema implements ISistema {

    private ABBAfiliado afiliados;
    private Grafo red;
    private Validators val;

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

    @Override
    public Retorno destruirSistema() {
        afiliados.destruir();
        afiliados = null;
        red.destruir();
        red = null;
        return new Retorno(Resultado.OK);
    }

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

    @Override
    public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int perdidaCalidad) {
        Retorno ret = new Retorno();

        if (perdidaCalidad <= 0) {
            ret.resultado = Resultado.ERROR_1;
            return ret;
        }

        Nodo origen = new Nodo(coordXi, coordYi);
        Nodo destino = new Nodo(coordXf, coordYf);

        if (!red.existeVertice(origen) || !red.existeVertice(destino)) {
            ret.resultado = Resultado.ERROR_2;
            return ret;
        }
        if (red.existeArista(origen, destino)) {
            ret.resultado = Resultado.ERROR_3;
            return ret;
        }

        // quiero conectar canalera con servidro central
        if (red.esCanaleraAServidor(coordXi, coordYi, coordXf, coordYf)) {
            ret.resultado = Resultado.ERROR_4;
            return ret;
        }

        red.agregarArista(origen, destino, perdidaCalidad);
        ret.resultado = Resultado.OK;
        return ret;
    }

    @Override
    public Retorno modificarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int nuevoValorPerdidaCalidad) {
        Retorno ret = new Retorno();

        if (nuevoValorPerdidaCalidad <= 0) {
            ret.resultado = Resultado.ERROR_1;
            return ret;
        }

        Nodo origen = new Nodo(coordXi, coordYi);
        Nodo destino = new Nodo(coordXf, coordYf);

        if (!red.existeArista(origen, destino)) {
            ret.resultado = Resultado.ERROR_3;
            return ret;
        }

        red.modificarPesoArista(origen, destino, nuevoValorPerdidaCalidad);
        ret.resultado = Resultado.OK;
        return ret;
    }

    @Override
    public Retorno calidadCanalera(Double coordX, Double coordY) {
        Retorno ret = new Retorno();
        Nodo p = new Nodo(coordX, coordY);

        if (!red.existeVertice(p)) {
            ret.resultado = Resultado.ERROR_1;
            return ret;
        }

        Punto servidor = red.retornarServidorCentral();
        Nodo destino = new Nodo(coordX, coordY);
        int distancia = red.dijkstra(servidor, destino);

        if (distancia == 0) {
            ret.resultado = Resultado.ERROR_2;
            return ret;
        }

        ret.resultado = Resultado.OK;
        ret.valorEntero = distancia;
        return ret;
    }

    @Override
    public Retorno nodosCriticos() {
        Retorno ret = new Retorno();
        ret.valorString = red.DFS();
        ret.resultado = Resultado.OK;
        return ret;
    }

    @Override
    public Retorno dibujarMapa() {
       
        String url = red.devolverUrl();
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Retorno ret = new Retorno();
        ret.resultado = Resultado.OK;
        
        return ret;
    }
}
