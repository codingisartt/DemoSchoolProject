package com.tubanurbalci.demoschool.repository;

import com.tubanurbalci.demoschool.model.Contact;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

  List<Contact> findByStatus(String status);

  //    @Query("SELECT c FROM Contact c WHERE c.status = ?1") // veya  c.status = :status    JPQL query
  @Query(value = "SELECT * FROM contact_msg c WHERE c.status = :status", nativeQuery = true)
  Page<Contact> findByStatusWithQuery(@Param("status") String state, Pageable pageable);


  @Transactional
  @Modifying
  @Query("UPDATE Contact c SET c.status = ?1 WHERE c.contactId = ?2")
  int updateStatusById(String status, int id);

  Page<Contact> findOpenMsgs(@Param("status") String status, Pageable pageable);

  @Transactional
  @Modifying
  int updateMsgStatus(String status, int id);

  @Query(nativeQuery = true)
  Page<Contact> findOpenMsgsNative(@Param("status") String status, Pageable pageable);

  @Transactional
  @Modifying
  @Query(nativeQuery = true)
  int updateMsgStatusNative(String status, int id);

}
