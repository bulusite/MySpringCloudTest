package cn.brust.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "fallback paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "fallback paymentInfo_Timeout";
    }
}
