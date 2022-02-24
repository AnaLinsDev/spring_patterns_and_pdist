package br.edu.ifpb.padroes.service.decorators;

import br.edu.ifpb.padroes.domain.Pizza;

public class StuffedCrustDecorator extends PizzaOrderDecorator  {

	public StuffedCrustDecorator(OrderAdicionais source) {
		super(source);
	}
	
	@Override
	public void orderPizza(Pizza pizza) {

		Float totalPrice = pizza.getPrice();
		String name = pizza.getName();
		
        totalPrice *= 1.20f; // 20% increase
        name += " (stuffed crust)";
        pizza.setPrice(totalPrice);
        pizza.setName(name);
        
		super.orderPizza(pizza);	
		
	}

}
