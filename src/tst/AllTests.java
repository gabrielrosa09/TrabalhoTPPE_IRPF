package tst;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteCadastrarDependente.class,
        TesteRendimentos.class,
        TesteCalculosDeducoesDependentes.class,
        TesteCadastroContribuicaoPrevidenciaria.class,
        TesteCadastroPensaoAlimenticia.class,
        TesteCadastroOutrasDeducoes.class,
        TesteBaseDeCalculo.class,
		TesteAliquota.class,
		TesteImpostoTotal.class,
		TesteImposto1aFaixa.class,
		TesteImposto2aFaixa.class,
		TesteImposto3aFaixa.class,
		TesteImposto4aFaixa.class,
		TesteImposto5aFaixa.class
})
public class AllTests {

}