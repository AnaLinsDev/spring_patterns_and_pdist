package br.edu.ifpb.padroes.service.order;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.domain.OrderStatusEnum;
import br.edu.ifpb.padroes.service.log.LogHandler;
import br.edu.ifpb.padroes.service.log.LogService;
import br.edu.ifpb.padroes.service.payment.PaymentService;
import br.edu.ifpb.padroes.service.mail.EmailNotification;

public class OrderManager {

    public OrderManager(Order order) {
        this.order = order;
    }

    private Order order = new Order(); // Irá iniciar com o enum IN_PROGRESS

    private EmailNotification emailNotification = new EmailNotification();

    private PaymentService paymentService = new PaymentService();

    private LogService logService = new LogService(new LogHandler(LogHandler.LogHandlerType.FILE));

    public void payOrder(PaymentService.PaymentType paymentType) {
        try {
            paymentService.doPayment(paymentType);
            
            order.setStatus(OrderStatusEnum.PAYMENT_SUCCESS);
            
            emailNotification.sendMailNotification(String.format("Order %d completed successfully", order.getId()));
            
            logService.info("payment finished");
            
        } catch (Exception e) {
            logService.error("payment refused");
            
            order.setStatus(OrderStatusEnum.PAYMENT_REFUSED);
            
            emailNotification.sendMailNotification(String.format("Order %d refused", order.getId()));
        }
    }

    public void cancelOrder() {
        order.setStatus(OrderStatusEnum.CANCELED);
        
        emailNotification.sendMailNotification(String.format("Order %d canceled", order.getId()));
        
        logService.debug(String.format("order %d canceled", order.getId()));
    }

}
