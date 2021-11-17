package edu.ahau.cloud.lb;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangxuna
 * @date 2021-11-16 8:40
 */
@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        // server下标
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }

    public int getAndIncrement(){
        int current = 0;
        int next = 0 ;
        do {
            // 获取当前值
            current = this.atomicInteger.get();
            // 重置
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));

        System.out.println("第几次访问 next: " + next);
        return next;
    }

}
