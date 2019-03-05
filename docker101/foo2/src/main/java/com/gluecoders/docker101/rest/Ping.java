package com.gluecoders.docker101.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Ping {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url}")
    private String url;

    @GetMapping(path = "/ping")
    public ResponseEntity ping(){
        System.out.println(url);
        return ResponseEntity.ok("All ok");
    }


    @GetMapping(path = "/pingother")
    public ResponseEntity pingOther(){
        try {
            String response = restTemplate.getForObject(url, String.class);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
