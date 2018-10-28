package Operaciones_Afiliados;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BuscarAfiliado2_2 {

    @Test
    public void testBuscarAfiliadoCiNoValida() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);
        assertEquals(Retorno.Resultado.ERROR_1, S.buscarAfiliado("4.586.7946").resultado);
    }

    @Test
    public void testBuscarAfiliadoNoRegistrado() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);
        assertEquals(Retorno.Resultado.ERROR_2, S.buscarAfiliado("4.586.794-6").resultado);
    }

    @Test
    public void testBuscarAfiliadoSiRegistrado() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);
        S.registrarAfiliado("4.586.794-6", "Facundo", "facundo@gmail.com");
        S.registrarAfiliado("4.486.794-5", "Facundo", "facundo@gmail.com");
        S.registrarAfiliado("4.356.998-5", "Facundo", "facundo@gmail.com");
        S.registrarAfiliado("4.112.951-4", "Facundo", "facundo@gmail.com");
        S.registrarAfiliado("4.332.116-5", "Facundo", "facundo@gmail.com");
        S.registrarAfiliado("4.667.732-5", "Facundo", "facundo@gmail.com");
        Retorno ret = S.buscarAfiliado("4.112.951-4");
        
        System.out.println("Datos Afiliado \n" + ret.valorString);
        System.out.println("Cantidad de movimientos realizados para encontrarlo \n" + ret.valorEntero);
        System.out.println();

        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
}
