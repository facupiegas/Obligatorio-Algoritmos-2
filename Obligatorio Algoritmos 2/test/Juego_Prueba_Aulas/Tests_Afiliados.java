package Juego_Prueba_Aulas;

import Interfaces.ISistema;
import Obligatorio.Retorno;
import Obligatorio.Sistema;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Tests_Afiliados {
    @Test
    public void testRegistroAfiliado() {
        ISistema sistema = new Sistema();
        sistema.inicializarSistema(10, 1.0, 1.0);
        //Datos de la prueba
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Omar", "omar@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("9.999.999-9", "Jorge", "jorge@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("1.111.111-1", "Maria", "maria@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("2.222.222-2", "Ximena", "ximena@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("4.444.444-4", "Analia", "analia@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("3.333.333-3", "Nicolas", "nicolas@gmail.com").resultado);
    }

    @Test
    public void testBuscarAfiliadoOK() {
        ISistema sistema = new Sistema();
        sistema.inicializarSistema(10, 1.0, 1.0);
        //Datos de la prueba
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Omar", "omar@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("9.999.999-9", "Jorge", "jorge@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("1.111.111-1", "Maria", "maria@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("2.222.222-2", "Ximena", "ximena@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("4.444.444-4", "Analia", "analia@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("3.333.333-3", "Nicolas", "nicolas@gmail.com").resultado);
        Retorno res = sistema.buscarAfiliado("3.333.333-3");
        assertEquals(Retorno.Resultado.OK, res.resultado);
        assertEquals("3.333.333-3;Nicolas;nicolas@gmail.com", res.valorString);
    }

    @Test
    public void testBuscarAfiliadoError2() {
        ISistema sistema = new Sistema();
        sistema.inicializarSistema(10, 1.0, 1.0);
        //Datos de la prueba
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Omar", "omar@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("9.999.999-9", "Jorge", "jorge@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("1.111.111-1", "Maria", "maria@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("2.222.222-2", "Ximena", "ximena@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("4.444.444-4", "Analia", "analia@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("3.333.333-3", "Nicolas", "nicolas@gmail.com").resultado);
        Retorno res = sistema.buscarAfiliado("5.333.333-9");
        assertEquals(Retorno.Resultado.ERROR_2, res.resultado);
    }

    @Test
    public void testRegistroAfiliadoError1() {
        ISistema s = new Sistema();
        s.inicializarSistema(10, 1.0, 1.0);
        //Formatos de Cedula incorrectos
        assertEquals(Retorno.Resultado.ERROR_1,
                s.registrarAfiliado("702.515-7", "", "o@g.com").resultado);
        assertEquals(Retorno.Resultado.ERROR_1,
                s.registrarAfiliado("1702515-7", "", "o@g.com").resultado);
        assertEquals(Retorno.Resultado.ERROR_1,
                s.registrarAfiliado("1.702.51-70", "", "o@g.com").resultado);
        assertEquals(Retorno.Resultado.ERROR_1,
                s.registrarAfiliado("1.702.51--0", "", "o@g.com").resultado);
        assertEquals(Retorno.Resultado.ERROR_1,
                s.registrarAfiliado("..702.510-0", "", "o@g.com").resultado);
        assertEquals(Retorno.Resultado.ERROR_1,
                s.registrarAfiliado("1.zzz.051-7", "", "o@g.com").resultado);
        assertEquals(Retorno.Resultado.ERROR_1,
                s.registrarAfiliado("           ", "", "o@g.com").resultado);

    }

    @Test
    public void testRegistroAfiliadoError2() {
        ISistema sistema = new Sistema();
        sistema.inicializarSistema(10, 1.0, 1.0);
        assertEquals(Retorno.Resultado.ERROR_2, sistema.registrarAfiliado("5.555.555-5", "Maria", "").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sistema.registrarAfiliado("5.555.555-5", "Maria", "maria").resultado);
    }

    @Test
    public void testRegistroAfiliadoError3() {
        ISistema sistema = new Sistema();
        sistema.inicializarSistema(10, 1.0, 1.0);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Maria", "maria@gmail.com").resultado);
        assertEquals(Retorno.Resultado.ERROR_3, sistema.registrarAfiliado("5.555.555-5", "Maria", "maria@gmail.com").resultado);
    }

    @Test
    public void testListadoAfiliado() {
        ISistema sistema = new Sistema();
        sistema.inicializarSistema(10, 1.0, 1.0);
        //Datos de la prueba
        String cedula = "3.702.156-2";
        String nombre = "Omar";
        String email = "omar@gmail.com";
        String celular = "098123456";

        Retorno ret = sistema.registrarAfiliado(cedula, nombre, email);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        ret = sistema.listarAfiliados();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        // El valor string deberia contener los datos del vendedor ingresado
        assertTrue(ret.valorString.contains(cedula) || ret.valorString.contains("37021569"));
        assertTrue(ret.valorString.contains(nombre));
    }

    @Test
    public void testListadoAfiliado2() {
        ISistema sistema = new Sistema();
        sistema.inicializarSistema(10, 1.0, 1.0);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("5.555.555-5", "Omar", "omar@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("9.999.999-9", "Jorge", "jorge@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("1.111.111-1", "Maria", "maria@gmail.com").resultado);
        assertEquals(Retorno.Resultado.OK, sistema.registrarAfiliado("2.222.222-2", "Ximena", "ximena@gmail.com").resultado);

        Retorno res = sistema.listarAfiliados();
        assertEquals(Retorno.Resultado.OK, res.resultado);
        //Validar que estan todos los vendedores
        assertTrue(res.valorString.contains("5.555.555-5") || res.valorString.contains("55555555"));
        assertTrue(res.valorString.contains("9.999.999-9") || res.valorString.contains("99999999"));
        assertTrue(res.valorString.contains("1.111.111-1") || res.valorString.contains("11111111"));
        assertTrue(res.valorString.contains("2.222.222-2") || res.valorString.contains("22222222"));
        //Validar que estan ordenados
        assertTrue(res.valorString.indexOf("5.555.555-5") > res.valorString.indexOf("1.111.111-1")
                || res.valorString.indexOf("55555555") > res.valorString.indexOf("11111111"));
        assertTrue(res.valorString.indexOf("9.999.999-9") > res.valorString.indexOf("2.222.222-2")
                || res.valorString.indexOf("99999999") > res.valorString.indexOf("22222222"));
    }
}
