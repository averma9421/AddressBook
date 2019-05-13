package org.app.addressbook.repository;

import org.app.addressbook.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Long> {

}
