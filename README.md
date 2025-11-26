# 🌐 Spring Boot Dash Application

Bem-vindo ao **SpringBoot-DashApplication**! 🚀
Este é um projeto simples, porém completo, desenvolvido para fins de **aprendizado**, **portfólio** e **demonstração prática** de uma aplicação web com **Spring Boot**, **Thymeleaf** e **MySQL**.

---

## 📌 Sobre o projeto

A aplicação permite:

* 👤 **Cadastro de usuários**
* 🔐 **Login usando formulário HTML + Spring Controller**
* 📄 **Listagem de usuários cadastrados**
* 🛢 **Integração com banco de dados MySQL/MariaDB**
* 🎨 **Interface simples com HTML + CSS**
* 🧩 **Arquitetura MVC com Camadas Controller → Service → Repository**

É um excelente exemplo de aplicação CRUD mínima para demonstrar conhecimentos de desenvolvimento backend Java.

---

## 🛠 Tecnologias Utilizadas

* ☕ **Java 21**
* 🌱 **Spring Boot**

  * Spring Web
  * Spring Data JPA
  * Thymeleaf
* 🐬 **MySQL/MariaDB**
* 🛠 **Maven**
* 🎨 **HTML + CSS**
* 🔗 **Thymeleaf**

---

## 📂 Funcionalidades

### 🔐 Login

Página de login simples que valida credenciais enviadas pelo formulário.

### 🧾 Cadastro de usuários

Interface para inserir novos usuários no sistema.

### 📋 Consulta de usuários

Tabela responsiva listando todos os usuários cadastrados com Thymeleaf.

### 📁 Arquitetura

```
Controller → Service → Repository → Entity
```

---

## 🗄 Estrutura da Aplicação

* `PageController` → controla navegação e páginas
* `UsrController` → endpoints de cadastro e login
* `UsrService` → regras de negócio
* `UsrRepository` → interface JPA conectando ao MySQL
* `Usuario` → entidade persistida no banco

---

## 🧪 Como rodar o projeto

1. Clone o repositório

   ```bash
   git clone git@github.com:marcusv614/SpringBoot-DashApplication.git
   ```

2. Configure o `application.properties` com seu MySQL:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/applogin
   spring.datasource.username=root
   spring.datasource.password=suasenha
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Execute o projeto:

   ```bash
   mvn spring-boot:run
   ```

4. Acesse no navegador:
   👉 **[http://localhost:8080/login](http://localhost:8080/login)**

---

## 🧑‍💻 Autor

**Marcus Vinícius**
Desenvolvedor iniciante apaixonado por backend, Java e Spring Boot.
💼 Construindo portfólio — um projeto por vez!

---

