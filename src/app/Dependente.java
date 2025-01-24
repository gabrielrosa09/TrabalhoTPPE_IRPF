package app;

class Dependente {
    private String[] nomesDependentes;
    private String[] parentescosDependentes;
    private int numDependentes;

    public Dependente() {
        nomesDependentes = new String[0];
        parentescosDependentes = new String[0];
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

    private String[] expandArray(String[] array, String value) {
        String[] temp = java.util.Arrays.copyOf(array, array.length + 1);
        temp[array.length] = value;
        return temp;
    }
}
