package RedeSocial;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private List<Usuario> amigos;
    private List<String> mensagens;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        amigos = new ArrayList<>();
        mensagens = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void adicionarAmigo(Usuario amigo) {
        amigos.add(amigo);
    }

    public void removerAmigo(Usuario amigo) {
        amigos.remove(amigo);
    }

    public void receberMensagem(Usuario remetente, String mensagem) {
        String mensagemFormatada = remetente.getNome() + ": " + mensagem;
        mensagens.add(mensagemFormatada);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", amigos=" + amigos +
                ", mensagens=" + mensagens +
                '}';
    }
}