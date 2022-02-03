/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swipe.question1.service;

import com.swipe.question1.model.AmountObject;
import com.swipe.question1.model.AmountReturnObject;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ianm
 */

@Service
public class WithExchangeRateService {
    
    
    public AmountReturnObject doCalculate(AmountObject inputObject){
        AmountReturnObject calculatedReturnObject = new AmountReturnObject();
        
        //this is the amount entered
        double inputPrincipal = inputObject.getAmount();
        System.out.println("InputPrincipal: "+ inputPrincipal);
        
        
        calculatedReturnObject.setInputPrincipal(inputPrincipal);
        
        //append charges in reverse
        calculatedReturnObject.setMpesaCharges(22.0);
        inputPrincipal += 22.0;
        
        //add company charges
        calculatedReturnObject.setCompanyCharges((inputPrincipal * 2) / 98);
        inputPrincipal += (inputPrincipal * 2) / 98;
        
        calculatedReturnObject.setLocalBankTransferCharges(40.0);
        inputPrincipal += 40.0;
        
        
        calculatedReturnObject.setIntlBankToLocalBankCharges((inputPrincipal*1.5)/98.5);
        inputPrincipal += (inputPrincipal*1.5)/98.5;
        
        
        calculatedReturnObject.setPaypalToOuterChannelsCharges((inputPrincipal*3)/97);
        inputPrincipal+= (inputPrincipal*3)/97;
        
        calculatedReturnObject.setAmountToBeLoaded(inputPrincipal);
        
        //add exchange rate
        calculatedReturnObject.setExchangeRate(100);
        
        return calculatedReturnObject;
    }  
}
