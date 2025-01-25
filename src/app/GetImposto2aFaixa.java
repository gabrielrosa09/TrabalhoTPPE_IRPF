package app;

public class GetImposto2aFaixa {

	private float baseDeCalculo;
	private float ocupacao = 0;
	private final float valor1aFaixa = 2259.21f;
	private final float valor2aFaixa = 2826.65f;

	public GetImposto2aFaixa(IRPF irpf) {
		this.baseDeCalculo = irpf.getBaseDeCalculo();
	}

	public float valor() {
		if (baseDeCalculo > valor2aFaixa) {
			ocupacao = valor2aFaixa - valor1aFaixa;
		} else if (baseDeCalculo > valor1aFaixa && baseDeCalculo <= valor2aFaixa) {
			ocupacao = baseDeCalculo - valor1aFaixa;
		}
		return 0.075f * ocupacao;
	}
}
