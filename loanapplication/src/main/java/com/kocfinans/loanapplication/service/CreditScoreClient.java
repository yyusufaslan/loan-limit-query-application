package com.kocfinans.loanapplication.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "credit-score",url = "#{'${client.credit-score-service.url}'}")
@RequestMapping("/credit-score")
public interface CreditScoreClient {

    @RequestMapping(method = RequestMethod.POST, value =   "/calculate/{nationalIdentityId}", produces = "application/json")
    long getCreditScoreByUserIdentifier(@PathVariable("nationalIdentityId") String nationalIdentityId);

}
