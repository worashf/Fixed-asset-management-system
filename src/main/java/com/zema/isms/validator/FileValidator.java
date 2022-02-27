/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.validator;

import com.zema.isms.domain.FileBucket;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author ewawuye
 */
@Component
public class FileValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
       return FileBucket.class.isAssignableFrom(clazz);
    }

    @Override
   public void validate(Object target, Errors errors) {
       FileBucket file = (FileBucket)target;
       if(file.getFile()!=null){
           if(file.getFile().getSize()==0){
               errors.reject("file",null, "Please select a file");
           }
       }
        
    }
    
}
