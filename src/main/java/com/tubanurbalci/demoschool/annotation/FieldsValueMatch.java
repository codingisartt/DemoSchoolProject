package com.tubanurbalci.demoschool.annotation;

import com.tubanurbalci.demoschool.validations.FieldsValueMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//@Documented // optional
@Constraint(validatedBy = {FieldsValueMatchValidator.class})
@Target({TYPE})
@Retention(RUNTIME) //@Repeatable(Email.List.class)
public @interface FieldsValueMatch {

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String message() default "Fields values don't match!";

  String field();

  String fieldMatch();

  @Target({TYPE})
  @Retention(RUNTIME)
//    @Documented
  @interface List {
    FieldsValueMatch[] value();
  }

}
