/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author e@Constraint(validatedBy = UniqueUsernameValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })wawuye
 */
@Constraint(validatedBy = UniqueAssetCodeValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface UniqueAssetCode{
    public String message() default "There is already asset with this asset code!";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default{};

}
