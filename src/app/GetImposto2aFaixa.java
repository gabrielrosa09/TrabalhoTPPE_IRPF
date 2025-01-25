package app;

public class GetImposto2aFaixa {

	private float baseDeCalculo;
	private float ocupacao = 0;
	private float valor1aFaixa = 2259.21f;
	private float valor2aFaixa = 2826.65f;

	public GetImposto2aFaixa(IRPF irpf) {
		this.baseDeCalculo = irpf.getBaseDeCalculo();
	}

	public float valor() {
		if (this.baseDeCalculo > this.valor2aFaixa) {
			this.ocupacao = this.valor2aFaixa - this.valor1aFaixa;
		} else if (
			this.baseDeCalculo < this.valor2aFaixa &&
			this.baseDeCalculo > this.valor1aFaixa
		) {
			this.ocupacao = this.baseDeCalculo - this.valor1aFaixa;
		}
		return 0.075f * this.ocupacao;
	}
}
