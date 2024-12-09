package tst;

import app.IRPF;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TesteCadastroContribuicaoPrevidenciaria {

    IRPF irpf;
    private final int[] contribuicoes;
    private final int numcontribuicoesEsperadas;
    private float totalcontribuicoesEsperadas;

    public TesteCadastroContribuicaoPrevidenciaria(int[] contribuicoes, int numcontribuicoesEsperadas, float totalcontribuicoesEsperadas) {
        this.contribuicoes = contribuicoes;
        this.numcontribuicoesEsperadas = numcontribuicoesEsperadas;
        this.totalcontribuicoesEsperadas = totalcontribuicoesEsperadas;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[]{1000}, 1, 1000f },
                { new int[]{1000, 500}, 2, 1500f },
                { new int[]{1000, 500, 200}, 3, 1700f }
        });
    }

    @Before
    public void setup() {
        irpf = new IRPF();
    }

    @Test
    public void testCadastroContribuicoesPrevidenciarias() {
        for (int contribuicao : contribuicoes) {
            irpf.cadastrarContribuicaoPrevidenciaria(contribuicao);
        }
        assertEquals(numcontribuicoesEsperadas, irpf.getNumContribuicoesPrevidenciarias());
        assertEquals(totalcontribuicoesEsperadas, irpf.getTotalContribuicoesPrevidenciarias(), 0f);
        assertEquals(totalcontribuicoesEsperadas, irpf.getDeducao(), 0f);
    }
}
