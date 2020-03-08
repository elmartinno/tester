package com.example.democlient.services;

import com.example.democlient.model.Account;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TurnoverTestes {

    RestTemplate restTemplate = new RestTemplate();
    final String uri = "http://localhost:8090/client/";
    //minishift: final String uri = "http://test-app-test00.192.168.42.137.nip.io/api/";

    public void createNumberOfTurnovers(int numberOfDiffIban, int numberOfTurnoversWithSameIban){
        for(int i = 10000;i<numberOfDiffIban+10000;i++){
            for(int j = 0;j<numberOfTurnoversWithSameIban;j++)
            {
                List<Account> result = restTemplate.getForObject(uri+"addTurnover/?iban="+i, List.class);
            }
        }
    }

    public void callTurnoversByIban(int numberOfDiffIbans){
        for(int i = 10000;i<numberOfDiffIbans+10000;i++){
            List<Account> result = restTemplate.getForObject(uri+"findTurnoversByIban/?iban="+i, List.class);
        }
    }
}
