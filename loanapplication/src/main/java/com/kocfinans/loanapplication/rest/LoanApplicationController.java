package com.kocfinans.loanapplication.rest;

import com.kocfinans.loanapplication.dto.LoanApplicationRequest;
import com.kocfinans.loanapplication.dto.LoanApplicationResponse;
import com.kocfinans.loanapplication.dto.LoanApplicationResponseStatus;
import com.kocfinans.loanapplication.entity.User;
import com.kocfinans.loanapplication.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/loan")
public class LoanApplicationController {

    private static final Logger logger = LogManager.getLogger(LoanApplicationController.class);

    @Autowired
    CalculationService calculationService;

    @PostMapping("/calculate-loan-score")
    public LoanApplicationResponse calculateLoanScore(@RequestBody LoanApplicationRequest loanApplicationRequest){
        LoanApplicationResponse loanApplicationResponse = calculationService.calculateLoanScore(loanApplicationRequest);
        logger.info("Kredi başvurusu sorgulama başarılı..");
        return loanApplicationResponse;
    }
}
