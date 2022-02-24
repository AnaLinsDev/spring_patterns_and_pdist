package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.DamenosServiceImpl;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosService;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotServiceImpl;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotService;
import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.adapter.DamenosAdapter;
import br.edu.ifpb.padroes.domain.adapter.PizzahotAdapter;
import br.edu.ifpb.padroes.service.decorators.OrderAdicionais;
import br.edu.ifpb.padroes.service.proxy.PizzaCacheInterface;
import br.edu.ifpb.padroes.service.proxy.PizzaCacheProxy;

import java.util.ArrayList;
import java.util.List;

public class PizzaShopService implements OrderAdicionais, PizzaCacheInterface {

    private PizzaCacheProxy pizzas;


    public PizzaShopService() {
    	 pizzas = new PizzaCacheProxy();
    }

     @Override
    public void orderPizza(Pizza pizza) {

        Float totalPrice = pizza.getPrice();
        String name = pizza.getName();

        System.out.println(String.format("New order for = %s", name));
        System.out.println(String.format("Total price = %f", totalPrice));

    }

    // TODO - implementar adapter para unificar pizzas vindas das APIs Damenos e PizzaHot num único método getPizzas()
    // TODO - public List<Pizza> getPizzas() {}

     public List<Pizza> getPizzas() {
    	 
    	 List<Pizza> listAllPizzas = new ArrayList<Pizza>();
    	 
    	 for (DamenosPizza pizza : pizzas.getPizzasDamenos()) {
    		 listAllPizzas.add(new DamenosAdapter(pizza));
    	 }
    	 
    	 for (PizzaHotPizza pizza : pizzas.getPizzasPizzaHot()) {
    		 listAllPizzas.add(new PizzahotAdapter(pizza));
    	 }

         return listAllPizzas;
     }
     
    @Override
    public List<DamenosPizza> getPizzasDamenos() {
        return pizzas.getPizzasDamenos();
    }

    @Override
    public List<PizzaHotPizza> getPizzasPizzaHot() {
        return pizzas.getPizzasPizzaHot();
    }

}
