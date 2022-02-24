package br.edu.ifpb.padroes.storewebv3.command;
import java.util.Date;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.mediator.StripeApiMediator;

public class CommandCreateOrder extends Command {

	StripeApiMediator api = new StripeApiMediator();
	
	public CommandCreateOrder(Order order) {
		super(order);
	}
	
	@Override
	public boolean execute() {
		if ( order.getCreated() == null) {
			return false;
		}
		
		order.setCreated(new Date());
		api.createOrder(order);
		order.setProcessed(true);
		
		return true;
	}

}
