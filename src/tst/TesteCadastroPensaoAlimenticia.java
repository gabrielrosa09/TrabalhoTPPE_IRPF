package tst;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import app.IRPF;

@RunWith(Parameterized.class)
public class TesteCadastroPensaoAlimenticia {

    private IRPF irpf;
    public String[] dependentes;
    public String[] parentesco;
    public float pensaoEsperada;
    
    public TesteCadastroPensaoAlimenticia(String[] dependentes, String[] parentesco, float pensaoEsperada) {
    	this.dependentes = dependentes;
    	this.parentesco = parentesco;
    	this.pensaoEsperada = pensaoEsperada;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
    	return Arrays.asList(new Object[][]{
    		{new String[] {"Jose da Silva"}, new String[] {"filho"}, 1000f},
    		{new String[] {"Jose da Silva", "Laura da Silva"}, new String[] {"filho", "filha"}, 2000f},
    		{new String[] {"Jose da Silva", "Laura da Silva", "Carlos da Silva", "Maria da Silva"}, new String[] {"filho", "filha", "Alimentando", "Mae"}, 3000f} 
    	});
    }

    @Before
    public void setup() {
        irpf = new IRPF();
    }

    @Test
    public void testeCadastroPensaoAlimenticia() {
    	for (int i = 0; i < dependentes.length; i++ ) {
    		irpf.getDependenteManager().cadastrarDependente(dependentes[i], parentesco[i]);
    		irpf.getDependenteManager().cadastrarPensaoAlimenticia(dependentes[i], 1000f);
    	}
    	assertEquals(pensaoEsperada, irpf.getDependenteManager().getTotalPensaoAlimenticia(), 0f);
    }
}