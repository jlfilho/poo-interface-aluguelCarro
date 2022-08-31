package model.services;

import java.time.Duration;

import model.entities.AluguelCarro;
import model.entities.NotaFiscal;

public class ServicoAluguel {
	
	private Double precoPorDia;
	private Double precoPorHora;
	
	private ServicoImposto servicoImposto;
	

	public ServicoAluguel(Double precoPorDia, Double precoPorHora, ServicoImposto servicoImposto) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.servicoImposto = servicoImposto;
	}
	
	public void processarNotaFiscal(AluguelCarro aluguelCarro) {
		double duracao = Duration.between(aluguelCarro.getInicio(),
				aluguelCarro.getTermino()).getSeconds() / 3600.00;
		double pagamentoBasico;
		if (duracao <= 12.0) {
			pagamentoBasico = Math.ceil(duracao) * precoPorHora;
		} else {
			pagamentoBasico = Math.ceil(duracao / 24) * precoPorDia;
		}
		
		double imposto = servicoImposto.imposto(pagamentoBasico);
		
		aluguelCarro.setNotaFiscal(new NotaFiscal(pagamentoBasico, imposto));
		
	}
	
}
