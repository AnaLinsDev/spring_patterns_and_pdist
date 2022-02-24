package br.edu.ifpb.padroes.service.payment.estrategias;

public class EstrategiaPayPal implements EstrategiaPagamento {

	@Override
	public void doPayment() {

		System.out.println("Do paypal payment!");
		
	}

	
}
