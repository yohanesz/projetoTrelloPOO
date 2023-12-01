import java.util.ArrayList;
import java.util.List;

public class Quadro {

    private String tituloQuadro;
	private List<Lista> listas;
	private static Quadro quadroAtual;

	Formatacao fmt = new Formatacao();


	//construtor
	public Quadro(String tituloQuadro) {
		this.tituloQuadro = tituloQuadro;
		this.listas = new ArrayList<>();
	}


	//referentes a lista
	public void criarLista(String tituloLista) {
		if (quadroAtual != null) {
        	Lista novaLista = new Lista(tituloLista);
        	quadroAtual.adicionarLista(novaLista);
			System.out.println("Lista '" + tituloLista + "' criada com sucesso!");
		} else {
			System.out.println("Nenhum quadro selecionado. Selecione um quadro antes de criar uma lista.");
    	}
	}

	public void listarListasDoQuadro() {
		if (listas.isEmpty()) {
			System.out.println("O quadro '" + tituloQuadro + "' não possui listas.");
			System.out.println("");
		} else {
			System.out.println("LISTAS");
			System.out.println("");
			for (int i = 1; i <= listas.size(); i++) {
				System.out.println("[" + (i) + "] - " + listas.get(i - 1).getTituloLista());
				
			}
		}
	}

	public void listarListasDoQuadroAtual() { //obter quadro atual
		Quadro quadroAtual = getQuadroAtual();
		if (quadroAtual != null) {
			quadroAtual.listarListasDoQuadro();
		} else {
			System.out.println("Nenhum quadro selecionado. Selecione um quadro antes de listar as listas.");
		}
	}
	
	public void listarListasDoQuadroAtualComCards() {
		if (quadroAtual != null) {
			fmt.linha();
			System.out.println("CARDS");
			System.out.println("");
			for (int i = 1; i <= listas.size(); i++) {
				Lista listaAtual = listas.get(i - 1);
				System.out.println("[" + i + "] - " + listaAtual.getTituloLista());
				listaAtual.listarCards();
			}
		} else {
			System.out.println("Nenhum quadro selecionado. Selecione um quadro antes de listar as listas.");
		}
	}
	
	public Lista getListaPorIndice(int indice) {
		if (indice >= 1 && indice <= listas.size()) {
			return listas.get(indice - 1);
		} else {
			return null;
		}
	}
	
	public void adicionarLista(Lista lista) {
		listas.add(lista);
	}	
	
	public void removerLista(int indice) {
		if (indice >= 1 && indice < listas.size() + 1) {
			listas.remove(indice - 1);
	    } else {
			System.out.println("Índice inválido");
	    }
	}


	//getters and setters
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
	
	public static Quadro getQuadroAtual() {
        return quadroAtual;
    }

    public static void setQuadroAtual(Quadro novoQuadroAtual) {
        quadroAtual = novoQuadroAtual;
    }
    
}
