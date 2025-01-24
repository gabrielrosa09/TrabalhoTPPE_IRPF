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
public class TesteImposto3aFaixa {

	private IRPF irpf;
	private float baseDeCalculo;
	private float impostoEsperado;

	public TesteImposto3aFaixa(float baseDeCalculo, float impostoEsperado) {
		this.baseDeCalculo = baseDeCalculo;
		this.impostoEsperado = impostoEsperado;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
				{ 3750.0f, 138.5f }, // 	3a faixa
				{ 3200.0f, 56.0f }, // 	3a faixa
				{ 2830.0f, 0.50f }, // 	3a faixa
			}
		);
	}

	@Before
	public void setup() {
		irpf = new IRPF();
	}

	@Test
	public void testImposto3aFaixa() {
		irpf.getRendimentoManager().criarRendimento("Salario", true, baseDeCalculo);
		assertEquals(impostoEsperado, irpf.getImposto3aFaixa(), 0.05f);
	}
}
