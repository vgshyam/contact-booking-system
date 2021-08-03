package com.contact.book.api;

import static com.contact.book.util.MessageUtil.ADDED;
import static com.contact.book.util.MessageUtil.DELETED;
import static com.contact.book.util.MessageUtil.UPDATED;
import static com.contact.book.util.Route.ADD;
import static com.contact.book.util.Route.ALL;
import static com.contact.book.util.Route.BASE_URL;
import static com.contact.book.util.Route.CONTACT;
import static com.contact.book.util.Route.DELETE;
import static com.contact.book.util.Route.MAKE_FAVORITE;
import static com.contact.book.util.Route.UPDATE;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contact.book.api.bean.ContactBean;
import com.contact.book.api.bean.FavoriteBean;
import com.contact.book.data.model.Contact;
import com.contact.book.security.exception.GeneralException;
import com.contact.book.service.ContactService;
import com.contact.book.util.response.ResponseUtil;

@RestController()
@RequestMapping(value = BASE_URL + CONTACT)
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping(value = ADD)
	public ResponseEntity<?> add(@RequestBody ContactBean bean) throws GeneralException {
		contactService.addContact(bean);
		return ResponseUtil.success(ADDED);
	}

	@PutMapping(value = UPDATE)
	public ResponseEntity<?> edit(@RequestBody Contact contact) throws GeneralException {
		contactService.updateContact(contact);
		return ResponseUtil.success(UPDATED);
	}

	@DeleteMapping(value = DELETE + "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) throws GeneralException {
		contactService.deleteContact(id);
		return ResponseUtil.success(DELETED);
	}

	@GetMapping(value = ALL)
	public ResponseEntity<?> all(@RequestParam HashMap<String, String> input) {
		String search = input.get("search");
		if(search!= null)			
			return ResponseUtil.success(contactService.searchContacts(search));
		else
			return ResponseUtil.success(contactService.allContacts());

	}

	@PostMapping(value = MAKE_FAVORITE)
	public ResponseEntity<?> FAVO(@RequestBody FavoriteBean bean) {

		return ResponseUtil.success(contactService.addAndRemoteContactToFavorite(bean));

	}
}