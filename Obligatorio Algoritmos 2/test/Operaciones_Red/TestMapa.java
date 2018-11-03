package Operaciones_Red;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMapa {

    @Test
    public void testMapa() {
        ISistema sistema = new Sistema();
        sistema.inicializarSistema(20, -34.894768, -56.152677);

        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Omar", "omar@gmail.com").resultado);

        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N1", -34.892626, -56.167281).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N2", -34.900072, -56.165983).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N3", -34.905966, -56.159975).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N4", -34.899465, -56.143986).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N4", -34.922282, -56.157470).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarNodo("N4", -34.911660, -56.164203).resultado);


        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C01", "5.555.555-5", -34.894897, -56.183422).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C02", "5.555.555-5", -34.909910, -56.194372).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C03", "5.555.555-5", -34.911204, -56.176238).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C04", "5.555.555-5", -34.906316, -56.144179).resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarCanalera("C05", "5.555.555-5", -34.934665, -56.160641).resultado);

        assertEquals(Retorno.Resultado.OK, sistema.dibujarMapa().resultado);
    }
}
