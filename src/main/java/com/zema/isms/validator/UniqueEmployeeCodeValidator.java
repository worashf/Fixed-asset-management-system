/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.validator;

import com.zema.isms.service.EmployeeService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author uppert
 */
@Component
public class UniqueEmployeeCodeValidator implements ConstraintValidator<UniqueEmployeeCode, String>{

@Autowired
private EmployeeService empservice;

 @Override
    public void initialize(UniqueEmployeeCode e) {
       
    }
    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
      
         return !empservice.isEmployeeCodeInDb(code);
    }

    

   
}