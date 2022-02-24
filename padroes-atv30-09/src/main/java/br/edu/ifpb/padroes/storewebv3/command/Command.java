package br.edu.ifpb.padroes.storewebv3.command;

import br.edu.ifpb.padroes.storewebv3.domain.Order;

public abstract class Command {
	
    public Order order;

    Command(Order order) {
        this.order = order;
    }
    
    public abstract boolean execute();

}
