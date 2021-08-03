package com.contact.book.service.impl;

import static com.contact.book.util.MessageUtil.CONTACT_ADDED_IN_FAVORITE;
import static com.contact.book.util.MessageUtil.CONTACT_NOT_FOUND;
import static com.contact.book.util.MessageUtil.CONTACT_REMOVED_FROM_FAVORITE;
import static com.contact.book.util.MessageUtil.INVALID_MAIL_ADDRESS;
import static com.contact.book.util.MessageUtil.INVALID_MOBILE_NUMBER;
import static com.contact.book.util.MessageUtil.INVALID_OPERATION;
import static com.contact.book.util.MessageUtil.PASSS_AND_CURR_PASS_NOT_MATCHED;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.contact.book.api.bean.ContactBean;
import com.contact.book.api.bean.FavoriteBean;
import com.contact.book.data.model.Contact;
import com.contact.book.data.repository.ContactRepository;
import com.contact.book.security.exception.GeneralException;
import com.contact.book.service.ContactService;
import com.contact.book.util.MessageUtil;

@Component
public class ContactServiceImpl implements ContactService {

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	 private static final Pattern MOBILE_NUMBER_REGEX = Pattern.compile("^\\d{10}$");

	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public void addContact(ContactBean contactBean) {
		Contact contact = this.convertToModel(contactBean);
		this.validateInput(contact);
		contactRepo.save(contact);

	}

	

	@Override
	public void updateContact(Contact contact) {
		this.validateInput(contact);
		contactRepo.save(contact);
	}

	@Override
	public void deleteContact(Long id) {
		if (contactRepo.findById(id).isEmpty()) {
			throw new GeneralException(MessageUtil.CONTACT_NOT_FOUND);
		}
		contactRepo.deleteById(id);

	}

	@Override
	public List<Contact> allContacts() {
		return contactRepo.findAll();
	}

	@Override
	public String addAndRemoteContactToFavorite(FavoriteBean bean) {
		Optional<Contact> contactOp = contactRepo.findById(bean.getId());

		if (contactOp.isEmpty())
			throw new GeneralException(CONTACT_NOT_FOUND);

		Contact contact = contactOp.get();
		if (bean.getOperation().equalsIgnoreCase("ADD")) {
			contact.setFavorite(true);
			contactRepo.save(contact);
			return CONTACT_ADDED_IN_FAVORITE;
		} else if (bean.getOperation().equalsIgnoreCase("REMOVE")) {
			contact.setFavorite(false);
			contactRepo.save(contact);
			return CONTACT_REMOVED_FROM_FAVORITE;
		} else
			throw new GeneralException(INVALID_OPERATION);

	}

	@Override
	public List<Contact> searchContacts(String input) {
		return contactRepo.findByUserNameContainsOrFirstNameContains(input, input);
	}

	/**
	 * @param contact
	 */
	private void validateInput(Contact contact) {
		
		 Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(contact.getMail());
	     if(!matcher.find())
	    	 throw new GeneralException(INVALID_MAIL_ADDRESS);
	     matcher = MOBILE_NUMBER_REGEX.matcher(contact.getMobileNo());
	     if(!matcher.find())
	    	 throw new GeneralException(INVALID_MOBILE_NUMBER);
	}
	/**
	 * @param bean
	 * @return
	 */
	private Contact convertToModel(ContactBean bean) {
		
		if(!bean.getPassword().equals(bean.getCurrPassword()))
			 throw new GeneralException(PASSS_AND_CURR_PASS_NOT_MATCHED);
		
		return new Contact(bean.getUserName(), bean.getFirstName(),
				bean.getLastName(),bean.getMail() , bean.getMobileNo(), bean.getAddress());
	}
}
