# Cadastro de Alunos

Este é um aplicativo simples de cadastro de alunos que utiliza um banco de dados para armazenar informações como nome e e-mail dos alunos.

## Requisitos

- Java 8 ou superior
- Banco de dados MySQL

## Configuração do Banco de Dados

1. Certifique-se de ter o MySQL instalado e em execução.
2. Crie um banco de dados chamado `cadastro_alunos`.
3. Configure as informações de conexão com o banco de dados no arquivo `db.properties`.

## Executando o Aplicativo

1. Compile o código-fonte utilizando um ambiente de desenvolvimento Java ou o seguinte comando no terminal:

javac application/Program.java
3. 2. Execute o aplicativo com o seguinte comando:
java application.Program


O aplicativo realizará as seguintes operações:

- Listará todos os cadastros de alunos existentes no banco de dados.
- Inserirá um novo aluno no banco de dados.
- Excluirá um aluno do banco de dados.
- Atualizará as informações de um aluno existente no banco de dados.

Certifique-se de ter o MySQL em execução e as configurações corretas do banco de dados antes de executar o aplicativo.

## Estrutura do Projeto

O projeto está organizado em vários pacotes, cada um com sua responsabilidade:

- `application`: Contém a classe `Program` que possui o método `main` para iniciar o aplicativo.
- `dao`: Contém a classe `DAO` que realiza as operações de acesso ao banco de dados.
- `db`: Contém as classes responsáveis pela conexão com o banco de dados e tratamento de exceções relacionadas ao banco.
- `model`: Contém a classe `Cadastro`, que representa um registro de aluno.

## Contribuição

Sinta-se à vontade para contribuir com melhorias para este projeto. Basta enviar um pull request com suas alterações.



