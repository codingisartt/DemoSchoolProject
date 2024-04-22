package com.tubanurbalci.demoschool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data // getter setter equals hashcode toString constructor at compile time.
@Entity
//@Table(name = "contact_msg")
public class Address extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private int addressId;

  @NotBlank(message = "Address1 must not be blank")
  @Size(min = 5, message = "Address1 must not be at least 5 characters long")
  private String address1;


  private String address2;

  @NotBlank(message = "City must not be blank")
  @Size(min = 5, message = "City must not be at least 5 characters long")
  private String city;

  @NotBlank(message = "State must not be blank")
  @Size(min = 5, message = "State must not be at least 5 characters long")
  private String state;

  @NotBlank(message = "Zip Code must not be blank")
  @Pattern(regexp = "(^$|[0-9]{5})", message = "Zip Code must not be at least 5 characters long")
  private String zipCode;

}
