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

    private IRPF irpf;
    private final int[] contribuicoes;
    private final int numContribuicoesEsperadas;
    private final float totalContribuicoesEsperadas;

    public TesteCadastroContribuicaoPrevidenciaria(
            int[] contribuicoes,
            int numContribuicoesEsperadas,
            float totalContribuicoesEsperadas
    ) {
        this.contribuicoes = contribuicoes;
        this.numContribuicoesEsperadas = numContribuicoesEsperadas;
        this.totalContribuicoesEsperadas = totalContribuicoesEsperadas;
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
            irpf.getDeducaoManager().cadastrarDeducaoIntegral("Contribuição Previdenciária", contribuicao);
        }

        assertEquals(numContribuicoesEsperadas, irpf.getDeducaoManager().getNumContribuicoesPrevidenciarias());
        assertEquals(totalContribuicoesEsperadas, irpf.getDeducaoManager().getTotalContribuicoesPrevidenciarias(), 0f);

        assertEquals(totalContribuicoesEsperadas, irpf.getDeducaoManager().getDeducao(irpf.getDependenteManager()), 0f);
    }
}

