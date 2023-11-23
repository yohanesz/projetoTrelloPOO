package projetoTrelloPOO;

import java.util.ArrayList;
import java.util.List;

public class Quadro {

    private String tituloQuadro;
	private List<Lista> listas;
	
	public Quadro(String tituloQuadro) {
		this.tituloQuadro = tituloQuadro;
		this.listas = new ArrayList<>();
	}
	
	public void adicionarLista(Lista lista) {
		listas.add(lista);
	}	
	
	public void removerLista(int indice) {
		if (indice >= 1 && indice < listas.size()) {
			listas.remove(indice - 1);
	    } else {
	        System.out.println("Índice inválido");
	    }
	 }
	
	
	public String getTituloQuadro() {
		return tituloQuadro;
	}
	public void setTituloQuadro(String tituloQuadro) {
		this.tituloQuadro = tituloQuadro;
	}
	public List<Lista> getListas() {
		return listas;
	}
	public void setListas(List<Lista> listas) {
		this.listas = listas;
	}
	
	
    
}
