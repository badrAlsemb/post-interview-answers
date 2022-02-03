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
    
    AmountReturnObject amountReturnObject;
    double mpesaCharge = 22.0;
    public AmountReturnObject doCalculate(AmountObject inputObject){
        double temp;
        
        //this is the amount entered
        double inputPrincipal = inputObject.getAmount();
        System.out.println("InputPrincipal: "+ inputPrincipal);
        
        //to try and save mem from different objects
        //only instantiate if non-existent
        if(amountReturnObject == null){
            amountReturnObject = new AmountReturnObject();
        }
        
        amountReturnObject.setInputPrincipal(inputPrincipal);
        //append charges in reverse
        amountReturnObject.setMpesaCharges(mpesaCharge);
        inputPrincipal += mpesaCharge;
        
        //add company charges
        amountReturnObject.setCompanyCharges((inputPrincipal * 2) / 98);
        inputPrincipal += (inputPrincipal * 2) / 98;
        
        amountReturnObject.setLocalBankTransferCharges(40.0);
        inputPrincipal += 40.0;
        
        
        amountReturnObject.setIntlBankToLocalBankCharges((inputPrincipal*1.5)/98.5);
        inputPrincipal += (inputPrincipal*1.5)/98.5;
        
        
        amountReturnObject.setPaypalToOuterChannelsCharges((input*3)/97);
        inputPrincipal+= (input*3)/97;
        
        amountReturnObject.setAmountToBeLoaded(inputPrincipal);
        
        //add exchange rate
        amountReturnObject.setExchangeRate(100);
        
        return amountReturnObject;
    }  
}
