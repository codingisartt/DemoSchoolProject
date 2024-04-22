package com.tubanurbalci.demoschool.annotation;

import com.tubanurbalci.demoschool.validations.PasswordStrengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented // optional
@Constraint(validatedBy = {PasswordStrengthValidator.class})
@Target({METHOD, FIELD})
@Retention(RUNTIME) //@Repeatable(Email.List.class)
public @interface PasswordValidator {

  String message() default "Please choose a strong password";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
