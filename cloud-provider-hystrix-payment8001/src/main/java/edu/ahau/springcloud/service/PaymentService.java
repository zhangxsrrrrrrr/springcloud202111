package edu.ahau.springcloud.service;

import edu.ahau.springcloud.entity.Payment;

/**
 * @author zhangxuna
 * @date 2021-11-09 13:10
 */
public interface PaymentService {
    public  int createPay( Payment payment);

    public Payment getPaymentById( int idPay);
}
