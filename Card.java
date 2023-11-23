package projetoTrelloPOO;

import java.util.Date;
import java.time.LocalDate;

public class Card {

    private String tituloCard;
	private LocalDate dataInicial;
	private LocalDate dataEntrega;
	private Date horaEntrega;
	
	public Card(String tituloCard, LocalDate dataInicial, LocalDate dataEntrega, Date horaEntrega ) {
			
		this.tituloCard = tituloCard;
		this.dataInicial = dataInicial;
		this.dataEntrega = dataEntrega;
		this.horaEntrega = horaEntrega;
	}
	
	
	public String getTituloCard() {
		return tituloCard;
	}
	public void setNomeCard(String tituloCard) {
		this.tituloCard = tituloCard;
	}
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public Date getHoraEntrega() {
		return horaEntrega;
	}
	public void setHoraEntrega(Date horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
	


    
}
