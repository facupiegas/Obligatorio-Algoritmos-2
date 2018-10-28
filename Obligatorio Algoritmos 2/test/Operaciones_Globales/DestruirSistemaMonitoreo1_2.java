package Operaciones_Globales;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DestruirSistemaMonitoreo1_2 {

    @Test
    public void testDestruirSistemaMonitoreo() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);
        assertEquals(Retorno.Resultado.OK, S.destruirSistema().resultado);
    }
}
