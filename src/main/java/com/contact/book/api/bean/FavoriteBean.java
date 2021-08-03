package com.contact.book.api.bean;

public class FavoriteBean {

	private Long id;
	private String Operation;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return Operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		Operation = operation;
	}

}
