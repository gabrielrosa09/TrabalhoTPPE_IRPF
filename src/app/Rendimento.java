package app;

public class Rendimento {
    private String[] nomeRendimento;
    private boolean[] rendimentoTributavel;
    private float[] valorRendimento;
    private int numRendimentos;
    private float totalRendimentos;
    public static final boolean TRIBUTAVEL = true;
    public static final boolean NAOTRIBUTAVEL = false;

    public Rendimento() {
        nomeRendimento = new String[0];
        rendimentoTributavel = new boolean[0];
        valorRendimento = new float[0];
    }

    public void criarRendimento(String nome, boolean tributavel, float valor) {
        nomeRendimento = expandArray(nomeRendimento, nome);
        rendimentoTributavel = expandArray(rendimentoTributavel, tributavel);
        valorRendimento = expandArray(valorRendimento, valor);

        numRendimentos++;
        totalRendimentos += valor;
    }

    public int getNumRendimentos() {
        return numRendimentos;
    }

    public float getTotalRendimentos() {
        return totalRendimentos;
    }

    public float getTotalRendimentosTributaveis() {
        float total = 0;
        for (int i = 0; i < rendimentoTributavel.length; i++) {
            if (rendimentoTributavel[i]) {
                total += valorRendimento[i];
            }
        }
        return total;
    }

    public float calcularImpostoFaixa(float baseDeCalculo, float faixaInicio, float faixaFim, float aliquota) {
        float ocupacao = 0;
        if (baseDeCalculo > faixaFim) {
            ocupacao = faixaFim - faixaInicio;
        } else if (baseDeCalculo > faixaInicio) {
            ocupacao = baseDeCalculo - faixaInicio;
        }
        return ocupacao * aliquota;
    }

    private <T> T[] expandArray(T[] array, T value) {
        T[] temp = java.util.Arrays.copyOf(array, array.length + 1);
        temp[array.length] = value;
        return temp;
    }

    private float[] expandArray(float[] array, float value) {
        float[] temp = java.util.Arrays.copyOf(array, array.length + 1);
        temp[array.length] = value;
        return temp;
    }

    private boolean[] expandArray(boolean[] array, boolean value) {
        boolean[] temp = java.util.Arrays.copyOf(array, array.length + 1);
        temp[array.length] = value;
        return temp;
    }
}
