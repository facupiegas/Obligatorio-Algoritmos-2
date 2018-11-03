package Operaciones_Red;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RegistrarTramo_3_3 {

    @Test
    public void testRegistrarTramoPesoNovalido() {
        ISistema S = new Sistema();
        S.inicializarSistema(10, 1.12, 22.44);

        assertEquals(Retorno.Resultado.ERROR_1, S.registrarTramo(22.3, 21.5, -52.2, -47.6, 0).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.registrarTramo(22.3, 21.5, -52.2, -47.6, -1).resultado);
    }

    @Test
    public void testRegistrarTramoNoExisteCoord() {
        ISistema S = new Sistema();
        S.inicializarSistema(10, 1.12, 22.44);

        assertEquals(Retorno.Resultado.ERROR_2, S.registrarTramo(22.3, 21.5, -52.2, -47.6, 44).resultado);
    }

    @Test
    public void testRegistrarTramoYaResgistRado() {
        ISistema S = new Sistema();
        S.inicializarSistema(22, 1.12, 22.44);
        S.registrarNodo("AIDI1", 20.5, 55.4);
        S.registrarNodo("AIDI2", 45.5, 33.4);
        S.registrarTramo(20.5, 55.4, 45.5, 33.4, 4);

        assertEquals(Retorno.Resultado.ERROR_3, S.registrarTramo(20.5, 55.4, 45.5, 33.4, 4).resultado);
    }

    @Test
    public void testTramoCanaleraAServidor() {
        ISistema sistema = new Sistema();
        sistema.inicializarSistema(10, 1.0, 1.0);
        // Afiliados
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Omar", "omar@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("9.999.999-9", "Jorge", "jorge@gmail.com").resultado);
        //Canaleras
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("123", "5.555.555-5", -32.3105104, -58.0759192).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("456", "5.555.555-5", -32.3105100, -58.0759192).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("222", "9.999.999-9", -32.3105100, -58.0759100).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("21", "9.999.999-9", -32.3102222, -58.0759192).resultado);

        // Tramos OK
        assertEquals(Retorno.Resultado.ERROR_4, sistema.registrarTramo(-32.3105104, -58.0759192, -32.3105100, -58.0759192, 80).resultado); // C123 --> C456
        assertEquals(Retorno.Resultado.ERROR_4, sistema.registrarTramo(-32.3105100, -58.0759100, -32.3102222, -58.0759192, 80).resultado); // C222 --> C21
        assertEquals(Retorno.Resultado.ERROR_4, sistema.registrarTramo(1.0, 1.0, -32.3102222, -58.0759192, 80).resultado); // ServidorCentral --> C21
        assertEquals(Retorno.Resultado.ERROR_4, sistema.registrarTramo(-32.3105100, -58.0759192, 1.0, 1.0, 80).resultado); // C456 --> ServidorCentral
    }

    @Test
    public void testTramosOK() {
        ISistema sistema = new Sistema();
        sistema.inicializarSistema(10, 1.0, 1.0);
        // Afiliados
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Omar", "omar@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("9.999.999-9", "Jorge", "jorge@gmail.com").resultado);
        //Canaleras
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("123", "5.555.555-5", -32.3105104, -58.0759192).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("456", "5.555.555-5", -32.3105100, -58.0759192).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("222", "9.999.999-9", -32.3105100, -58.0759100).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("21", "9.999.999-9", -32.3102222, -58.0759192).resultado);
        // Nodos
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("sureste 1", -32.3105200, -58.0759200).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("noreste 2", -32.3105150, -58.0759150).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("sureste 2", -32.3105000, -58.0759000).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("sureste 4", -32.3102250, -58.0759250).resultado);

        // Tramos OK
        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105104, -58.0759192, -32.3105200, -58.0759200, 80).resultado); //C123 ns1
        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105100, -58.0759100, -32.3102250, -58.0759250, 180).resultado); //c222 ns2
        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105000, -58.0759000, -32.3105150, -58.0759150, 280).resultado);//Nodo s2 - n2
        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3102222, -58.0759192, -32.3102250, -58.0759250, 380).resultado);//C21 NS4
    }
}
