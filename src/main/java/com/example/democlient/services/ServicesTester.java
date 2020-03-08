package com.example.democlient.services;

import com.example.democlient.model.AccountData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ServicesTester {
    RestTemplate restTemplate = new RestTemplate();
    final String uri = "http://localhost:8090/client/";
    //minishift: final String uri = "http://test-app-test00.192.168.42.137.nip.io/api/";

    public void doServiceTest(int numberOfRequests){
        for(int i = 10000;i<numberOfRequests+10000;i++) {
            restTemplate.getForObject(uri + "getData/?iban=" + i, AccountData.class);
        }
    }
}
