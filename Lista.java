package projetoTrelloPOO;

import java.util.ArrayList;
import java.util.List;


public class Lista {

    private String tituloLista;
	private List<Card> cards;
	
    public Lista(String tituloLista) {
        this.tituloLista = tituloLista;
        this.cards = new ArrayList<>();
    }
    
    public void adicionarCard(Card card) {
    	cards.add(card);
    }
    
    public void removerCard(int indice) {
        if (indice >= 1 && indice < cards.size()) {
            cards.remove(indice - 1);
        } else {
            System.out.println("Índice inválido");
        }
    }
	
	
	
	public String getTituloLista() {
		return tituloLista;
	}
	public void setTituloLista(String tituloLista) {
		this.tituloLista = tituloLista;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
    
}
