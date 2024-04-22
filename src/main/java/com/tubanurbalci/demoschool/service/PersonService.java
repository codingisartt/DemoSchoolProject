package com.tubanurbalci.demoschool.service;

import com.tubanurbalci.demoschool.constants.DemoSchoolConstants;
import com.tubanurbalci.demoschool.model.Person;
import com.tubanurbalci.demoschool.model.Roles;
import com.tubanurbalci.demoschool.repository.PersonRepository;
import com.tubanurbalci.demoschool.repository.RolesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonService {

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private RolesRepository rolesRepository;

  @Autowired
  private PasswordEncoder passwordEncoder; // We use interface name instead of implementation name. (BCryptPasswordEncoder in ProjectSecurityConfig)

  public boolean createNewPerson(Person person) {
    boolean isSaved = false;
    Roles role = rolesRepository.getByRoleName(DemoSchoolConstants.ADMIN);
    person.setRoles(role);
    person.setPwd(passwordEncoder.encode(person.getPwd()));
    person = personRepository.save(person);
    if (null != person && person.getPersonId() > 0) {
      isSaved = true;
    }
    return isSaved;
  }
}
