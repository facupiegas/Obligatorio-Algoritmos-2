package Operaciones_Afiliados;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ListarAfiliados_2_3 {

    @Test
    public void testBuscarAfiliadoCiNoValida() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);
        Retorno ret = new Retorno();
        //Creo Afiliados 
        S.registrarAfiliado("4.586.794-6", "Facundo", "facundo@gmail.com");
        S.registrarAfiliado("4.486.794-5", "Lucia", "Lucia@gmail.com");
        S.registrarAfiliado("4.356.998-5", "Marcos", "Marcos@gmail.com");
        S.registrarAfiliado("4.112.951-4", "Enzo", "Enzo@gmail.com");
        S.registrarAfiliado("4.832.116-5", "Cavani", "Cavani@gmail.com");
        S.registrarAfiliado("4.967.732-5", "Messi", "Messi@gmail.com");
        ret = S.listarAfiliados();
        System.out.println(ret.valorString);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
}
