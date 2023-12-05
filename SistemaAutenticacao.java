
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SistemaAutenticacao {

    
    private List<Usuario> users = new ArrayList<>();
    private Usuario userLogado;


    //Referentes ao usuario:
    public void registrarUsuario(String nome, String senha) {
        Usuario novoUsuario = new Usuario(nome, senha);
        users.add(novoUsuario);
    }

    public boolean autenticarUsuario(String nome, String senha) {
        Usuario usuario = encontrarUsuario(nome);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            userLogado = usuario;
            return true;
        }
        return false;
    }

    private Usuario encontrarUsuario(String nome) {
        for (Usuario usuario : users) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }

    

      
    //

    //referente aos quadros: 
    public void criarQuadro(String nomeQuadro) {
        if (userLogado != null) {
            Quadro novoQuadro = new Quadro(nomeQuadro);
            userLogado.adicionarQuadro(novoQuadro);
        } else {
            System.out.println("Nenhum usuário logado. Faça o login antes de criar um quadro.");
        }
    }
    
    public Quadro getQuadroPorIndiceUsuario(int indice) {
        return userLogado.getQuadroPorIndice(indice);
    }

    public void listarQuadrosDoUsuario() {
        if (userLogado != null) {
            userLogado.listarQuadros();
        } else {
            System.out.println("Nenhum usuário logado. Faça o login para listar quadros.");
        }
    }

    public void excluirQuadroDoUsuario(int indice) {
        limparConsole();
        userLogado.removerQuadro(indice);
    }
    

    // getters and setters: 
    public void setQuadroAtual(Quadro quadroSelecionado) {
        Quadro.setQuadroAtual(quadroSelecionado);
    }
    
    public Quadro getQuadroAtual() {
        return Quadro.getQuadroAtual();
    }
    

    //método para limpar o console
    public void limparConsole() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }
}