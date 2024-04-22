package com.tubanurbalci.demoschool.repository;

import com.tubanurbalci.demoschool.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

  Roles getByRoleName(String roleName);

}
