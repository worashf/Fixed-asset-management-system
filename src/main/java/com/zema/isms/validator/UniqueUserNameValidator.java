/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.validator;

import com.zema.isms.service.UserService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ewawuye
 */
@Component
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String>{
	@Autowired
	private UserService userService;
    @Override
    public void initialize(UniqueUserName a) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cvc) {
       
        return  !userService.isUserNameInuse(value);
        
    }
    
}
