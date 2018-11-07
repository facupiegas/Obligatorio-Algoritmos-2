package Juego_Prueba_Aulas;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Tests_Mapa {
    @Test
    public void testRegistrarNodos() {
        ISistema sistema = new Sistema();
        sistema.inicializarSistema(6, 1.0, 1.0);
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("sureste 1", -32.3105104, -58.0759192).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("noreste 2", -32.3105100, -58.0759192).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("sureste 2", -32.3105100, -58.0759100).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("sureste 4", -32.3102222, -58.0759192).resultado);
        //Punto duplicado
        assertEquals(Retorno.Resultado.ERROR_2, sistema.registrarNodo("duplicado", -32.3102222, -58.0759192).resultado);

        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("Ultimo Nodo", -32.3105133, -58.0759222).resultado);
        //Cantidad maxima de puntos
        assertEquals(Retorno.Resultado.ERROR_1, sistema.registrarNodo("Es imposhible", -32.3105144, -58.0759555).resultado);
    }

    @Test
    public void testRegistrarCanaleras() {
        ISistema sistema = new Sistema();
        sistema.inicializarSistema(6, 1.0, 1.0);
        // Afiliados
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Omar", "omar@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("9.999.999-9", "Jorge", "jorge@gmail.com").resultado);
        //Canaleras
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("123", "5.555.555-5", -32.3105104, -58.0759192).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("456", "5.555.555-5", -32.3105100, -58.0759192).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("222", "9.999.999-9", -32.3105100, -58.0759100).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("21", "9.999.999-9", -32.3102222, -58.0759192).resultado);
        //Punto duplicado
        assertEquals(Retorno.Resultado.ERROR_2, sistema.registrarCanalera("coord duplicado", "9.999.999-9", -32.3102222, -58.0759192).resultado);
        //Afiliado no existe
        assertEquals(Retorno.Resultado.ERROR_3, sistema.registrarCanalera("afiliado no existe", "1.111.222-8", -32.3102500, -58.0759192).resultado);

        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("Ultima canalera", "9.999.999-9", -32.3105133, -58.0759222).resultado);
        //Cantidad maxima de puntos
        assertEquals(Retorno.Resultado.ERROR_1, sistema.registrarCanalera("Es imposhible", "9.999.999-9", -32.3105144, -58.0759555).resultado);
    }

//    @Test
//    public void testTramosOK() {
//        ISistema sistema = new Sistema();
//        sistema.inicializarSistema(10, 1.0, 1.0);
//        // Afiliados
//        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Omar", "omar@gmail.com").resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("9.999.999-9", "Jorge", "jorge@gmail.com").resultado);
//        //Canaleras
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("123", "5.555.555-5", -32.3105104, -58.0759192).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("456", "5.555.555-5", -32.3105100, -58.0759192).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("222", "9.999.999-9", -32.3105100, -58.0759100).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("21", "9.999.999-9", -32.3102222, -58.0759192).resultado);
//        // Nodos
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("sureste 1", -32.3105200, -58.0759200).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("noreste 2", -32.3105150, -58.0759150).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("sureste 2", -32.3105000, -58.0759000).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("sureste 4", -32.3102250, -58.0759250).resultado);
//
//        // Tramos OK
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105104, -58.0759192, -32.3105100, -58.0759192, 80).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105100, -58.0759100, -32.3102222, -58.0759192, 180).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105000, -58.0759000, -32.3105150, -58.0759150, 280).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3102222, -58.0759192, -32.3102250, -58.0759250, 380).resultado);
//
//    }
//
    @Test
    public void testTramosError1() {
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

        //Peso invalido
        assertEquals(Retorno.Resultado.ERROR_1, sistema.registrarTramo(-32.3105104, -58.0759192, -32.3105100, -58.0759192, -3).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sistema.registrarTramo(-32.3105104, -58.0759192, -32.3105100, -58.0759192, 0).resultado);

    }

    @Test
    public void testTramosError2() {
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

        //No existe el punto de destino
        assertEquals(Retorno.Resultado.ERROR_2, sistema.registrarTramo(-32.3105104, -58.0759192, -32.3105200, -58.0759998, 80).resultado);
        //No existe el punto de origen
        assertEquals(Retorno.Resultado.ERROR_2, sistema.registrarTramo(-32.3105998, -58.0759200, -32.3105104, -58.0759192, 80).resultado);

    }

