package br.edu.ifpb.padroes.service.payment.estrategias;

public class EstrategiaCreditCard implements EstrategiaPagamento {

	@Override
	public void doPayment() {

		System.out.println("Do credit card payment!");
		
	}

	
}
