package cn.brust.springcloud.controller;

import cn.brust.springcloud.entities.CommonResult;
import cn.brust.springcloud.entities.Payment;
import cn.brust.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int resulet = paymentService.create(payment);
        if (resulet > 0) {
            return new CommonResult(200, "插入成功"+serverPort);
        } else {
            return new CommonResult(500, "插入失败"+serverPort);
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功"+serverPort, payment);
        } else {
            return new CommonResult(500, "查询失败"+serverPort);
        }
    }

    @GetMapping("/payment/lb")
    public String paymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
