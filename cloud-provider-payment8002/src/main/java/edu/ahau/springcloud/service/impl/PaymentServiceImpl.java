package edu.ahau.springcloud.service.impl;

import edu.ahau.springcloud.dao.PaymentDao;
import edu.ahau.springcloud.entity.Payment;
import edu.ahau.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangxuna
 * @date 2021-11-09 13:11
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao dao;
    @Override
    public int createPay(Payment payment) {
        return dao.createPay(payment);
    }

    @Override
    public Payment getPaymentById(int idPay) {
        return dao.getPaymentById(idPay);
    }
}
