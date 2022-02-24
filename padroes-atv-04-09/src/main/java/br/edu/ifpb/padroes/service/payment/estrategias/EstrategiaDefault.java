package br.edu.ifpb.padroes.service.payment.estrategias;

public class EstrategiaDefault implements EstrategiaPagamento {

	@Override
	public void doPayment() {

		System.out.println("unknown payment method");
		
	}

	
}
