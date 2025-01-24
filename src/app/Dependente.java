package app;

public class Dependente {
    private String[] nomesDependentes;
    private String[] parentescosDependentes;
    private int numDependentes;
    private float totalPensaoAlimenticia;

    public Dependente() {
        nomesDependentes = new String[0];
        parentescosDependentes = new String[0];
        numDependentes = 0;
        totalPensaoAlimenticia = 0f;
    }

    public void cadastrarDependente(String nome, String parentesco) {
        String[] temp = new String[nomesDependentes.length + 1];
        for (int i=0; i<nomesDependentes.length; i++) {
            temp[i] = nomesDependentes[i];
        }
        temp[nomesDependentes.length] = nome;
        nomesDependentes = temp;

        String[] temp2 = new String[parentescosDependentes.length + 1];
        for (int i=0; i<parentescosDependentes.length; i++) {
            temp2[i] = parentescosDependentes[i];
        }
        temp2[parentescosDependentes.length] = parentesco;
        parentescosDependentes = temp2;

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
            if (d.equalsIgnoreCase(nome))
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
