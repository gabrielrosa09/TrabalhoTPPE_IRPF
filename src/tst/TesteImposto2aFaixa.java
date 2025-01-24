package tst;

import static org.junit.Assert.assertEquals;

import app.GetImposto2aFaixa;
import app.IRPF;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TesteImposto2aFaixa {

	private IRPF irpf;
	private float baseDeCalculo;
	private float impostoEsperado;

	public TesteImposto2aFaixa(float baseDeCalculo, float impostoEsperado) {
		this.baseDeCalculo = baseDeCalculo;
		this.impostoEsperado = impostoEsperado;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 2820.0f, 42.06f }, // 2a faixa
				{ 2650.0f, 29.31f }, // 2a faixa
				{ 2260.0f, 0.06f },  // 2a faixa
		});
	}

	@Before
	public void setup() {
		irpf = new IRPF();
	}

	@Test
	public void testImposto2aFaixa() {
		irpf.getRendimentoManager().criarRendimento("Salario", IRPF.TRIBUTAVEL, baseDeCalculo);
		float impostoCalculado = new GetImposto2aFaixa(irpf).valor();
		assertEquals(impostoEsperado, impostoCalculado, 0.05f);
	}
}
