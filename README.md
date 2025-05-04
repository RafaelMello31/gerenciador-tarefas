# Gerenciador de Tarefas - API REST + Front-end

Projeto desenvolvido para o desafio de estágio na T-Systems, utilizando Java e Spring Boot.

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Banco de dados H2 (em memória)
- Maven
- Postman (para testes de API)
- HTML5, CSS3 e JavaScript 

## 📚 Funcionalidades

A API permite:

- **Criar** uma nova tarefa (`POST /tarefas`)
- **Listar** todas as tarefas (`GET /tarefas`)
- **Atualizar** uma tarefa existente (`PUT /tarefas/{id}`)
- **Excluir** uma tarefa (`DELETE /tarefas/{id}`)

Cada tarefa contém:
- `id` (gerado automaticamente)
- `titulo` (obrigatório)
- `descricao` (opcional)
- `status` (verdadeiro ou falso: indica se a tarefa foi concluída)
- `dataCriacao` (gerado automaticamente pelo sistema)

## ⚙️ Como rodar o projeto localmente

1. **Clone o repositório:**
   
git clone https://github.com/RafaelMello31/gerenciador-tarefas.git

2. **Abra o projeto no IntelliJ IDEA**

3. **Execute o projeto:**

- Localize a classe GerenciadorTarefasApplication.java.
- Clique com o botão direito nela e selecione Run.

4. **Acesse a API:**

O servidor será iniciado em: http://localhost:8080

## 🛠️ Configurações de Banco de Dados (H2)
O projeto utiliza o banco de dados H2 em memória para facilitar os testes.

Acesse o console do H2 em: http://localhost:8080/h2-console

Configurações:
- JDBC URL:	jdbc:h2:mem:gerenciador_tarefas
- User Name:	sa
- Password:	vazio

## 🧹 Validação de Entradas

**Para garantir a integridade dos dados:**

O campo titulo é obrigatório e limitado a 50 caracteres.

O campo descricao é limitado a 500 caracteres.

O campo status não pode ser nulo.

A API retorna erros amigáveis caso as regras de validação sejam violadas.

## 🎨 Interface Web (Front-end)
Foi desenvolvido também um front-end simples para interação com a API, utilizando HTML5, CSS3 e JavaScript puro.

**Funcionalidades do front-end:**

- Formulário para adicionar novas tarefas.
- Exibição da lista de tarefas cadastradas.
- Botões para editar ou excluir tarefas existentes.
- Layout responsivo.

**Como acessar a Interface Web:**
- Após rodar o projeto, acesse no navegador: http://localhost:8080/formulario_gerenciador.html
