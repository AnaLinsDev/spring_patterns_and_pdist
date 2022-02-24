package br.edu.ifpb.padroes.service.decorators;

import br.edu.ifpb.padroes.domain.Pizza;

public class PanPizzaDecorator  extends PizzaOrderDecorator {

	PanPizzaDecorator(OrderAdicionais source) {
		super(source);
	}

	@Override
	public void orderPizza(Pizza pizza) {

		Float totalPrice = pizza.getPrice();
		String name = pizza.getName();
		
        totalPrice *= 1.15f; // 15% increase
        name += " (pan pizza)";
        pizza.setPrice(totalPrice);
        pizza.setName(name);
        
		super.orderPizza(pizza);	
		
	}
	
}
