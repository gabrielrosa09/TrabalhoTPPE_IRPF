package tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import java.util.Collection;

@RunWith(Parameterized.class)
public class TesteCalculosDeducoesDependentes {

    private IRPF irpf;
    private String[] dependentes;
    private float deducaoEsperada;

    public TesteCalculosDeducoesDependentes(String[] dependentes, float deducaoEsperada){
        this.dependentes = dependentes;
        this.deducaoEsperada = deducaoEsperada;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"Maria da Silva"}, 189.59f},
                {new String[]{"Maria da Silva", "Carlos da Silva"}, 379.18f},
                {new String[]{"Maria da Silva", "Carlos da Silva", "Jose da Silva"}, 568.77f}
        });
    }

    @Before
    public void setup() {
        irpf = new IRPF();
    }

    @Test
    public void testDeducaoDependentes() {
        for (String dependente : dependentes){
            irpf.cadastrarDependente(dependente, "Filho");
        }
        assertEquals(deducaoEsperada, irpf.getDeducao(), 0.0f);
    }

}