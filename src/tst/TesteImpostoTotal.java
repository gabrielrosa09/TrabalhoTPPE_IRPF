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
public class TesteImpostoTotal {

	private IRPF irpf;
	private float baseDeCalculo;
	private float impostoEsperado;

	public TesteImpostoTotal(float baseDeCalculo, float impostoEsperado) {
		this.baseDeCalculo = baseDeCalculo;
		this.impostoEsperado = impostoEsperado;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
				{ 2250.0f, 0.0f }, // 		1a faixa
				{ 2820.0f, 42.06f }, // 	2a faixa
				{ 3750.0f, 181.06f }, // 	3a faixa
				{ 4660.0f, 385.73f }, // 	4a faixa
				{ 6810.41f, 976.86f }, // 	5a faixa
			}
		);
	}

	@Before
	public void setup() {
		irpf = new IRPF();
	}

	@Test
	public void testImpostoTotal() {
		irpf.getRendimentoManager().criarRendimento("Salario", true, baseDeCalculo);
		assertEquals(impostoEsperado, irpf.getImpostoTotal(), 0.05f);
	}
}
