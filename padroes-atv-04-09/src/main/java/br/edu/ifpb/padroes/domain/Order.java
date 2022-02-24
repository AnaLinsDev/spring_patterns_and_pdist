package br.edu.ifpb.padroes.domain;

import java.time.Instant;
import java.util.List;


public class Order {

    private Long id;
    private Customer customer;
    private Instant creationDate;
    private Restaurant restaurant;
    private List<OrderItem> orderItemList;
    
    private OrderStatusInterface currentState;
   
    
    public Order() {
    	this.currentState = OrderStatusEnum.IN_PROGRESS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public OrderStatusInterface getStatus() {
    	return this.currentState.getStatus();
    }

    public void setStatus(OrderStatusEnum status) {
        this.currentState = currentState.setStatus(status);
    }
}
