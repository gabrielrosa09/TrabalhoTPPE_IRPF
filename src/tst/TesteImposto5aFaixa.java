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
public class TesteImposto5aFaixa {

	private IRPF irpf;
	private float baseDeCalculo;
	private float impostoEsperado;

	public TesteImposto5aFaixa(float baseDeCalculo, float impostoEsperado) {
		this.baseDeCalculo = baseDeCalculo;
		this.impostoEsperado = impostoEsperado;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
				{ 6810.41f, 590.07f }, // 5a faixa
				{ 10000.0f, 1467.21f }, // 5a faixa
				{ 4670.0f, 1.46f }, // 5a faixa
			}
		);
	}

	@Before
	public void setup() {
		irpf = new IRPF();
	}

	@Test
	public void testImposto5aFaixa() {
		irpf.getRendimentoManager().criarRendimento("Salario", true, baseDeCalculo);
		assertEquals(impostoEsperado, irpf.getImposto5aFaixa(), 0.05f);
	}
}
