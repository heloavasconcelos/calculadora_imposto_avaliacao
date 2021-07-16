ENUNCIADO DO PROJETO:

Crie um projeto que controle cálculo de impostos de produtos e serviços em um pequeno país hipotético. Separe camadas em pacotes de acordo com as funções do conjunto de classes e/ou interfaces que você criar (model, view, dao, etc....)


No seu projeto, deverá haver uma Interface denominada CalculadoraDeImpostos, que terá os serviços abstratos:
public abstract double calcularImpostos(Servico serviço);
public abstract double calcularImpostos(Produto produto);


Crie uma classe denominada Produto, que implemente a interface CalculadoraDeImpostos e, além disso, possua atributos de instância: código, nome, preço e uma alíquota (numero double).
Crie uma classe denominada Servico, que contenha o código, nome e o preço. A classe serviço deverá implementar também a interface CalculadoraDeImpostos.
O imposto calculado de um produto é dado pelo seu preço, multiplicado pela sua alíquota. Implemente na classe Produto, escrevendo o método da Interface.
O imposto calculado de um serviço é o preço do serviço, multiplicado por 0,05 (a alíquota é fixa de 5%). Implemente na classe Serviço, escrevendo o método da Interface.
Crie um banco de dados em Postgresql com as tabelas "PRODUTOS" e "SERVIÇOS", com campos correspondentes aos das respectivas classes que criou no projeto Java. ATENÇÃO, SUA BASE DE DADOS NO POSTGRESQL DEVERÁ SE CHAMAR "BD_IMPOSTOS".
Acrescente, direto no banco de dados, pelo menos 3 produtos e 3 serviços. Coloque valores que você quiser nas alíquotas e preços.
No seu projeto Java, acrescente uma pasta denominada "SCRIPTS" e inclua o script SQL (arquivo texto em formato .sql ou .txt) que gere as tabelas e insira os registros de produtos e serviços que você acrescentou no item acima.
Crie uma camada de acesso a dados, no pacote DAO, uma Fábrica de Conexões com o banco de dados que você criou.
Sua camada DAO deverá possuir as classes ServicoDAO e ProdutoDao.
As classes DAO acima deverão possuir:
serviços para pegar uma instância a partir do seu código, devovendo o objeto (getInstance).
serviço para pegar todas as instâncias (getAll), devolvendo uma lista de objetos.
Atenção, não é necessário criar serviços de inserir, alterar ou excluir no DAO para este projeto.
Crie uma classe executável, denominada "Principal.Java", que mostre um menu ao usuário onde este poderá informar o código de um produto ou de um serviço e o sistema, buscando no banco de dados pelos serviços DAO, irá usar o cálculo de imposto e mostrar o imposto do produto ou do serviço  cujo código foi digitado pelo usuário, mostrando o nome, o preço, a alíquota e o imposto calculado.
Crie uma interface gráfica, usando uma Jtable Swing, onde os todos os Produtos do Banco de Dados possam ser visualizados. Ao clicar em um dos produtos na Jtable e em seguida no botão "Calcular Imposto", o sistema deverá mostrar o imposto calculado ao usuário.