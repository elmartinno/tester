package com.example.democlient.controller;

import com.example.democlient.model.Account;
import com.example.democlient.model.AccountData;
import com.example.democlient.model.Turnover;
import com.example.democlient.services.AccountTester;
import com.example.democlient.services.ServicesTester;
import com.example.democlient.services.TurnoverTestes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Service;
import java.util.List;

@RestController
@RequestMapping("tester")
public class TestClientController {
    @Autowired
    AccountTester accountTester;
    @Autowired
    TurnoverTestes turnoverTestes;
    @Autowired
    ServicesTester servicesTester;

    //http://localhost:8070/tester/accountTest?numberOfIterations=10
    @GetMapping("/accountTest")
    private void accountTest(int numberOfIterations) {
        accountTester.doCycleTests(numberOfIterations);
    }

    //localhost:8070/tester/createNumberOfTurnovers/?diffIban=10
    @GetMapping("/createNumberOfTurnovers")
    private void createNumberOfTurnovers(int diffIban,int numberOfSameIbanTurn) {
        turnoverTestes.createNumberOfTurnovers(diffIban,numberOfSameIbanTurn);
    }

    //localhost:8070/tester/callNumberOfTurnovers/?diffIban=10
    @GetMapping("/callNumberOfTurnovers")
    private void callNumberOfTurnovers(int diffIban) {
        turnoverTestes.callTurnoversByIban(diffIban);
    }

    //localhost:8070/tester/doServicesTest/?diffIban=10
    @GetMapping("/doServicesTest")
    private void doServicesTest(int diffIban) {
        servicesTester.doServiceTest(diffIban);
    }

    //localhost:8070/tester/doRemoveAccountsTests/?numberOfIterations=10
    @GetMapping("/doRemoveAccountsTests")
    private void doRemoveAccountsTests(int numberOfIterations) {
        accountTester.doRemoveAccountsTests(numberOfIterations);
    }

    //localhost:8070/tester/doAddAccountsTests/?numberOfIterations=10
    @GetMapping("/doAddAccountsTests")
    private void doAddAccountsTests(int numberOfIterations) {
        accountTester.doAddAccountsTests(numberOfIterations);
    }

    //localhost:8070/tester/doUpdateAccountsTests/?numberOfIterations=10
    @GetMapping("/doUpdateAccountsTests")
    private void doUpdateAccountsTests(int numberOfIterations) {
        accountTester.doUpdateAccountsTests(numberOfIterations);
    }

    //localhost:8070/tester/doFindAccountsTests/?numberOfIterations=10
    @GetMapping("/doFindAccountsTests")
    private void doFindAccountsTests(int numberOfIterations) {
        accountTester.doFindAccountsTests(numberOfIterations);
    }


}
