package br.edu.ifpb.padroes.service.decorators;

import java.util.List;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.domain.Pizza;

public class PizzaOrderDecorator implements OrderAdicionais  {

    private OrderAdicionais wrappee;

    PizzaOrderDecorator(OrderAdicionais source) {
        this.wrappee = source;
    }
    
	@Override
	public void orderPizza(Pizza pizza) {
		wrappee.orderPizza(pizza);	
	}


}
