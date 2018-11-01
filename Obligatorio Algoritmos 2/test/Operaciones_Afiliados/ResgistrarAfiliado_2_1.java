package Operaciones_Afiliados;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ResgistrarAfiliado_2_1 {

    @Test
    public void testRegistrarAfiliadoCiNoValida() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);
        assertEquals(Retorno.Resultado.ERROR_1, S.registrarAfiliado("4.586.7946", "Facundo", "facundo@gmail.com").resultado);
    }

    @Test
    public void testRegistrarAfiliadoMailNoValido() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);
        assertEquals(Retorno.Resultado.ERROR_2, S.registrarAfiliado("4.586.794-6", "Facundo", "facundo@gmailcom").resultado);
    }

    @Test
    public void testRegistrarAfiliadoCiExistente() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);
        //Registro al Afiliado por primera vez (CI unica)
        S.registrarAfiliado("4.586.794-6", "Facundo", "facundo@gmail.com");

       // Intento registrar otro Afiliado con una CI existente (Boom)
        assertEquals(Retorno.Resultado.ERROR_3, S.registrarAfiliado("4.586.794-6", "Enzo", "enzo@gmail.com").resultado);
    }

    @Test
    public void testRegistrarAfiliadoOk() {
        ISistema S = new Sistema();
        S.inicializarSistema(1, 1.12, 22.44);
        assertEquals(Retorno.Resultado.OK, S.registrarAfiliado("4.586.794-6", "Enzo", "enzo@gmail.com").resultado);
    }

}
