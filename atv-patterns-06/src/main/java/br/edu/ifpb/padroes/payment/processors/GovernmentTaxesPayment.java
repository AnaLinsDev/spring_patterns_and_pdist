package br.edu.ifpb.padroes.payment.processors;

import br.edu.ifpb.padroes.domain.Property;
import br.edu.ifpb.padroes.payment.PaymentProcessor;

public class GovernmentTaxesPayment extends PaymentProcessor {
    @Override
    public void process(Property property) {
        double governmentTaxes = property.getPrice()*0.05;
        System.out.println(String.format("Pay %f for government taxes", governmentTaxes));
    }
}

