package Operaciones_Globales;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import static org.junit.Assert.*;
import org.junit.Test;

public class CrearSistemaMonitoreo_1_1 {

    @Test
    public void testCrearSistemaMonitoreoConValorCero() {
        ISistema S = new Sistema();
        assertEquals(Retorno.Resultado.ERROR_1, S.inicializarSistema(0, 20.0, 15.0).resultado);
    }

    @Test
    public void testCrearSistemaMonitoreoConValorNegativo() {
        ISistema S = new Sistema();
        assertEquals(Retorno.Resultado.ERROR_1, S.inicializarSistema(-1, 20.0, 15.0).resultado);
    }

    @Test
    public void testCrearSistemaMonitoreoConValorMayorACero() {
        ISistema S = new Sistema();
        assertEquals(Retorno.Resultado.OK, S.inicializarSistema(1, 20.0, 15.0).resultado);
    }
}
