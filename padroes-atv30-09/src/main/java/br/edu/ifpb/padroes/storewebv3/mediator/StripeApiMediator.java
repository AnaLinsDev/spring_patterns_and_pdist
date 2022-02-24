package br.edu.ifpb.padroes.storewebv3.mediator;

import br.edu.ifpb.padroes.storewebv3.config.StoreConfigurationProperties;
import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.payment.StripeApi;

public class StripeApiMediator implements Mediator {

	StripeApi api = new StripeApi(new StoreConfigurationProperties());

	@Override
	public void createOrder(Order order) {
		api.createOrder(order);
	}

}
