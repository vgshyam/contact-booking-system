package com.contact.book.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.book.data.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
//OrLastNameContainsOrMailContains
	List<Contact> findByUserNameContainsOrFirstNameContains(String userName,String firstName);
}
