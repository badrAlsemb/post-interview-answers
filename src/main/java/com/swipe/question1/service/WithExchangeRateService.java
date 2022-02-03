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
    double localBankTransferCharges = 40.0;
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
        temp = getCompanyCharges(inputPrincipal);
        amountReturnObject.setCompanyCharges(temp);
        inputPrincipal += temp;
        amountReturnObject.setLocalBankTransferCharges(localBankTransferCharges);
        inputPrincipal += localBankTransferCharges;
        temp = getIntlBankToLocalBankCharges(inputPrincipal);
        amountReturnObject.setIntlBankToLocalBankCharges(temp);
        inputPrincipal += temp;
        temp = getPaypalTransferToExternalAccountsCharges(inputPrincipal);
        amountReturnObject.setPaypalToOuterChannelsCharges(temp);
        inputPrincipal+= temp;
        
        amountReturnObject.setAmountToBeLoaded(inputPrincipal);
        
        //add exchange rate
        amountReturnObject.setExchangeRate(100);
        
        return amountReturnObject;
    }
    
    //add company charges
    public double getCompanyCharges(double inputPrincipal){
        return (inputPrincipal*2)/98;
    }
    
    //add offshore bank account charges
    public double getIntlBankToLocalBankCharges(double input){
        return (input*1.5)/98.5;
    }
    
    //add charges of paypal to offshore bank
    public double getPaypalTransferToExternalAccountsCharges(double input){
        return (input*3)/97;
    }
    
    
}
