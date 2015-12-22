=========================
 - XY-INC --------------
=========================

Notas:
	- Foi utilizado MySql. No projeto está incluso o dump do banco (dump.sql).
	- O projeto foi construído para rodar no servidor Apache Tomcat 8.0.30.
	  O Tomcat foi escolhido porque, dentre os servidores que tenho familiaridade,
	  ele é o mais leve.
	- Foi utilizado o jdk1.8.0_65.
	- Devido ao pequeno volume de transações, optei por não utilizar nenhum
	  framework para injeção de dependências e controle de transação, diminuindo 
	  o número de pacotes e arquivos de configuração utilizados.
	- Mais tarde me arrependi da ideia, já que os testes unitários que envolvem 
	  banco de dados são muito mais simples de implementar com esses serviços.
	  Infelizmente, voltar atrás comprometeria o prazo de entrega.
	- Por esta razão os testes dos serviços que envolvem banco iriam acessar o banco
	  de dados de produção e assim foram desabilitados no pom.xml do projeto.

Instalação:
	- É necessário a utilização do Maven para construir o projeto
	- Baixe o projeto para um diretório a sua escolha
	- Execute o comando "mvn package"
	- Será criada uma pasta "target", dentro dela terá o arquivo .war
	- Adicione o arquivo .war no diretório webapps do Apache Tomcat e 
	  será feito o deploy automaticamente
	  
Utilização do Eclipse:
	- É necessário a utilização do Maven para construir o projeto
	- Baixe o projeto para um diretório a sua escolha
	- Execute o comando "mvn eclipse:eclipse"
	- Serão criados os arquivos do projeto
	- Dentro do eclipse importe o projeto como "existing maven project"
	
Teste das funcionalidades:
	- Com o projeto sendo executado no servidor, basta acessar o endereço do mesmo,
	  Ex: http://localhost:8080/xy-inc
	- A página index.jsp trás um link para cadastro dos Pontos de Interesse e a
	  possibilidade de listar todos ou os POI próximos
	- As páginas jsp acessam os serviços via Ajax, os serviços estão descritos a
	  seguir:
	    -- Listar todos:
	        -> localhost:8080/xy-inc/rest/pontosDeInteresse/todos
	        Acessado por método GET, retorna uma lista de JSON dos POI.
	    -- Listar por proximidade:
	        -> localhost:8080/xy-inc/rest/pontosDeInteresse/proximos/X/Y/dMax
	        Acessado por método GET; retorna uma lista de JSON dos POI;
	    -- Cadastro de POI:
	        -> localhost:8080/xy-inc/rest/pontosDeInteresse/cadastro
	        Acessado por método POST; Consome um JSON com o objeto POI a ser
	        persistido;
	        Em caso de sucesso, retorna status 201 e o JSON do objeto persistido
	        Em caso de erro ao preencher os dados, retorna status 400 e a mensagem
	        de erro
	        Em caso de erro ao conectar com o banco de dados, retorna status 500 e
	        a mensagem de erro 

Contato:
	danielnovato[at]gmail.c om
	