//    @Test
//    public void testTramosError3() {
//        ISistema sistema = new Sistema();
//        sistema.inicializarSistema(10, 1.0, 1.0);
//        // Afiliados
//        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Omar", "omar@gmail.com").resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("9.999.999-9", "Jorge", "jorge@gmail.com").resultado);
//        //Canaleras
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("123", "5.555.555-5", -32.3105104, -58.0759192).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("456", "5.555.555-5", -32.3105100, -58.0759192).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("222", "9.999.999-9", -32.3105100, -58.0759100).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("21", "9.999.999-9", -32.3102222, -58.0759192).resultado);
//        // Nodos
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("sureste 1", -32.3105200, -58.0759200).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("noreste 2", -32.3105150, -58.0759150).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("sureste 2", -32.3105000, -58.0759000).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("sureste 4", -32.3102250, -58.0759250).resultado);
//
//        // Tramo OK
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-32.3105104, -58.0759192, -32.3105100, -58.0759192, 80).resultado);
//        //Tramo duplicado
//        assertEquals(Retorno.Resultado.ERROR_3, sistema.registrarTramo(-32.3105104, -58.0759192, -32.3105100, -58.0759192, 100).resultado);
//
//    }
//
//    @Test
//    public void testCalidadCanaleraCercana1() {
//        ISistema sistema = new Sistema();
//        sistema.inicializarSistema(20, 0.0, 0.0);
//        armarMapa(sistema);
//        // Canalera 11
//        Retorno r = sistema.calidadCanalera(-11.0, -11.0);
//        assertEquals(Retorno.Resultado.OK, r.resultado);
//        assertEquals(4, r.valorEntero);
//    }
//
//    @Test
//    public void testCalidadCanaleraMedia() {
//        ISistema sistema = new Sistema();
//        sistema.inicializarSistema(20, 0.0, 0.0);
//        armarMapa(sistema);
//        // Canalera 51
//        Retorno r = sistema.calidadCanalera(-51.0, -51.0);
//        assertEquals(Retorno.Resultado.OK, r.resultado);
//        assertEquals(14, r.valorEntero);
//    }
//
//    @Test
//    public void testCalidadCanaleraLejos() {
//        ISistema sistema = new Sistema();
//        sistema.inicializarSistema(20, 0.0, 0.0);
//        armarMapa(sistema);
//        // Canalera 42
//        Retorno r = sistema.calidadCanalera(-42.0, -42.0);
//        assertEquals(Retorno.Resultado.OK, r.resultado);
//        assertEquals(16, r.valorEntero);
//    }
//
//    @Test
//    public void testCalidadCanaleraError1() {
//        ISistema sistema = new Sistema();
//        sistema.inicializarSistema(20, 0.0, 0.0);
//        // Canalera no existe
//        Retorno r = sistema.calidadCanalera(-42.0, -42.0);
//        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
//    }
//
//    @Test
//    public void testCalidadCanaleraModificarTramo() {
//        ISistema sistema = new Sistema();
//        sistema.inicializarSistema(20, 0.0, 0.0);
//        armarMapa(sistema);
//        // Canalera 42
//        Retorno r = sistema.calidadCanalera(-42.0, -42.0);
//        assertEquals(Retorno.Resultado.OK, r.resultado);
//        assertEquals(16, r.valorEntero);
//        // Modofico los tramos N3-N1 y N2-N3
//        assertEquals(Retorno.Resultado.OK, sistema.modificarTramo(-3.0, -3.0, -1.0, -1.0, 1).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.modificarTramo(-2.0, -2.0, -3.0, -3.0, 1).resultado);
//        // Canalera 42
//        r = sistema.calidadCanalera(-42.0, -42.0);
//        assertEquals(Retorno.Resultado.OK, r.resultado);
//        assertEquals(8, r.valorEntero);
//        //Canalera 51
//        r = sistema.calidadCanalera(-51.0, -51.0);
//        assertEquals(Retorno.Resultado.OK, r.resultado);
//        assertEquals(12, r.valorEntero);
//    }
//
//    @Test
//    public void testNodosCriticos() {
//        ISistema sistema = new Sistema();
//        sistema.inicializarSistema(20, 0.0, 0.0);
//        armarMapa(sistema);
//        // Nodos criticos - N2 y N3
//        Retorno r = sistema.nodosCriticos();
//        assertEquals(Retorno.Resultado.OK, r.resultado);
//        assertTrue("-3.0;-3.0|-2.0;-2.0".equals(r.valorString) || "-2.0;-2.0|-3.0;-3.0".equals(r.valorString));
//    }
//
//    private void armarMapa(ISistema sistema) {
//        // Afiliados
//        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Omar", "omar@gmail.com").resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("9.999.999-9", "Jorge", "jorge@gmail.com").resultado);
//        // Nodos
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N1", -1.0, -1.0).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N2", -2.0, -2.0).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N2", -3.0, -3.0).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N4", -4.0, -4.0).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N5", -5.0, -5.0).resultado);
//        //Canaleras
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C11", "5.555.555-5", -11.0, -11.0).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C12", "5.555.555-5", -12.0, -12.0).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C13", "5.555.555-5", -13.0, -13.0).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C41", "5.555.555-5", -41.0, -41.0).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C42", "5.555.555-5", -42.0, -42.0).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C51", "5.555.555-5", -51.0, -51.0).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C21", "5.555.555-5", -21.0, -21.0).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C22", "5.555.555-5", -22.0, -22.0).resultado);
//        //Tramos entre nodos
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(0.0, 0.0, -1.0, -1.0, 3).resultado);//SC-N1
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(0.0, 0.0, -2.0, -2.0, 7).resultado);//SC-N2
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-1.0, -1.0, -3.0, -3.0, 12).resultado);//N1-N3
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-2.0, -2.0, -3.0, -3.0, 5).resultado);//N2-N3
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-3.0, -3.0, -4.0, -4.0, 2).resultado);//N3-N4
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-2.0, -2.0, -5.0, -5.0, 6).resultado);//N2-N5
//        //Tramos entre nodos y canaleras
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-1.0, -1.0, -11.0, -11.0, 1).resultado);//N1-C11
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-1.0, -1.0, -12.0, -12.0, 2).resultado);//N1-C12
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-1.0, -1.0, -13.0, -13.0, 3).resultado);//N1-C13
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-2.0, -2.0, -21.0, -21.0, 1).resultado);//N2-C21
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-2.0, -2.0, -22.0, -22.0, 2).resultado);//N2-C22
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-4.0, -4.0, -41.0, -41.0, 1).resultado);//N4-C41
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-4.0, -4.0, -42.0, -42.0, 2).resultado);//N4-C42
//        assertEquals(Retorno.Resultado.OK, sistema.registrarTramo(-5.0, -5.0, -51.0, -51.0, 1).resultado);//N5-C51
//
//    }
//
//    @Test
//    public void testMapa() {
//        ISistema sistema = new Sistema();
//        sistema.inicializarSistema(20, -34.910913, -56.195370);
//
//        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Omar", "omar@gmail.com").resultado);
//
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N1", -34.909039, -56.195530).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N2", -34.908951, -56.194500).resultado);
//
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C11", "5.555.555-5", -34.908880, -56.193299).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C12", "5.555.555-5", -34.909910, -56.194372).resultado);
//        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("N21", "5.555.555-5", -34.909813, -56.193202).resultado);
//
//        assertEquals(Retorno.Resultado.OK, sistema.dibujarMapa().resultado);
//    }
}
