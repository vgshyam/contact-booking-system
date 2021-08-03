package com.contact.book.util.response;



public class Response<T> {

	private ResponseStatus status;
	private Integer statusCode;
	private ResponseType type;
	private T data;
	private String message;

	/**
	 * Default constructor
	 */
	public Response() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param status
	 * @param statusCode
	 * @param type
	 * @param data
	 * @param message
	 */
	public Response(ResponseStatus status, Integer statusCode, ResponseType type, T data, String message) {
		this.status = status;
		this.statusCode = statusCode;
		this.type = type;
		this.data = data;
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public ResponseStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	/**
	 * @return the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the type
	 */
	public ResponseType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ResponseType type) {
		this.type = type;
	}

	public static class ResponseBuilder<S> {
		private ResponseStatus status;
		private Integer statusCode;
		ResponseType type;
		private S data;
		private String message;

		public ResponseBuilder<S> status(ResponseStatus status) {
			this.status = status;
			return this;
		}

		public ResponseBuilder<S> statusCode(Integer statusCode) {
			this.statusCode = statusCode;
			return this;
		}

		public ResponseBuilder<S> type(ResponseType type) {
			this.type = type;
			return this;
		}

		public ResponseBuilder<S> data(S data) {
			this.data = data;
			return this;
		}

		public ResponseBuilder<S> message(String message) {
			this.message = message;
			return this;
		}

		public Response<S> build() {
			return new Response<>(this.status, this.statusCode, this.type, this.data, this.message);
		}
	}
}
