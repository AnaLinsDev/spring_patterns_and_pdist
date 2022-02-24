package br.edu.ifpb.padroes.domain;

public interface OrderStatusInterface {
	
	OrderStatusEnum setStatus(OrderStatusEnum enumState);

	OrderStatusInterface getStatus();

}
