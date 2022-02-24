package br.edu.ifpb.padroes.domain.adapter;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.domain.Pizza;

public class DamenosAdapter implements Pizza {

    private DamenosPizza damenosPizza;

    public DamenosAdapter(DamenosPizza damenosPizza) {
        this.damenosPizza = damenosPizza;
    }

    @Override
    public Float getPrice() {
        return damenosPizza.getCost();
    }

    @Override
    public String getName() {
        return damenosPizza.getName();
    }

	@Override
	public void setPrice(Float price) {
		damenosPizza.setCost(price);
		
	}

	@Override
	public void setName(String name) {
		damenosPizza.setName(name);
		
	}
}
