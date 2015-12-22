=========================
 - XY-INC --------------
=========================

Notas:
	- Foi utilizado MySql. No projeto est� incluso o dump do banco (dump.sql).
	- O projeto foi constru�do para rodar no servidor Apache Tomcat 8.0.30.
	  O Tomcat foi escolhido porque, dentre os servidores que tenho familiaridade,
	  ele � o mais leve.
	- Foi utilizado o jdk1.8.0_65.
	- Devido ao pequeno volume de transa��es, optei por n�o utilizar nenhum
	  framework para inje��o de depend�ncias e controle de transa��o, diminuindo 
	  o n�mero de pacotes e arquivos de configura��o utilizados.
	- Mais tarde me arrependi da ideia, j� que os testes unit�rios que envolvem 
	  banco de dados s�o muito mais simples de implementar com esses servi�os.
	  Infelizmente, voltar atr�s comprometeria o prazo de entrega.
	- Por esta raz�o os testes dos servi�os que envolvem banco iriam acessar o banco
	  de dados de produ��o e assim foram desabilitados no pom.xml do projeto.

Instala��o:
	- � necess�rio a utiliza��o do Maven para construir o projeto
	- Baixe o projeto para um diret�rio a sua escolha
	- Execute o comando "mvn package"
	- Ser� criada uma pasta "target", dentro dela ter� o arquivo .war
	- Adicione o arquivo .war no diret�rio webapps do Apache Tomcat e 
	  ser� feito o deploy automaticamente
	  
Utiliza��o do Eclipse:
	- � necess�rio a utiliza��o do Maven para construir o projeto
	- Baixe o projeto para um diret�rio a sua escolha
	- Execute o comando "mvn eclipse:eclipse"
	- Ser�o criados os arquivos do projeto
	- Dentro do eclipse importe o projeto como "existing maven project"
	
Teste das funcionalidades:
	- Com o projeto sendo executado no servidor, basta acessar o endere�o do mesmo,
	  Ex: http://localhost:8080/xy-inc
	- A p�gina index.jsp tr�s um link para cadastro dos Pontos de Interesse e a
	  possibilidade de listar todos ou os POI pr�ximos
	- As p�ginas jsp acessam os servi�os via Ajax, os servi�os est�o descritos a
	  seguir:
	    -- Listar todos:
	        -> localhost:8080/xy-inc/rest/pontosDeInteresse/todos
	        Acessado por m�todo GET, retorna uma lista de JSON dos POI.
	    -- Listar por proximidade:
	        -> localhost:8080/xy-inc/rest/pontosDeInteresse/proximos/X/Y/dMax
	        Acessado por m�todo GET; retorna uma lista de JSON dos POI;
	    -- Cadastro de POI:
	        -> localhost:8080/xy-inc/rest/pontosDeInteresse/cadastro
	        Acessado por m�todo POST; Consome um JSON com o objeto POI a ser
	        persistido;
	        Em caso de sucesso, retorna status 201 e o JSON do objeto persistido
	        Em caso de erro ao preencher os dados, retorna status 400 e a mensagem
	        de erro
	        Em caso de erro ao conectar com o banco de dados, retorna status 500 e
	        a mensagem de erro 

Contato:
	danielnovato[at]gmail.c om
	