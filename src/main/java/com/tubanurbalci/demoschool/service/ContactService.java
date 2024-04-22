package com.tubanurbalci.demoschool.service;

import com.tubanurbalci.demoschool.config.DemoSchoolProps;
import com.tubanurbalci.demoschool.constants.DemoSchoolConstants;
import com.tubanurbalci.demoschool.model.Contact;
import com.tubanurbalci.demoschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Slf4j
@Service
//@RequestScope
//@SessionScope
@ApplicationScope
// one instance in single servlet context, counter will keep incrementing, websites keep total number of visitors.
public class ContactService {

//    public int counter= 0;

  @Autowired
  private ContactRepository contactRepository;

  @Autowired
  DemoSchoolProps demoSchoolProps;

  public ContactService() {
    System.out.println("Contact Service Bean initialized.");
  }

//    private static Logger log = LoggerFactory.getLogger(ContactService.class); // @Slf4j

  public boolean saveMessageDetails(Contact contact) {
    boolean isSaved = true;
    contact.setStatus(DemoSchoolConstants.OPEN);
//        contact.setCreatedBy(DemoSchoolConstants.ANONYMOUS);
//        contact.setCreatedAt(LocalDateTime.now());
    // Need to persist the data into the DB table.
    log.info(contact.toString());
    Contact savedContact = contactRepository.save(contact);
    if (null != savedContact && savedContact.getContactId() > 0) {
      isSaved = true;
    }
    return isSaved;
  }

//    public int getCounter() {
//        return counter;
//    }
//
//    public void setCounter(int counter) {
//        this.counter = counter;
//    }

  public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir) {
//        int pageSize = 5;
    int pageSize = demoSchoolProps.getPageSize();
    if (null != demoSchoolProps.getContact() && null != demoSchoolProps.getContact().get("pageSize")) {
      pageSize = Integer.parseInt(demoSchoolProps.getContact().get("pageSize").trim());
    }
    Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
        sortDir.equals("asc") ? Sort.by(sortField).ascending()
            : Sort.by(sortField).descending());
    Page<Contact> msgPage = contactRepository.findByStatusWithQuery(
        DemoSchoolConstants.OPEN, pageable);
    return msgPage;
  }

  public boolean updateMsgStatus(int contactId) {
    boolean isUpdated = false;
//        Optional<Contact> contact = contactRepository.findById(contactId);
//        contact.ifPresent(contact1 -> {
//                contact1.setStatus(DemoSchoolConstants.CLOSE);
////                contact1.setUpdatedBy(updatedBy);
////                contact1.setUpdatedAt(LocalDateTime.now());
//    });
//        Contact updatedContact = contactRepository.save(contact.get());
////        int result = contactRepository.updateMsgStatus(contactId,DemoSchoolConstants.CLOSE, updatedBy);
//        if (null != contactRepository && updatedContact.getUpdatedBy()!= null){ //result > 0
//            isUpdated = true;
//        }
    int rows = contactRepository.updateMsgStatusNative(DemoSchoolConstants.CLOSE, contactId);
    if (rows > 0) {
      isUpdated = true;
    }
    return isUpdated;
  }
}
