package br.edu.ifpb.padroes.storewebv3.visitor;

import br.edu.ifpb.padroes.storewebv3.domain.Product;

public interface Visitor {

	Product visitLivros(Product p);
	
	Product visitEletronicos(Product p);


	
}
