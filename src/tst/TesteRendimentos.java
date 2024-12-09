package tst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import app.IRPF;

@RunWith(Parameterized.class)
public class TesteRendimentos {

    private IRPF irpf;
    private Object[][] rendimentos;
    private int numRendimentosEsperado;
    private float totalRendimentosEsperado;
    private float totalRendimentosTributaveisEsperado;

    public TesteRendimentos(Object[][] rendimentos, int numRendimentosEsperado, float totalRendimentosEsperado, float totalRendimentosTributaveisEsperado) {
        this.rendimentos = rendimentos;
        this.numRendimentosEsperado = numRendimentosEsperado;
        this.totalRendimentosEsperado = totalRendimentosEsperado;
        this.totalRendimentosTributaveisEsperado = totalRendimentosTributaveisEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new Object[][] {{"Salario", IRPF.TRIBUTAVEL, 5000f}}, 1, 5000f, 5000f },
                { new Object[][] {{"Aluguel", IRPF.TRIBUTAVEL, 4000f}}, 1, 4000f, 4000f },
                { new Object[][] {{"Salario", IRPF.TRIBUTAVEL, 5000f}, {"Aluguel", IRPF.TRIBUTAVEL, 4000f}}, 2, 9000f, 9000f },
                { new Object[][] {{"Salario", IRPF.TRIBUTAVEL, 5000f}, {"Aluguel", IRPF.TRIBUTAVEL, 4000f}, {"Bolsa de pesquisa", IRPF.NAOTRIBUTAVEL, 3000f}}, 3, 12000f, 9000f }
        });
    }

    @Before
    public void setup() {
        irpf = new IRPF();
    }

    @Test
    public void testRendimentos() {
        for (Object[] rendimento : rendimentos) {
            String nomeRendimento = (String) rendimento[0];
            boolean tributavel = (boolean) rendimento[1];
            float valor = (float) rendimento[2];
            irpf.criarRendimento(nomeRendimento, tributavel, valor);
        }

        assertEquals(numRendimentosEsperado, irpf.getNumRendimentos());
        assertEquals(totalRendimentosEsperado, irpf.getTotalRendimentos(), 0);
        assertEquals(totalRendimentosTributaveisEsperado, irpf.getTotalRendimentosTributaveis(), 0);
    }
}
