package Operaciones_Red;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RegistrarNodo_3_2 {
    
    @Test
    public void testRegistrarNodoSistemaLleno() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);

        assertEquals(Retorno.Resultado.ERROR_1, S.registrarNodo("AIDI2", 20.5, 55.4).resultado);
    }
    
    @Test
    public void testRegistrarNodoPuntoYaExiste() {
        ISistema S = new Sistema();
        S.inicializarSistema(5, 1.12, 22.44);
        S.registrarNodo("AIDI2", 20.5, 55.4);
        
        assertEquals(Retorno.Resultado.ERROR_2, S.registrarNodo("AIDI2", 20.5, 55.4).resultado);
    }
    
    @Test
    public void testRegistrarNodoPuntoOk() {
        ISistema S = new Sistema();
        S.inicializarSistema(5, 1.12, 22.44);
        
        assertEquals(Retorno.Resultado.OK, S.registrarNodo("AIDI2", 20.5, 55.4).resultado);
    }
}
