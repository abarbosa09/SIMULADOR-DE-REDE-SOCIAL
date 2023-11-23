package RedeSocial;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RedeSocial {
    private Map<String, Usuario> usuarios;
    private Usuario usuarioAtual;
    private Scanner scanner;

    public RedeSocial() {
        usuarios = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void cadastrarUsuario() {
        System.out.println("Digite o nome do usuário:");
        String nome = scanner.nextLine();
        System.out.println("Digite o e-mail do usuário:");
        String email = scanner.nextLine();
        System.out.println("Digite a senha do usuário:");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email, senha);
        usuarios.put(email, usuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void fazerLogin() {
        System.out.println("Digite o e-mail do usuário:");
        String email = scanner.nextLine();
        System.out.println("Digite a senha do usuário:");
        String senha = scanner.nextLine();

        Usuario usuario = usuarios.get(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            usuarioAtual = usuario;
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("E-mail ou senha incorretos!");
        }
    }

    public void adicionarAmigo() {
        System.out.println("Digite o e-mail do amigo:");
        String email = scanner.nextLine();

        Usuario amigo = usuarios.get(email);
        if (amigo != null) {
            usuarioAtual.adicionarAmigo(amigo);
            System.out.println("Amigo adicionado com sucesso!");
        } else {
            System.out.println("Amigo não encontrado!");
        }
    }

    public void listarAmigos() {
        List<Usuario> amigos = usuarioAtual.getAmigos();
        if (amigos.isEmpty()) {
            System.out.println("Você não tem amigos ainda!");
        } else {
            System.out.println("Lista de amigos:");
            for (Usuario amigo : amigos) {
                System.out.println(amigo.getNome() + " - " + amigo.getEmail());
            }
        }
    }

    public void excluirAmigo() {
        System.out.println("Digite o e-mail do amigo a ser excluído:");
        String email = scanner.nextLine();

        Usuario amigo = usuarios.get(email);
        if (amigo != null && usuarioAtual.getAmigos().contains(amigo)) {
            usuarioAtual.removerAmigo(amigo);
            System.out.println("Amigo removido com sucesso!");
        } else {
            System.out.println("Amigo não encontrado na sua lista de amigos!");
        }
    }

    public void removerAmigo() {
        System.out.println("Digite o e-mail do amigo a ser removido:");
        String email = scanner.nextLine();

        Usuario amigo = usuarios.get(email);
        if (amigo != null) {
            usuarioAtual.removerAmigo(amigo);
            System.out.println("Amigo removido com sucesso!");
        } else {
            System.out.println("Amigo não encontrado!");
        }
    }

    public void enviarMensagem() {
        System.out.println("Digite o e-mail do amigo para enviar a mensagem:");
        String email = scanner.nextLine();

        Usuario amigo = usuarios.get(email);
        if (amigo != null) {
            System.out.println("Digite a mensagem:");
            String mensagem = scanner.nextLine();

            amigo.receberMensagem(usuarioAtual, mensagem);
            System.out.println("Mensagem enviada com sucesso!");
        } else {
            System.out.println("Amigo não encontrado!");
        }
    }

    public void logout() {
        usuarioAtual = null;
        System.out.println("Logout realizado com sucesso!");
    }

    public void executar() {
        boolean sair = false;

        while (!sair) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Adicionar amigo");
            System.out.println("4 - Listar amigos");
            System.out.println("5 - Remover amigo");
            System.out.println("6 - Enviar mensagem");
            System.out.println("7 - Logout");
            System.out.println("8 - Excluir amigo");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    fazerLogin();
                    break;
                case 3:
                    adicionarAmigo();
                    break;
                case 4:
                    listarAmigos();
                    break;
                case 5:
                    removerAmigo();
                    break;
                case 6:
                    enviarMensagem();
                    break;
                case 7:
                    logout();
                    break;
                case 8:
                    excluirAmigo();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        RedeSocial redeSocial = new RedeSocial();
        redeSocial.executar();
    }
}