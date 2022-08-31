package model.services;

public class ServicoImpostoCanada implements ServicoImposto {

	@Override
	public double imposto(double valor) {
		return valor * 0.03;
	}

}
