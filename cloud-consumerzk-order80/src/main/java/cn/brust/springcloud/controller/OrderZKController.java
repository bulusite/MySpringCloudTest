package cn.brust.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderZKController {
    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/paymentInfo")
    public String paymentInfo(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment",String.class);
    }
}
