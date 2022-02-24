package br.edu.ifpb.padroes.service.payment.estrategias;

public class EstrategiaBillet implements EstrategiaPagamento {

	@Override
	public void doPayment() {

		System.out.println("Do billet payment!");
		
	}

	
}
