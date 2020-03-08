package com.example.democlient.services;

import com.example.democlient.model.Account;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AccountTester {
    RestTemplate restTemplate = new RestTemplate();
    final String uri = "http://rest-client-rest11.192.168.42.59.nip.io/client/";
    //minishift: final String uri = "http://test-app-test00.192.168.42.137.nip.io/api/";

    public void doAddAccountsTests(int numberOfRequests) {
        System.out.println("addAccounts");
        for (int i = 10000; i < numberOfRequests + 10000; i++) {
            List<Account> result = restTemplate.getForObject(uri + "addAccount/?iban=" + i, List.class);
        }
    }
    public void doUpdateAccountsTests(int numberOfRequests) {
        System.out.println("updateAccounts");
        for(int i = 10000;i<numberOfRequests+10000;i++){
            List<Account> result = restTemplate.getForObject(uri+"updateAccount/?iban="+i, List.class);
        }
    }
    public void doFindAccountsTests(int numberOfRequests) {
        System.out.println("findAccountByIbans");
        for(int i = 10000;i<numberOfRequests+10000;i++){
            Account result = restTemplate.getForObject(uri+"findAccountByIban/?iban="+i, Account.class);
        }
    }
    public void doRemoveAccountsTests(int numberOfRequests) {
        System.out.println("removeAccounts");
        for(int i = 10000;i<numberOfRequests+10000;i++){
            List<Account> result = restTemplate.getForObject(uri+"removeAccount/?iban="+i, List.class);
        }
    }

    public void doCycleTests(int numberOfRequests){
        doAddAccountsTests(numberOfRequests);
        doUpdateAccountsTests(numberOfRequests);
        doFindAccountsTests(numberOfRequests);
        doRemoveAccountsTests(numberOfRequests);
    }
}
