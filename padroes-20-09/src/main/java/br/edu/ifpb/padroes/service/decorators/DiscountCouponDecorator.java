package br.edu.ifpb.padroes.service.decorators;

import br.edu.ifpb.padroes.domain.Pizza;

public class DiscountCouponDecorator extends PizzaOrderDecorator {

	public DiscountCouponDecorator(OrderAdicionais source) {
		super(source);
	}

	@Override
	public void orderPizza(Pizza pizza) {

		Float totalPrice = pizza.getPrice();
		
        totalPrice *= 0.25f; // 25% discount
        pizza.setPrice(totalPrice);
        
		super.orderPizza(pizza);	
		
	}
}
