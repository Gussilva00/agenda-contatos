# 📋 Passo a Passo — Agenda de Contatos (Spring Boot)

## ✅ PRÉ-REQUISITOS (instale antes de começar)

1. **Java 17+**
   - Baixe em: https://adoptium.net
   - Após instalar, teste no terminal: `java -version`

2. **Maven** (gerenciador de dependências)
   - Já vem incluso no projeto (arquivo `mvnw`)
   - Não precisa instalar separado

3. **IDE recomendada: IntelliJ IDEA Community (gratuita)**
   - Baixe em: https://www.jetbrains.com/idea/download
   - Ou use o VS Code com extensão "Extension Pack for Java"

---

## 🚀 PASSO 1 — Abrir o projeto na IDE

### No IntelliJ IDEA:
1. Abra o IntelliJ
2. Clique em **"Open"**
3. Navegue até a pasta **agenda-contatos** (extraída do ZIP)
4. Clique em **OK**
5. Aguarde carregar (pode demorar alguns minutos na primeira vez)

### No VS Code:
1. Abra o VS Code
2. Vá em **File > Open Folder**
3. Selecione a pasta **agenda-contatos**

---

## 🚀 PASSO 2 — Baixar as dependências

Após abrir o projeto, a IDE vai baixar as dependências automaticamente.

Se não baixar, abra o terminal dentro da IDE e execute:
```
./mvnw dependency:resolve
```
(No Windows: `mvnw.cmd dependency:resolve`)

---

## 🚀 PASSO 3 — Rodar o projeto

### Na IDE:
- Abra o arquivo `AgendaApplication.java`
- Clique no botão ▶️ **Run** (ou pressione Shift+F10 no IntelliJ)

### No terminal:
```
./mvnw spring-boot:run
```
(No Windows: `mvnw.cmd spring-boot:run`)

Você verá no console a mensagem:
```
Started AgendaApplication in X.XXX seconds
```

---

## 🚀 PASSO 4 — Acessar o sistema

Abra o navegador e acesse:
```
http://localhost:8080/contatos
```

Pronto! O sistema estará funcionando! 🎉

---

## 📁 ESTRUTURA DO PROJETO (para entender o que é cada arquivo)

```
agenda-contatos/
├── src/main/java/com/agenda/
│   ├── AgendaApplication.java      ← Ponto de entrada do sistema
│   ├── model/
│   │   └── Contato.java            ← Representa um contato no banco
│   ├── repository/
│   │   └── ContatoRepository.java  ← Acesso ao banco de dados
│   ├── controller/
│   │   └── ContatoController.java  ← Regras e rotas do sistema
├── src/main/resources/
│   ├── templates/
│   │   ├── lista.html              ← Tela de listagem de contatos
│   │   └── formulario.html         ← Tela de cadastro/edição
│   └── application.properties     ← Configurações do banco
└── pom.xml                         ← Dependências do projeto
```

---

## 📝 AS 4 HISTÓRIAS DE USUÁRIO IMPLEMENTADAS

| # | História | Como acessar |
|---|----------|--------------|
| 1 | Cadastrar contato | Clique em "+ Novo Contato" |
| 2 | Listar contatos | Página inicial `/contatos` |
| 3 | Editar contato | Clique em "Editar" na lista |
| 4 | Excluir contato | Clique em "Excluir" na lista |

---

## ❓ PROBLEMAS COMUNS

**Erro: "Java not found"**
→ Instale o Java 17: https://adoptium.net

**Porta 8080 ocupada**
→ Adicione no `application.properties`: `server.port=8081`
→ Acesse: http://localhost:8081/contatos

**Projeto não compila**
→ Verifique se o Java 17 está instalado
→ No IntelliJ: File > Project Structure > SDK > selecione Java 17

---

## 🗃️ BANCO DE DADOS

O projeto usa **H2** (banco em memória — não precisa instalar nada!).
Os dados são apagados ao reiniciar o sistema (normal para desenvolvimento).

Para visualizar o banco, acesse:
```
http://localhost:8080/h2-console
```
- JDBC URL: `jdbc:h2:mem:agendadb`
- User: `sa`
- Password: (deixe em branco)

---

Qualquer dúvida, volte a conversar com o Claude! 💪
