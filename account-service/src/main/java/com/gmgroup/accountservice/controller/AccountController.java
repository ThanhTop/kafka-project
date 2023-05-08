package com.gmgroup.accountservice.controller;

import com.gmgroup.accountservice.model.AccountDTO;
import com.gmgroup.accountservice.model.MessageDTO;
import com.gmgroup.accountservice.model.StatisticDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/new")
    public AccountDTO create(@RequestBody AccountDTO accountDTO) {
        StatisticDTO stat = new StatisticDTO("Account " + accountDTO.getEmail() + " is created", new Date());

        MessageDTO message = new MessageDTO();
        message.setTo(accountDTO.getEmail());
        message.setToName(accountDTO.getName());
        message.setSubject("welcome to jmaster.io");
        message.setContent("jmaster is online learning platform");

        kafkaTemplate.send("notification", message);
        kafkaTemplate.send("statistic", stat);

        return accountDTO;
    }
}
