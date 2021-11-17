package edu.ahau.springcloud.dao;

import edu.ahau.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zhangxuna
 * @date 2021-11-09 12:58
 */
@Mapper
@Repository
public interface PaymentDao {
    public  int createPay(@Param("payment") Payment payment);

    public Payment getPaymentById(@Param("id") int idPay);
}
