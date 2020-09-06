package com.kocfinans.creditscore.rest;

import com.kocfinans.creditscore.service.CreditScoreCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("credit-score")
public class CreditScoreCalculationController {

    @Autowired
    CreditScoreCalculationService creditScoreCalculation;

    @PostMapping("/calculate/{nationalIdentityId}")
    public long creditScoreCalculate(@PathVariable String nationalIdentityId){
       return creditScoreCalculation.creditScoreCalculate(nationalIdentityId);
    }



}
