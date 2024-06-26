package com.tubanurbalci.demoschool.validations;

import com.tubanurbalci.demoschool.annotation.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

  List<String> weakPasswords;

  @Override
  public void initialize(PasswordValidator constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
    weakPasswords = Arrays.asList("12345", "password", "qwerty");
  }

  @Override
  public boolean isValid(String passwordField, ConstraintValidatorContext context) {
    return passwordField != null && (!weakPasswords.contains(passwordField)); // default : false
  }

}
