package tst;

import static org.junit.Assert.assertEquals;

import app.IRPF;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TesteAliquota {

	private IRPF irpf;
	private float rendimentoTotal;
	private float previdencia;
	private float aliquotaEsperada;

	public TesteAliquota(
		float rendimentoTotal,
		float previdencia,
		float aliquotaEsperada
	) {
		this.rendimentoTotal = rendimentoTotal;
		this.previdencia = previdencia;
		this.aliquotaEsperada = aliquotaEsperada;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
				{ 2000.0f, 100.0f, 0f },
				{ 5000.0f, 1250.0f, 3.62f },
				{ 10000.0f, 3189.59f, 9.77f },
			}
		);
	}

	@Before
	public void setup() {
		irpf = new IRPF();
	}

	@Test
	public void testAliquota() {
		irpf.getRendimentoManager().criarRendimento("Salario", true, rendimentoTotal);
		irpf.getDeducaoManager().cadastrarContribuicaoPrevidenciaria(previdencia);
		assertEquals(aliquotaEsperada, irpf.getAliquota(), 0.05f);
	}
}
