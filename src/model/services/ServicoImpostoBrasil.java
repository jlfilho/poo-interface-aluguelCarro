package model.services;

public class ServicoImpostoBrasil implements ServicoImposto {

	@Override
	public double imposto(double valor) {
		if (valor <= 100.00) {
			return valor * 0.20;
		} else {
			return valor * 0.15;
		}
	}
	
}
