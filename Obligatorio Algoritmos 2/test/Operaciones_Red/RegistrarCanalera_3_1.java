package Operaciones_Red;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RegistrarCanalera_3_1 {

    @Test
    public void testRegistrarCanaleraSistemaLleno() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);
        S.registrarAfiliado("4.586.794-6", "Enzo", "enzo@gmail.com");
        S.registrarCanalera("001", "4.586.794-6", 20.5, 55.4);

        assertEquals(Retorno.Resultado.ERROR_1, S.registrarCanalera("001", "4.586.794-6", 20.5, 55.4).resultado);
    }

    @Test
    public void testRegistrarCanaleraPuntoYaExistente() {
        ISistema S = new Sistema();
        S.inicializarSistema(3, 1.12, 22.44);
        S.registrarAfiliado("4.586.794-6", "Enzo", "enzo@gmail.com");
        S.registrarCanalera("001", "4.586.794-6", 20.5, 55.4);

        assertEquals(Retorno.Resultado.ERROR_2, S.registrarCanalera("001", "4.586.794-6", 20.5, 55.4).resultado);
    }

    @Test
    public void testRegistrarCanaleraAfiliadoNoExiste() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);

        assertEquals(Retorno.Resultado.ERROR_3, S.registrarCanalera("001", "4.586.794-6", 20.5, 55.4).resultado);
    }

    @Test
    public void testRegistrarCanaleraOk() {
        ISistema S = new Sistema();
        // se setea tope = 2 porrque al crear red, se registra central
        S.inicializarSistema(2, 1.12, 22.44);
        S.registrarAfiliado("4.586.794-6", "Enzo", "enzo@gmail.com");

        assertEquals(Retorno.Resultado.OK, S.registrarCanalera("001", "4.586.794-6", 20.5, 55.4).resultado);
    }

}
