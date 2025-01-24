package app;

public class Deducao {
    private String[] nomesDeducoes;
    private float[] valoresDeducoes;
    private float totalContribuicaoPrevidenciaria;
    private int numContribuicaoPrevidenciaria;
    Dependente dependente = new Dependente();

    public Deducao() {
        nomesDeducoes = new String[0];
        valoresDeducoes = new float[0];
        numContribuicaoPrevidenciaria = 0;
        totalContribuicaoPrevidenciaria = 0f;
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

    public void cadastrarContribuicaoPrevidenciaria(float contribuicao) {
        numContribuicaoPrevidenciaria++;
        totalContribuicaoPrevidenciaria += contribuicao;
    }

    public float getDeducao(Dependente dependenteManager) {
        float total = dependenteManager.getNumDependentes() * 189.59f;
        total += totalContribuicaoPrevidenciaria;
        for (float valor : valoresDeducoes) {
            total += valor;
        }
        return total;
    }

    public int getNumContribuicoesPrevidenciarias() {
        return numContribuicaoPrevidenciaria;
    }

    public float getTotalContribuicoesPrevidenciarias() {
        return totalContribuicaoPrevidenciaria;
    }

    public String getOutrasDeducoes(String nome) {
        for (String d : nomesDeducoes) {
            if (d.toLowerCase().contains(nome.toLowerCase()))
                return d;
        }
        return null;
    }

    public float getDeducao(String nome) {
        for (int i=0; i<nomesDeducoes.length; i++) {
            if (nomesDeducoes[i].toLowerCase().contains(nome.toLowerCase()))
                return valoresDeducoes[i];
        }
        return 0;
    }

    public float getTotalOutrasDeducoes() {
        float soma = 0;
        for (float f : valoresDeducoes) {
            soma += f;
        }
        return soma;
    }

    public float getDeducao() {
        float total = 0;
        for (String d: dependente.getNomesDependentes()) {
            total += 189.59f;
        }
        total += totalContribuicaoPrevidenciaria;

        return total;
    }

}
