package br.edu.ifpb.padroes.storewebv3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.padroes.storewebv3.command.Command;
import br.edu.ifpb.padroes.storewebv3.command.CommandCreateOrder;
import br.edu.ifpb.padroes.storewebv3.command.CommandFila;
import br.edu.ifpb.padroes.storewebv3.domain.Order;

@Service
public class OrderService {

	CommandFila commandFila;
	CommandCreateOrder commandCreate;
	
	public void createOrder(Order order) {
		commandCreate = new CommandCreateOrder(order);
		commandFila.add(commandCreate);
		
		this.efetivar();
	}

	private void efetivar() {
		List<Command> fila = commandFila.get_history();
		for ( Command c : fila ) {
			c.execute();
			commandFila.rem();
		}
		
	}

}
