package br.edu.ifpb.padroes.service.proxy;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;

public class PizzaClass implements  PizzaCacheInterface {

	//aqui deveriam ser feitas as requisiçoes para o banco ou api
    private List<DamenosPizza> damenos = new ArrayList<DamenosPizza>();
    private List<PizzaHotPizza> pizzaHot = new ArrayList<PizzaHotPizza>();

    
    @Override
    public List<DamenosPizza> getPizzasDamenos() {
    	for (int i = 0; i < 2; i++) {
    		  DamenosPizza pizza = new DamenosPizza();
    		  pizza.setName("padrao" + i);
    		  pizza.setCost((float) i * 10);
    		  damenos.add(pizza);
    		}
        return damenos;
    }

    @Override
    public List<PizzaHotPizza> getPizzasPizzaHot() {
    	for (int i = 0; i < 2; i++) {
  		  PizzaHotPizza pizza = new PizzaHotPizza();
  		  pizza.setTopping("padrao" + i);
  		  pizza.setPrice((float) i * 10);
  		pizzaHot.add(pizza);
  		}
        return pizzaHot;
    }

}