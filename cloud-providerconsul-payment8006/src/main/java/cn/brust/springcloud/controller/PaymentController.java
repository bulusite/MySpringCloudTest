package cn.brust.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    String serverPort;

    @GetMapping("/payment")
    public String payement(){
        return "springcloud consul"+serverPort;
    }
}