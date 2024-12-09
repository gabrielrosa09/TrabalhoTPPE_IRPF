UnB - Universidade de Brasilia <br>
FCTE - Faculdade de Ciências e Tecnologias em Engenharias <br>
FGA0242 - Técnicas de Programação para Plataformas Emergentes

# Trabalho Prático - 2024/2

## Descrição

O Imposto de Renda de Pessoas Físicas (IRPF) é um imposto federal calculado com base na renda e despesas dedutíveis dos cidadãos brasileiros. De modo bastante resumido, o imposto considera, mensalmente, todas as rendas tributáveis recebidas pelo cidadão e todas suas deduções legais. A base de cálculo do IRPF é a diferença da renda pelas deduções de modo que o imposto devido é calculado sobre esse valor. Por fim, a alíquota efetiva é dada pelo quociente entre o imposto pago e o total de rendimentos tributáveis. Cada um desses passos está apresentado no [repositório da disciplina](https://github.com/andrelanna/fga0242/tree/master/trabalhoPratico), através de um exemplo ilustrativo.

## Integrantes

| Nome | Matrícula |
|------|-----------|
| Ana Caroline C. Rocha | 190083930 |
| Gabriel da Silva Rosa | 202023681 |
| Hellen Fernanda M. de Faria | 202016480 |
| Lais Portela de Aguiar | 190046848 |

## Primeira Entrega - TDD

Para essa entrega o grupo devverá criar testes triangulados (parametrizados, preferencialmente) para cada uma das unidades mencionadas abaixo, e os testes têm que estar integrados à suíte de testes presente no arquivo AllTests.java.

| Classe                                  | Funcionalidade                    |
|:----------------------------------------|:----------------------------------|
| TesteCadastrarDependente                | Cadastrar dependentes             |
| TesteRendimentos                        | Cadastrar rendimentos             |
| TesteCalculosDeducoesDependentes        | Calcular deduções por dependentes |
| TesteCadastroContribuicaoPrevidenciaria | Calcular deducoes por previdencia |
| TesteCadastroPensaoAlimenticia          | Calcular deducoes por pensoes     |
| TesteCadastroOutrasDeducoes             | Calcular outros tipos de deducoes |
 
Ainda serão implementados os testes e as unidades para o cálculo: 
 - a base de cálculo do imposto, 
 - os impostos por faixas e o total do imposto, 
 - e a alíquota efetiva do imposto pago. 