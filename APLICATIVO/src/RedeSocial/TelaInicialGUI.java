import RedeSocial.RedeSocialGUI;
import RedeSocial.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TelaInicialGUI {
    private Map<String, Usuario> usuarios;
    private Usuario usuarioAtual;
    private JFrame frame;
    private JPanel panel;

    private RedeSocialGUI redeSocial;

    public TelaInicialGUI() {
        usuarios = new HashMap<>();
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Rede Social");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = createWelcomePanel();
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createWelcomePanel() {
        JPanel welcomePanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Bem-vindo à Rede Social!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton iniciarButton = new JButton("Iniciar");
        Color verdeAgua = new Color(127, 255, 212);
        iniciarButton.setBackground(verdeAgua);
        iniciarButton.addActionListener(e -> {
            frame.getContentPane().removeAll(); // Remove o painel de boas-vindas
            RedeSocialGUI redeSocialGUI = new RedeSocialGUI();
            frame.add(panel);
            frame.pack();
        });

        welcomePanel.add(welcomeLabel, BorderLayout.NORTH);
        welcomePanel.add(iniciarButton, BorderLayout.CENTER);
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        return welcomePanel;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(30, 30, 30, 30);


        return panel;
    }

    public static void main(String[] args) {
        new TelaInicialGUI();
    }
}
