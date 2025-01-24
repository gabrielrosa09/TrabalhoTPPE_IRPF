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
public class TesteImposto1aFaixa {

	private IRPF irpf;
	private float baseDeCalculo;
	private float impostoEsperado;

	public TesteImposto1aFaixa(float baseDeCalculo, float impostoEsperado) {
		this.baseDeCalculo = baseDeCalculo;
		this.impostoEsperado = impostoEsperado;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
				{ 2250.0f, 0.0f }, // 	1a faixa
				{ 1850.0f, 0.0f }, // 	1a faixa
				{ 1600.0f, 0.0f }, // 	1a faixa
			}
		);
	}

	@Before
	public void setup() {
		irpf = new IRPF();
	}

	@Test
	public void testImposto1aFaixa() {
		irpf.getRendimentoManager().criarRendimento("Salario", true, baseDeCalculo);
		assertEquals(impostoEsperado, irpf.getImposto1aFaixa(), 0.05f);
	}
}
