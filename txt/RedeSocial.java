package RedeSocial;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RedeSocialGUI {
    private Map<String, Usuario> usuarios;
    private Usuario usuarioAtual;
    private JFrame frame;
    private JPanel panel;



    public RedeSocialGUI() {
        usuarios = new HashMap<>();
        initializeUI();
    }

    private void initializeUI() {
        JFrame frame = new JFrame("Rede Social");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = createPanel();
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(30, 30, 30, 30);


        JButton cadastrarButton = new JButton("Cadastrar");
        JButton loginButton = new JButton("Login");
        JButton adicionarAmigoButton = new JButton("Adicionar Amigo");
        JButton listarAmigosButton = new JButton("Listar Amigos");
        JButton excluirAmigoButton = new JButton("Excluir Amigo");
        JButton enviarMensagemButton = new JButton("Enviar Mensagem");
        JButton logoutButton = new JButton("Logout");

        Color verde = new Color(127, 255, 212);
        cadastrarButton.setBackground(verde);
        loginButton.setBackground(verde);
        adicionarAmigoButton.setBackground(verde);
        listarAmigosButton.setBackground(verde);
        enviarMensagemButton.setBackground(verde);
        logoutButton.setBackground(verde);
        excluirAmigoButton.setBackground(verde);

        addComponent(panel, constraints, cadastrarButton, 0, 0);
        addComponent(panel, constraints, loginButton, 1, 0);
        addComponent(panel, constraints, adicionarAmigoButton, 2, 0);
        addComponent(panel, constraints, listarAmigosButton, 0, 1);
        addComponent(panel, constraints, enviarMensagemButton, 1, 1);
        addComponent(panel, constraints, logoutButton, 1, 3);
        addComponent(panel, constraints, excluirAmigoButton, 2, 1);

        cadastrarButton.addActionListener(e -> cadastrarUsuario());
        loginButton.addActionListener(e -> fazerLogin());
        adicionarAmigoButton.addActionListener(e -> adicionarAmigo());
        listarAmigosButton.addActionListener(e -> listarAmigos());
        enviarMensagemButton.addActionListener(e -> enviarMensagem());
        logoutButton.addActionListener(e -> logout());
        excluirAmigoButton.addActionListener(e -> excluirAmigo());

        return panel;
    }

    private void addComponent(JPanel panel, GridBagConstraints constraints, JComponent component, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        panel.add(component, constraints);
    }

    private void cadastrarUsuario() {

        String nome = JOptionPane.showInputDialog("Digite o nome do novo usuário:");
        String email = JOptionPane.showInputDialog("Digite o email do novo usuário:");
        String senha = JOptionPane.showInputDialog("Digite a senha do novo usuário:");

        Usuario novoUsuario = new Usuario(nome, email, senha);
        usuarios.put(email, novoUsuario);
        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        System.out.println(usuarios.toString());
    }

    private void fazerLogin() {
        String email = JOptionPane.showInputDialog("Digite o email:");
        String senha = JOptionPane.showInputDialog("Digite a senha:");

        // Lógica para fazer login
        Usuario user = usuarios.get(email);
        if(user != null){
            System.out.println("Usuário encontrado!");
            if(user.getSenha().equals(senha)){
                usuarioAtual = user;
                System.out.println("Logado!");
            }else{
                System.out.println("Errou a senha.");
            }
        }else{
            System.out.println("Não encontrou o usuário");
        }
    }

    private void listarAmigos() {
        if (usuarioAtual != null) {
            if (usuarioAtual.getAmigos().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Você não tem amigos ainda.");
            } else {
                StringBuilder amigosList = new StringBuilder("Seus amigos:\n");
                for (Usuario amigo : usuarioAtual.getAmigos()) {
                    amigosList.append(amigo.getNome()).append("\n");
                }
                JOptionPane.showMessageDialog(null, amigosList.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Faça o login primeiro!");
        }
    }

    private void excluirAmigo() {
        if (usuarioAtual != null) {
            String emailAmigo = JOptionPane.showInputDialog("Digite o email do amigo a ser excluído:");
            Usuario amigo = usuarios.get(emailAmigo);

            if (amigo != null && usuarioAtual.getAmigos().contains(amigo)) {
                usuarioAtual.removerAmigo(amigo);
                JOptionPane.showMessageDialog(null, "Amigo removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Amigo não encontrado na sua lista de amigos!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Faça o login primeiro!");
        }
    }

    private void enviarMensagem() {
        if (usuarioAtual != null) {
            String emailAmigo = JOptionPane.showInputDialog("Digite o email do amigo:");
            String mensagem = JOptionPane.showInputDialog("Digite a mensagem:");

            // Lógica para enviar mensagem
        } else {
            JOptionPane.showMessageDialog(null, "Faça o login primeiro!");
        }
    }

    private void logout() {
        usuarioAtual = null;
        JOptionPane.showMessageDialog(null, "Logout realizado com sucesso!");
    }


    private void adicionarAmigo() {
        if (usuarioAtual != null) {
            String emailAmigo = JOptionPane.showInputDialog("Digite o email do amigo que deseja adicionar:");
            Usuario amigo = usuarios.get(emailAmigo);

            if (amigo != null) {
                usuarioAtual.adicionarAmigo(amigo);
                JOptionPane.showMessageDialog(null, "Amigo adicionado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Amigo não encontrado!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Faça o login primeiro!");
        }
    }


}
