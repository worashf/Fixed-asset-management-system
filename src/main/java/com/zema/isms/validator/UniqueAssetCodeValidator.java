/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.validator;

import com.zema.isms.service.AssetService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ewawuye
 */

@Component
public class UniqueAssetCodeValidator implements ConstraintValidator< UniqueAssetCode, String>{
    
@Autowired
private AssetService assetservice;
    @Override
    public void initialize(UniqueAssetCode a) {
       
    }

    @Override
    public boolean isValid(String assetcode, ConstraintValidatorContext cvc) {
       return !assetservice.isAssetCodeInDb(assetcode);
    }
    
}
