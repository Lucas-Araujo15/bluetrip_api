## 💡 Explicação do projeto

Bluetrip é uma aplicação mobile de turismo focada em oceanos, rios e lagos. O objetivo principal é fornecer uma experiência enriquecedora para turistas e entusiastas da natureza, oferecendo informações detalhadas sobre pontos turísticos e eventos.

## 👥 Equipe

Este projeto está sendo desenvolvido pelos seguintes membros:

- RM98110 - André Rohregger Machado (2TDSPV)
- RM99565 - Erick Nathan Capito Pereira (2TDSPV)
- RM550841 - Lucas Araujo Oliveira Silva (2TDSPW)
- RM551886 - Victor Luca do Nascimento Queiroz (2TDSPV)
- RM99455 - Vinícius Martins Torres Abdala (2TDSPV)

## 💻 Tecnologias

As principais tecnologias, bibliotecas, ecossistemas e frameworks incluídos no projeto são:

- Java
- Docker
- Spring Boot
- Lombok
- Bean Validation
- H2 Database
- Spring Data JPA
- Swagger
- Spring HATEOAS
- Profiles

## 🎲 Diagrama do banco de dados

![Relational_1_page-0001](https://github.com/Lucas-Araujo15/bluetrip_api/assets/82396035/bc6150fc-612a-46f7-842d-c52b999af2cf)

## 👷 Arquitetura
![diagrama_bluetrip](https://github.com/Lucas-Araujo15/bluetrip_api/assets/82396035/6151e558-d304-4405-926c-ee646f2a4d9d)

## 🖌️ Vídeo Demonstração
[![](https://img.youtube.com/vi/VlPLWYjzv_c/0.jpg)](https://youtu.be/VlPLWYjzv_c?si=7-stVhuEgJhBblHT)

## 🖌️ Vídeo Pitch
[![](https://img.youtube.com/vi/PFT-OPEi9ig/0.jpg)](https://youtu.be/PFT-OPEi9ig?si=uF5jv1HTekA8B9wc)

## Link para o projeto no Docker Hub

https://hub.docker.com/r/lucasarauj0/bluetrip-api

### Para executar o container
```
docker run -e SPRING_PROFILES_ACTIVE=prod -p 8080:8080 lucasarauj0/bluetrip-api:latest
```

### Executando com docker-compose

Clonando o projeto
```
git clone https://github.com/Lucas-Araujo15/bluetrip_api
```

Ao realizar o clone do projeto, é necessário baixar as dependências e executar o bootJar para que assim seja possível executar o docker-compose

```
# modo background
docker-compose up -d
```
```
# sem modo background
docker-compose up
```

### Explicação detalhada

#### Versão do Compose
```yml
version: '3.8'
```
Especifica a versão do Docker Compose. A versão 3.8 é uma das versões mais recentes e oferece suporte a diversas funcionalidades.

#### Serviços
O arquivo define dois serviços: oracle-db e java-app.

##### Serviço oracle-db
```yml
oracle-db:
  image: gvenzl/oracle-xe:18.4.0-slim
  container_name: oracle-db
  ports:
    - "1521:1521"
    - "5500:5500"
  environment:
    ORACLE_RANDOM_PASSWORD: true
    APP_USER: bluetrip
    APP_USER_PASSWORD: bluetrip
  volumes:
    - oracle-data:/opt/oracle/oradata
  networks:
    - oracle
```
- image: Usa a imagem gvenzl/oracle-xe:18.4.0-slim, que é uma versão compacta do Oracle XE 18.4.0.
- container_name: Nomeia o contêiner como oracle-db.
- ports: Mapeia as portas 1521 (porta padrão do Oracle) e 5500 (porta para Enterprise Manager) do contêiner para o host.
- environment: Define variáveis de ambiente para o contêiner:
  - ORACLE_RANDOM_PASSWORD: Define que a senha do usuário SYS será gerada aleatoriamente.
  - APP_USER e APP_USER_PASSWORD: Cria um usuário de aplicação (bluetrip) com a senha bluetrip.
- volumes: Monta o volume oracle-data no diretório /opt/oracle/oradata do contêiner para persistir os dados.
- networks: Conecta o serviço à rede oracle.

##### Serviço java-app
```yml
java-app:
  build:
    context: .
    dockerfile: Dockerfile
    args:
      JAR_FILE: ./build/libs/*.jar
      DATASOURCE_URL: jdbc:oracle:thin:@//oracle-db:1521/FREEPDB1
      DATASOURCE_USERNAME: bluetrip
      DATASOURCE_PASSWORD: bluetrip
  container_name: java-app
  ports:
    - "8080:8080"
  depends_on:
    - oracle-db
  environment:
    SPRING_PROFILES_ACTIVE: prod
  networks:
    - oracle
```

- build: Define as instruções de construção da imagem Docker:
  - context: Especifica o diretório atual como contexto de construção.
  - dockerfile: Define o nome do Dockerfile a ser usado.
  - args: Passa argumentos de construção para o Dockerfile:
    - JAR_FILE: Especifica o caminho do arquivo JAR a ser usado.
    - DATASOURCE_URL, DATASOURCE_USERNAME e DATASOURCE_PASSWORD: Configurações do banco de dados Oracle.
- container_name: Nomeia o contêiner como java-app.
- ports: Mapeia a porta 8080 do contêiner para o host.
- depends_on: Define que o serviço java-app depende do oracle-db, garantindo que o banco de dados esteja ativo antes de iniciar a aplicação Java.
- environment: Define a variável de ambiente SPRING_PROFILES_ACTIVE com o valor prod para configurar o perfil ativo do Spring Boot.
- networks: Conecta o serviço à rede oracle.

#### Volume

```yml
volumes:
  oracle-data:
    driver: local
```
Define um volume chamado oracle-data usando o driver local para persistir os dados do banco de dados Oracle.

#### Networks

```yml
networks:
  oracle:
    driver: bridge
```
Define uma rede chamada oracle usando o driver bridge, permitindo a comunicação entre os serviços oracle-db e java-app.
