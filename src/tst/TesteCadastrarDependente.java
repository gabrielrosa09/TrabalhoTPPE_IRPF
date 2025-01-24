package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import app.IRPF;

@RunWith(Parameterized.class)
public class TesteCadastrarDependente {

    private IRPF irpf;
    public String[] dependente;
    public String[] parentesco;
    public int numDependentesEsperado;
    public String[] buscarDependente;
    public boolean dependenteExiste;
    
    public TesteCadastrarDependente(String[] dependente, String[] parentesco, int numDependentesEsperado, String[] buscarDependente, boolean dependenteExiste) {
    	this.dependente = dependente;
    	this.parentesco = parentesco;
    	this.numDependentesEsperado = numDependentesEsperado;
    	this.buscarDependente = buscarDependente;
    	this.dependenteExiste = dependenteExiste;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
    	return Arrays.asList(new Object[][]{
    		{new String[] {"Miguel"}, new String[] {"Filho"}, 1, new String[] {""}, true},
    		{new String[] {"Miguel", "Maria"}, new String[] {"Filho", "Filho"}, 2, new String[] {"Miguel", "Maria"}, true},
    		{new String[] {"Miguel", "Maria", "Carlos"}, new String[] {"Filho", "Filho", "Filho"}, 3, new String[] {"Miguel", "Maria", "Carlos"}, true},
    		{new String[] {"Jose da Silva"}, new String[] {"filho"}, 1, new String[] {"Jose"}, true},
    		{new String[] {"Jose da Silva", "Laura da Silva"}, new String[] {"filho", "filho"}, 2, new String[] {"Jose", "Laura"}, true},
    		{new String[] {}, new String[] {}, 0, new String[] {" "}, false}
    		
    	});
    }

    @Before
    public void setup() {
        irpf = new IRPF();
    }
    
    @Test public void testCadastroDependente() {
    	for (int i = 0; i < dependente.length; i++) { 
    		irpf.getDependenteManager().cadastrarDependente(dependente[i], parentesco[i]);
        	assertTrue(irpf.getDependenteManager().getParentesco(dependente[i]).equalsIgnoreCase(parentesco[i]));
    	}
    	assertEquals(numDependentesEsperado, irpf.getDependenteManager().getNumDependentes());
    }
    
    @Test
    public void obterDependente() {
    	for (int i = 0; i < dependente.length; i++) {
    		irpf.getDependenteManager().cadastrarDependente(dependente[i], parentesco[i]);
    		String dependenteAchado = irpf.getDependenteManager().getDependente(buscarDependente[i]);
    		assertNotNull(dependenteAchado);
    		assertTrue(irpf.getDependenteManager().getParentesco(dependenteAchado).equalsIgnoreCase(parentesco[i]));
    	}
    }
    
    @Test
    public void dependenteInexistente() {
        for (String dependenteBuscado : buscarDependente) {
            String dependenteAchado = irpf.getDependenteManager().getDependente(dependenteBuscado);
            assertNull(dependenteAchado);
            String parentescoAchado = irpf.getDependenteManager().getParentesco(dependenteAchado);
            assertNull(parentescoAchado);
        }
    }
    
}