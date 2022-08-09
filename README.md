
-----SOBRE O QUE É A APLICAÇÃO----- 

Foi desenvolvida uma aplicação BACK-END que recebe uma lista de jogadores (nome) e sorteia os jogadores em 2 times.


-----AVISO----- 

Essa aplicação não precisa de BACK-END e muito menos banco de dados, só utilizei ambos a fim de treinamento.


-----OBJETIVO-----

Colocar em prática alguns dos conhecimentos que eu adquiri durante um ano e meio de estudo.


-----FUNCIONALIDADES-----

Como já dito, o Usuário passa uma lista com o nome de jogadores, o sistema monta 2 times e sorteia os jogadores nesses 2 times aleatoriamente.

Se for passado como parametro o valor yes : ( ?drawGoalKeeper=yes ) o goleiro dos 2 times vão ser sorteados também, se não tiver o parametro (drawGoalKeeper) ou (drawGoalKeeper=no) o goleiro não será sorteado.


-----VERSIONAMENTO-----

Versão do Java : 17

Versão do Spring Boot : 2.7.2


-----LINGUAGEM DE DESENVOLVIMENTO-----

JAVA

-----PRINCIPAL FRAMEWORK----- 

Spring Boot

-----DEPENDENCIAS-----

 Data JPA - > Utilizando o JPA para fazer a ponte entre o banco de dados e a aplicação -> ORM
 
 Validation -> Utilizado para proibir requisições com dados inválidos ou com um formato inválido.
 
 Web -> É uma aplicação WEB, Utilizado para receber requisições, devolver uma resposta ...
 
 H2 - > Utilizado esse banco em MEMÓRIA para fazer testes, ambiente de teste.
 
 Test -> Foram feitos testes na aplicação com JUNIT ( Testes do Service).
 
 Security -> Utilizado para fazer a segurança do sistema - > Não tem segurança configurada ainda para autenticacao e está tudo liberado, foi colocada essa dependencia para futuras possiveis alterações.
 
 SpringDoc -> Utilizado para documentar a API através dos ENDPOINTS.
 
 LomBok -> Utilizado para evitar muitas linhas de código.


-----PROGRAMAS UTILIZADOS-----

Heroku - Utilizado para deixar o projeto na nuvem.

Postman - Utilizado para fazer as requisições (CONSUMIR) a aplicação.

IntelliJ - IDE escolhida para desenvolver o projeto.

Git e GitHub - Utilizados para commitar o projeto e subir o código para a nuvem(remoto).


-----BANCO DE DADOS-----

H2 - Usado no ambiente DEFAULT.


-----INFORMAÇÕES ADICIONAIS-----


Linhas de código : 507

Classes / Arquivos implementados : 25


-----LINKS----- 

Explicação da API em vídeo no YouTube : https://www.youtube.com/watch?v=1ZztSQhWGhU

Perfil no Linkedin : https://www.linkedin.com/in/victoralmada/
