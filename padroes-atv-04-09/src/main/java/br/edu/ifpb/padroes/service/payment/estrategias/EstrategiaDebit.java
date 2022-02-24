package br.edu.ifpb.padroes.service.payment.estrategias;

public class EstrategiaDebit implements EstrategiaPagamento {

	@Override
	public void doPayment() {

		System.out.println("Do debit payment!");
		
	}

	
}
