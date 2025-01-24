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
public class TesteBaseDeCalculo {

	private IRPF irpf;
	private float rendimentoTotal;
	private float baseDeCalculo;
	private float previdencia;

	public TesteBaseDeCalculo(
		float rendimentoTotal,
		float baseDeCalculo,
		float previdencia
	) {
		this.rendimentoTotal = rendimentoTotal;
		this.baseDeCalculo = baseDeCalculo;
		this.previdencia = previdencia;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
				{ 2000.0f, 2000.0f, 0f },
				{ 5000.0f, 4800.0f, 200.0f },
				{ 10000.0f, 6900.0f, 3100.0f },
			}
		);
	}

	@Before
	public void setup() {
		irpf = new IRPF();
	}

	@Test
	public void testBaseDeCalculo() {
		irpf.getRendimentoManager().criarRendimento("Salario", true, rendimentoTotal);
		irpf.getDeducaoManager().cadastrarDeducaoIntegral("Previdencia", previdencia);
		assertEquals(baseDeCalculo, irpf.getBaseDeCalculo(), 0.05f);
	}
}
