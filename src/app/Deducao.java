package app;

class Deducao {
    private String[] nomesDeducoes;
    private float[] valoresDeducoes;
    private float totalContribuicaoPrevidenciaria;

    public Deducao() {
        nomesDeducoes = new String[0];
        valoresDeducoes = new float[0];
    }

    public void cadastrarDeducaoIntegral(String nome, float valorDeducao) {
        nomesDeducoes = expandArray(nomesDeducoes, nome);
        valoresDeducoes = expandArray(valoresDeducoes, valorDeducao);
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
