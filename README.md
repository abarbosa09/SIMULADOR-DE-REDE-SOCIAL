# SIMULADOR-DE-REDE-SOCIAL

Este projeto simula uma rede social simples com funcionalidades básicas de cadastro de usuários, login, adição e remoção de amigos, envio de mensagens e listagem de amigos.

## Funcionalidades

### `RedeSocial`
- **Cadastro de Usuário:** Permite criar um novo usuário com nome, e-mail e senha.
- **Login:** Permite fazer login com um usuário existente.
- **Adicionar Amigo:** Adiciona um amigo à lista de amigos do usuário logado.
- **Listar Amigos:** Mostra a lista de amigos do usuário logado.
- **Remover Amigo:** Remove um amigo da lista de amigos do usuário logado.
- **Enviar Mensagem:** Envia uma mensagem para um amigo na lista de contatos.
- **Logout:** Encerra a sessão do usuário logado.


### `TelaInicialGUI`
A classe `TelaInicialGUI` oferece uma tela inicial com a opção de iniciar a rede social. Ao clicar em "Iniciar", abre a `RedeSocialGUI`.
### `RedeSocialGUI`
Essa classe representa a interação por meio de uma interface gráfica (Swing). Oferece funcionalidades semelhantes à `RedeSocial` por meio de botões e pop-ups.

### Como Usar:

Acesse ao aplicativo pela primeira interface, e clique em Iniciar, logo após cadastre os usuarios que utilizarão o aplicativo.
Faça login com email e senha, faça a adição e remoção de amigos atraves dos emails cadastrados dos outros usuarios.
Ao clicar em Listar amigos o aplicativo te demonstra todos os amigos adicionados no sistema.
Você pode enviar uma mensagem para seu amigo utilizando o email do amigo adicionado.
Para sair basta clicar em Logout e começar de novo.









