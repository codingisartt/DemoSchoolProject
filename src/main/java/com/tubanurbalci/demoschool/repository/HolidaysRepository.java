package com.tubanurbalci.demoschool.repository;

import com.tubanurbalci.demoschool.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {

}