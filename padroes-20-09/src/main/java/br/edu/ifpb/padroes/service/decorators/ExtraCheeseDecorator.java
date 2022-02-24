package br.edu.ifpb.padroes.service.decorators;

import br.edu.ifpb.padroes.domain.Pizza;

public class ExtraCheeseDecorator extends PizzaOrderDecorator {

	public ExtraCheeseDecorator(OrderAdicionais source) {
		super(source);
	}

	@Override
	public void orderPizza(Pizza pizza) {

		Float totalPrice = pizza.getPrice();
		String name = pizza.getName();
		
        totalPrice *= 1.10f; // 10% increase
        name += " (extra cheese)";
        pizza.setPrice(totalPrice);
        pizza.setName(name);
        
		super.orderPizza(pizza);	
		
	}
}
