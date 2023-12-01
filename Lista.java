import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Lista {

    private String tituloLista;
	private List<Card> cards;

    Formatacao fmt = new Formatacao();
    
	
    //construtor
    public Lista(String tituloLista) {
        this.tituloLista = tituloLista;
        this.cards = new ArrayList<>();
    }


    //relacionado aos cards
    public void criarCard(String tituloCard, LocalDate dataInicial, LocalDate dataEntrega, Date horaEntrega) {
        Card novoCard = new Card(tituloCard, dataInicial, dataEntrega, horaEntrega);
        cards.add(novoCard);
        System.out.println("Card '" + tituloCard + "' criado com sucesso!");
    }

    public void listarCards() {
        fmt.linha();
        DateTimeFormatter dtfData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");

        for (int i = 0; i < cards.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + cards.get(i).getTituloCard() + " => ");
            System.out.println("Data inicial: " + cards.get(i).getDataInicial().format(dtfData));
            System.out.println("Data de entrega: " + cards.get(i).getDataEntrega().format(dtfData));
            System.out.println("Hora de entrega: " + sdfHora.format(cards.get(i).getHoraEntrega()));
            fmt.linha();
        }
    }

    public void adicionarCard(Card card) {
    	cards.add(card);
    }
    
    public void removerCard(int indice) {
        if (indice >= 1 && indice < cards.size() + 1) {
            cards.remove(indice - 1);
            System.out.println("Card removido com sucesso!");
        } else {
            System.out.println("Índice inválido. Card não removido.");
        }
    }

  
    //getters and setters
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
