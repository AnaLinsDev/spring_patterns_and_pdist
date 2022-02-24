package br.edu.ifpb.padroes.service.proxy;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.service.PizzaShopService;


public class PizzaCacheProxy implements  PizzaCacheInterface {
	
    private PizzaCacheInterface pizzaInt;
    private List<DamenosPizza> damenos = new ArrayList<DamenosPizza>();
    private List<PizzaHotPizza> pizzaHot = new ArrayList<PizzaHotPizza>();

    
	public PizzaCacheProxy() {
		super();
		this.pizzaInt = new PizzaClass();
	}

	@Override
	public List<DamenosPizza> getPizzasDamenos() {
        if (damenos.isEmpty()) {
        	damenos = pizzaInt.getPizzasDamenos();
        } else {
            System.out.println("Já está no cache.");
        }
        return damenos;
	}

	@Override
	public List<PizzaHotPizza> getPizzasPizzaHot() {
        if (pizzaHot.isEmpty()) {
        	pizzaHot = pizzaInt.getPizzasPizzaHot();
        } else {
            System.out.println("Já está no cache.");
        }
        return pizzaHot;
	}
	

    public void reset() {
    	pizzaHot.clear();
    	damenos.clear();
    }

}
