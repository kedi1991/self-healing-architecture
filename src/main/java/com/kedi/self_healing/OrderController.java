package com.kedi.self_healing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{userId}")
    public String makeOrder(@PathVariable String userId){

        String userDetail = restTemplate.getForObject("http://localhost:8080/users/" + userId, String.class);

        return "ORDER PLACED FOR USER " + userDetail;
    }
    
}