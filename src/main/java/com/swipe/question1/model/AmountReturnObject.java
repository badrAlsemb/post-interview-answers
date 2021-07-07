/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swipe.question1.model;

import lombok.Data;

/**
 *
 * @author Ianm
 */

@Data
public class AmountReturnObject {
    
    int id;
    
    double inputPrincipal;
    double mpesaCharges;
    double companyCharges;
    double localBankTransferCharges;
    double intlBankToLocalBankCharges;
    double paypalToOuterChannelsCharges;
    double amountToBeLoaded;
    double exchangeRate;
}
