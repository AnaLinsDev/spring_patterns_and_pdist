package br.edu.ifpb.padroes.service.proxy;

import java.util.List;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;

public interface PizzaCacheInterface {

	List<DamenosPizza> getPizzasDamenos();
	List<PizzaHotPizza> getPizzasPizzaHot();
	
}
