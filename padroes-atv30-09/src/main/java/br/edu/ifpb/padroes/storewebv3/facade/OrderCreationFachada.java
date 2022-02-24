package br.edu.ifpb.padroes.storewebv3.facade;

import java.util.List;


import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.Product;
import br.edu.ifpb.padroes.storewebv3.repository.ProductRepository;
import br.edu.ifpb.padroes.storewebv3.service.OrderService;

public class OrderCreationFachada {

	ProductRepository repoProduct = new ProductRepository();
	
	OrderService orderService = new OrderService();
	
	
	public void criarPedido() {
		Order order = new Order();
		
		orderService.createOrder(order);
	}
	
	public List<Product> listarProdutosDisponiveis() {
		//List<Product> lista = repoProduct.getProductList();

		return repoProduct.getProductList();
		
	}
}
