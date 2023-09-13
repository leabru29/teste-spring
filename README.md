# Teste Spring

Projeto Teste Spring Boot

## Descrição

Este projeto tem como finalizade apenas testar os recursos do Spring Boot.

## Tecnologias Utilizadas

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Security 6](https://docs.spring.io/spring-security/site/docs/current/reference/html5/)
- [MySQL](https://dev.mysql.com/doc/)
- [Maven](https://maven.apache.org/)

## Recursos

- [Documentação do Spring Boot](https://spring.io/projects/spring-boot)
- [Documentação do Spring Security 6](https://docs.spring.io/spring-security/site/docs/current/reference/html5/)
- [Documentação do MySQL](https://dev.mysql.com/doc/)
- [Documentação do Maven](https://maven.apache.org/)

## Pré-requisitos

Antes de iniciar, certifique-se de atender aos seguintes requisitos:

- Ter o JDK 17 instalado
- Maven instalado
- Ter MYSQL instalado.

## Configuração

Para excutar o projeto, siga os seguintes passos:

1. Clone o repositório:

   ```bash
   git clone git@github.com:leabru29/teste-spring.git


2. Acesse o diretório do projeto:

    ```bash
   cd teste-spring

3. Crie um arquivo de configuração do projeto dentro de Resources:
    ```bash
    touch src/main/resources/application.properties

4. Depois de criar o arquivo de configuração, preencha da seguinte forma:

    ```
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/seu_bd_criado
    spring.datasource.username=seu_usuario_mysql
    spring.datasource.password=sua_senha
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    #spring.jpa.show-sql: true
5. Compile o projeto com:
    ```bash
    mvn clean package && mvn clean install

6. Exceute o projeto:
    ```bash
    ./mvnw spring-boot:run


## Contribuição
Se você deseja contribuir para este projeto, siga estas etapas:

1. Faça um fork do repositório
Crie uma branch com a sua feature: 
    ```bash
    git checkout -b minha-feature

2. Faça commit das suas mudanças: 
    ```bash
    git commit -m 'Adicionar nova feature'

3. Faça push para a branch: git push origin minha-feature:
    ```bash
    Abra um pull request