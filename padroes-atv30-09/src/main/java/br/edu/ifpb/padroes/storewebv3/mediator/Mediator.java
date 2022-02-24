package br.edu.ifpb.padroes.storewebv3.mediator;

import br.edu.ifpb.padroes.storewebv3.domain.Order;

public interface Mediator {
    void createOrder(Order order);
}
