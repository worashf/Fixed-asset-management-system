/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.util;

import com.zema.isms.service.EmployeeService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ewawuye
 */
@Component
public class ServiceUtils {
    private static  ServiceUtils instance;
    @Autowired
    private EmployeeService empService;
    // post constract
    @PostConstruct
    public void fillInstance()
    {
        instance=this;
    }
    // static method
    public static EmployeeService getEmployeeService(){
        return instance.empService;
    } 
    
}
