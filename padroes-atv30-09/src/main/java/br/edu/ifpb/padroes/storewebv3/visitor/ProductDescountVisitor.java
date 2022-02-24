package br.edu.ifpb.padroes.storewebv3.visitor;

import br.edu.ifpb.padroes.storewebv3.domain.Product;

public class ProductDescountVisitor implements Visitor{

	@Override
	public Product visitLivros(Product p) {
		p.setPrice((long) (p.getPrice() * 0.4));
		
		System.out.print("Desconto especial adicionado !!!");
		
		return p;
	}

	@Override
	public Product visitEletronicos(Product p) {
		// TODO Auto-generated method stub
		return p;
	}

}
