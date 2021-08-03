package com.contact.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contact.book.api.bean.ContactBean;
import com.contact.book.api.bean.FavoriteBean;
import com.contact.book.data.model.Contact;

@Service
public interface ContactService {

	/**
	 * @param contact
	 * @return
	 */
	void addContact(ContactBean bean);

	/**
	 * @param contact
	 */
	void updateContact(Contact contact);

	/**
	 * @param id
	 */
	void deleteContact(Long id);

	/**
	 * @return
	 */
	List<Contact> allContacts();

	/**
	 * @param bean
	 */
	String addAndRemoteContactToFavorite(FavoriteBean bean);

	/**
	 * @return
	 */
	List<Contact> searchContacts(String input);

}
