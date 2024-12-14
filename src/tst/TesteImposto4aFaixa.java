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
public class TesteImposto4aFaixa {

	private IRPF irpf;
	private float baseDeCalculo;
	private float impostoEsperado;

	public TesteImposto4aFaixa(float baseDeCalculo, float impostoEsperado) {
		this.baseDeCalculo = baseDeCalculo;
		this.impostoEsperado = impostoEsperado;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
				{ 4660.0f, 204.51f }, // 	4a faixa
				{ 4250.0f, 112.26f }, // 	4a faixa
				{ 3760.0f, 2.01f }, // 	4a faixa
			}
		);
	}

	@Before
	public void setup() {
		irpf = new IRPF();
	}

	@Test
	public void testImposto4aFaixa() {
		irpf.criarRendimento("Salario", true, baseDeCalculo);
		assertEquals(impostoEsperado, irpf.getImposto4aFaixa(), 0.05f);
	}
}
