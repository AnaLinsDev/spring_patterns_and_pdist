package br.edu.ifpb.padroes.payment.processors;

import br.edu.ifpb.padroes.domain.Property;
import br.edu.ifpb.padroes.payment.PaymentProcessor;

public class PropertyPayment extends PaymentProcessor {
    @Override
    public void process(Property property) {
        double propertyDeed = property.getPrice();
        System.out.println(String.format("Pay %f for the property", propertyDeed));
    }
}

