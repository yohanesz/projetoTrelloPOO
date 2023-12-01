import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
	private String senha;
	private List<Quadro> quadros;


	// construtor 
	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
		this.quadros = new ArrayList<>();
	}
	

	// referente aos quadros
	public void adicionarQuadro(Quadro quadro) {
		quadros.add(quadro);
		System.out.println("Quadro '" + quadro.getTituloQuadro() + "' adicionado ao usuário '" + nome + "'.");
	}
	
	public void listarQuadros() {
		int i = 1;
		System.out.println("QUADROS");
		System.out.println("");
		for (Quadro quadro : quadros) {
			System.out.println("[" + i++ + "] - " + quadro.getTituloQuadro());
		}
		
	}

	public Quadro getQuadroPorIndice(int indice) {
        if (indice >= 1 && indice < quadros.size() + 1) {
            return quadros.get(indice - 1);
        } else {
            return null;
        }
    }
	
	public void removerQuadro(int indice) {
		if (indice >= 1 && indice < quadros.size() + 1) {
			quadros.remove(indice - 1);
	    } else {
			System.out.println("Índice inválido");
	    }
	}
	

	//getters and setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Quadro> getQuadros() {
		return quadros;
	}

	public void setQuadros(List<Quadro> quadros) {
		this.quadros = quadros;
	}
    
}
