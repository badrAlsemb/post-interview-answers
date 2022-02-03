/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swipe.question1.controller;

import com.swipe.question1.model.AmountObject;
import com.swipe.question1.model.AmountReturnObject;
import com.swipe.question1.service.WithExchangeRateService;
import com.swipe.question1.service.WithoutExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ianm
 */

@RestController
@RequestMapping("/api/withrate/")
@CrossOrigin("http://localhost:4200")
public class WithExchangeRateController {
    
    @Autowired
    WithExchangeRateService wers;
    
    @PostMapping
    public ResponseEntity createPost(@RequestBody AmountObject inputObject){
        AmountReturnObject calculateResult = wers.doCalculate(inputObject);
        return new ResponseEntity(calculateResult,HttpStatus.OK);
    }
    
}
