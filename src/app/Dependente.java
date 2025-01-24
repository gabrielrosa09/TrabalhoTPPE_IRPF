package app;

public class Dependente {
    private String[] nomesDependentes;
    private String[] parentescosDependentes;
    private int numDependentes;
    private float totalPensaoAlimenticia;

    public Dependente() {
        nomesDependentes = new String[0];
        parentescosDependentes = new String[0];
        totalPensaoAlimenticia = 0f;
    }

    public void cadastrarDependente(String nome, String parentesco) {
        nomesDependentes = expandArray(nomesDependentes, nome);
        parentescosDependentes = expandArray(parentescosDependentes, parentesco);
        numDependentes++;
    }

    public int getNumDependentes() {
        return numDependentes;
    }

    public String getParentesco(String dependente) {
        for (int i = 0; i < nomesDependentes.length; i++) {
            if (nomesDependentes[i].equalsIgnoreCase(dependente)) {
                return parentescosDependentes[i];
            }
        }
        return null;
    }

    public String getDependente(String nome) {
        for (String d : nomesDependentes) {
            if (d.contains(nome))
                return d;
        }
        return null;
    }

    public String[] getNomesDependentes() {
        return nomesDependentes;
    }

    private String[] expandArray(String[] array, String value) {
        String[] temp = java.util.Arrays.copyOf(array, array.length + 1);
        temp[array.length] = value;
        return temp;
    }

    public void cadastrarPensaoAlimenticia(String dependente, float valor) {
        String parentesco = getParentesco(dependente);
        if (parentesco.toLowerCase().contains("filh") ||
                parentesco.toLowerCase().contains("alimentand")) {
            totalPensaoAlimenticia += valor;
        }
    }

    public float getTotalPensaoAlimenticia() {
        return totalPensaoAlimenticia;
    }
}
