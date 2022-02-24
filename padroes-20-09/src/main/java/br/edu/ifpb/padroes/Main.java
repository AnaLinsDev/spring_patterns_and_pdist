package br.edu.ifpb.padroes;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.PizzaShopPizza;
import br.edu.ifpb.padroes.service.PizzaShopService;
import br.edu.ifpb.padroes.service.decorators.DiscountCouponDecorator;
import br.edu.ifpb.padroes.service.decorators.ExtraCheeseDecorator;
import br.edu.ifpb.padroes.service.decorators.PizzaOrderDecorator;
import br.edu.ifpb.padroes.service.decorators.StuffedCrustDecorator;

public class Main {

    public static void main(String[] args) {

    	// na versão original, o panpizza estava false !
        PizzaOrderDecorator pizzaShopDecorator = 
	        	new DiscountCouponDecorator(
						new ExtraCheeseDecorator(
								new StuffedCrustDecorator(
										 new PizzaShopService())));
        
        PizzaShopService pizzaShopService = new PizzaShopService();
        
        System.out.println("Pizzas - menu");
        
        System.out.println("TODAS :");
        
        for (Pizza pizza : pizzaShopService.getPizzas()) {
            System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getPrice()));
        }
        
        System.out.println("PIZZA HOT :");
        
        for (PizzaHotPizza pizza : pizzaShopService.getPizzasPizzaHot()) {
            System.out.println(String.format("%s - %.2f", pizza.getTopping(), pizza.getPrice()));
        }
        
        System.out.println("DOMENOS :");
        
        for (DamenosPizza pizza : pizzaShopService.getPizzasDamenos()) {
            System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getCost()));
        }

        Pizza pizza = new PizzaShopPizza("pepperoni", 55.0f);
        
        System.out.println("PIZZA ORDER :");
        
        pizzaShopDecorator.orderPizza(pizza); 
        pizzaShopService.orderPizza(pizza);

    }

}
