package app;

public class IRPF {
    private Rendimento rendimentoManager;
    private Dependente dependenteManager;
    private Deducao deducaoManager;
    private float imposto2aFaixa;

    public IRPF() {
        rendimentoManager = new Rendimento();
        dependenteManager = new Dependente();
        deducaoManager = new Deducao();
    }

    public Rendimento getRendimentoManager() {
        return rendimentoManager;
    }

    public Dependente getDependenteManager() {
        return dependenteManager;
    }

    public Deducao getDeducaoManager() {
        return deducaoManager;
    }

    public float getBaseDeCalculo() {
        return rendimentoManager.getTotalRendimentos() - deducaoManager.getDeducao(dependenteManager);
    }

    public float getImposto1aFaixa() {
        return rendimentoManager.calcularImpostoFaixa(getBaseDeCalculo(), 0, 2259.21f, 0.075f);
    }

    public float getImposto3aFaixa() {
        return rendimentoManager.calcularImpostoFaixa(getBaseDeCalculo(), 2826.66f, 3751.05f, 0.15f);
    }

    public float getImposto4aFaixa() {
        return rendimentoManager.calcularImpostoFaixa(getBaseDeCalculo(), 3751.06f, 4664.68f, 0.225f);
    }

    public float getImposto5aFaixa() {
        return rendimentoManager.calcularImpostoFaixa(getBaseDeCalculo(), 4664.68f, Float.MAX_VALUE, 0.275f);
    }

    public float getImpostoTotal() {
    	this.imposto2aFaixa = new GetImposto2aFaixa(this).valor();
        return getImposto1aFaixa() + imposto2aFaixa + getImposto3aFaixa() + getImposto4aFaixa() + getImposto5aFaixa();
    }

    public float getAliquota() {
        return (getImpostoTotal() / rendimentoManager.getTotalRendimentos()) * 100.0f;
    }
}