# STEAMIF

## Ferramentas necessárias 

+ Java
+ Docker

## Como rodar 

### 1. Clone o repositório

~~~
$ git clone https://github.com/adelsonsljunior/steamif.git
~~~

### 2. Entre no diretório e abra na sua IDE

~~~
$ cd steamif/
~~~

### 3. Crie o arquivo de variáveis de ambiente

Crie uma cópia do arquivo `.env.example` com o nome de `.env`.

No arquivo `.env`, coloque no campo `PG_PASSWORD` a senha que deseja para o banco de dados

### 4. Suba o container com o banco de dados

~~~
$ docker compose up 
~~~

<br>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)