package com.tubanurbalci.demoschool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data // getter setter equals hashcode toString constructor at compile time.
@Entity
//@Table(name = "roles")
public class Roles extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
//    @Column(name = "role_id")
  private int roleId;

  private String roleName;

}
