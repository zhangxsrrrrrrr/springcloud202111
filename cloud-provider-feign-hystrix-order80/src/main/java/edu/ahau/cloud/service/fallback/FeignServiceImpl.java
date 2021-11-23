package edu.ahau.cloud.service.fallback;

import edu.ahau.cloud.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-21 2:26
 */
@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public String timeOutAction(Integer id) {
        return "timeOutAction fallback";
    }

    @Override
    public String okAction(Integer id) {
        return "okaction fallback.....";
    }
}
