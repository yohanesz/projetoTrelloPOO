package projetoTrelloPOO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws ParseException {

        LocalDate dt = LocalDate.now(); 
		DateTimeFormatter dtfDataBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		//setando data e hora
		LocalDate dataEntrega = LocalDate.of(2023, 11, 20);
		Date horaEntrega = new SimpleDateFormat("HH:mm:ss").parse("12:30:00");	
		
		
		
		// criar primeiro o card
		Card primeiroCard = new Card("Entrega do trabalho", dt, dataEntrega, horaEntrega);
		
		
		// imprime a data formatada 
		DateTimeFormatter dataInicial = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(primeiroCard.getDataEntrega().format(dataInicial));
		
		
	
//		System.out.println("Título: " + primeiroCard.getTituloCard());
//		System.out.println("Data inicial: " + primeiroCard.getDataInicial());
//		System.out.println("Data de entrega: " + primeiroCard.getDataEntrega());
//		System.out.println("Hora de entrega: " + primeiroCard.getHoraEntrega());
		
		//adicionando o card dentro de uma lista
		Lista listaTeste = new Lista("listaDeTeste");
		listaTeste.adicionarCard(primeiroCard);
		
		//adicionando a lista dentro de um quadro
		Quadro quadroTeste = new Quadro("quadroDeTeste");
		quadroTeste.adicionarLista(listaTeste);
		
		
	    for (Card card : listaTeste.getCards()) {
	    	
	    	System.out.println("Título: " + card.getTituloCard());
	        System.out.println("Data de Entrega: " + card.getDataEntrega());
	        System.out.println("---");
	        
	    }
		
        
    }
}