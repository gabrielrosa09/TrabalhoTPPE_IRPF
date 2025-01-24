package app;

public class Deducao {
    private String[] nomesDeducoes;
    private float[] valoresDeducoes;
    private float totalContribuicaoPrevidenciaria;

    public Deducao() {
        nomesDeducoes = new String[0];
        valoresDeducoes = new float[0];
    }

    public void cadastrarDeducaoIntegral(String nome, float valorDeducao) {
        nomesDeducoes = adicionarNome(nomesDeducoes, nome);
        valoresDeducoes = adicionarValor(valoresDeducoes, valorDeducao);
    }

    private String[] adicionarNome(String[] nomesDeducoes, String nome) {
        String[] temp = new String[nomesDeducoes.length + 1];
        for (int i = 0; i < nomesDeducoes.length; i++) {
            temp[i] = nomesDeducoes[i];
        }
        temp[nomesDeducoes.length] = nome;
        return temp;
    }

    private float[] adicionarValor(float[] valoresDeducoes, float valorDeducao) {
        float[] temp = new float[valoresDeducoes.length + 1];
        for (int i = 0; i < valoresDeducoes.length; i++) {
            temp[i] = valoresDeducoes[i];
        }
        temp[valoresDeducoes.length] = valorDeducao;
        return temp;
    }

    public float getDeducao(Dependente dependenteManager) {
        float total = dependenteManager.getNumDependentes() * 189.59f;
        total += totalContribuicaoPrevidenciaria;
        for (float valor : valoresDeducoes) {
            total += valor;
        }
        return total;
    }

    private String[] expandArray(String[] array, String value) {
        String[] temp = java.util.Arrays.copyOf(array, array.length + 1);
        temp[array.length] = value;
        return temp;
    }

    private float[] expandArray(float[] array, float value) {
        float[] temp = java.util.Arrays.copyOf(array, array.length + 1);
        temp[array.length] = value;
        return temp;
    }
}
