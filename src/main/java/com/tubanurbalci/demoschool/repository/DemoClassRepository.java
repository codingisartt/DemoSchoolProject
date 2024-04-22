package com.tubanurbalci.demoschool.repository;

import com.tubanurbalci.demoschool.model.DemoClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoClassRepository extends JpaRepository<DemoClass, Integer> {


}
