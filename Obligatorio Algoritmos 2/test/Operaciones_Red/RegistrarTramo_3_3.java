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
        S.inicializarSistema(1, 1.12, 22.44);

        assertEquals(Retorno.Resultado.ERROR_1, S.registrarTramo(22.3, 21.5, -52.2, -47.6, 0).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, S.registrarTramo(22.3, 21.5, -52.2, -47.6, -1).resultado);
    }
    
    @Test
    public void testRegistrarTramoNoExisteCoord() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);

        assertEquals(Retorno.Resultado.ERROR_2, S.registrarTramo(22.3, 21.5, -52.2, -47.6, 44).resultado);
    }
    
    @Test
    public void testRegistrarTramoYaResgistRado() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);
        S.registrarNodo("AIDI1", 20.5, 55.4);
        S.registrarNodo("AIDI2", 45.5, 33.4);
        S.registrarTramo(20.5, 55.4, 45.5, 33.4, 4);
        
        assertEquals(Retorno.Resultado.ERROR_2, S.registrarTramo(20.5, 55.4, 45.5, 33.4, 4).resultado);
    }
}
