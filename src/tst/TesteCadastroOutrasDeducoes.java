package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import java.util.Collection;

@RunWith(Parameterized.class)
public class TesteCadastroOutrasDeducoes {

    private IRPF irpf;
    private String[] deducoes;
    private float[] valores;
    private float totalEsperado;
    private String consultaDeducao;
    private Float valorEsperadoConsulta;
    
    public TesteCadastroOutrasDeducoes(String[] deducoes, float[] valores, float totalEsperado, String consultaDeducao, Float valorEsperadoConsulta) {
        this.deducoes = deducoes;
        this.valores = valores;
        this.totalEsperado = totalEsperado;
        this.consultaDeducao = consultaDeducao;
        this.valorEsperadoConsulta = valorEsperadoConsulta;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"Funpresp"}, new float[]{1000f}, 1000f, "Funpresp", 1000f},
                {new String[]{"Funpresp", "Carne-leao"}, new float[]{1000f, 500f}, 1500f, "Carne-leao", 500f},
                {new String[]{"Funpresp", "Carne-leao", "PGBL"}, new float[]{1000f, 500f, 500f}, 2000f, "PGBL", 500f},
                {new String[]{"Funpresp"}, new float[]{1000f}, 1000f, "Carne-leao", null} 
        });
    }
    
    
    @Before
    public void setup() {
        irpf = new IRPF();
    }


    @Test
    public void testCadastroOutrasDeducoes() {
        for (int i = 0; i < deducoes.length; i++) {
            irpf.cadastrarDeducaoIntegral(deducoes[i], valores[i]);
        }

        if (valorEsperadoConsulta == null) {
            assertNull(irpf.getOutrasDeducoes(consultaDeducao));
            assertEquals(0f, irpf.getDeducao(consultaDeducao), 0f);
        } else {
            assertNotNull(irpf.getOutrasDeducoes(consultaDeducao));
            assertEquals(valorEsperadoConsulta, irpf.getDeducao(consultaDeducao), 0f);
        }

        assertEquals(totalEsperado, irpf.getTotalOutrasDeducoes(), 0f);
    }
}