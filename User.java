package projetoTrelloPOO;

import java.util.List;

public class User {

    private String nome;
	private String senha;
	private List <Quadro> quadros;
	
	
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
