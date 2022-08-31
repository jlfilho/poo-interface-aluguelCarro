package model.services;

public class ServicoImpostoUS implements ServicoImposto{

	@Override
	public double imposto(double valor) {
		return valor * 0.05;
	}

}
