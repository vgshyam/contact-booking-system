package com.contact.book.util.response;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.contact.book.util.response.Response.ResponseBuilder;


public class ResponseUtil {

	public static ResponseEntity<?> success(String data) {
		ResponseBuilder<String> builder = new ResponseBuilder<>();
		builder.status(ResponseStatus.SUCCESS).statusCode(HttpStatus.OK.value()).type(ResponseType.STRING).data(data);
		return ResponseEntity.ok().body(builder.build());
	}

	public static ResponseEntity<?> success(String data, Integer statusCode) {
		ResponseBuilder<String> builder = new ResponseBuilder<>();
		builder.status(ResponseStatus.SUCCESS).statusCode(statusCode).type(ResponseType.STRING).data(data);
		return ResponseEntity.ok().body(builder.build());
	}

	public static ResponseEntity<?> success(Collection<Object> data) {
		ResponseBuilder<Collection<Object>> builder = new ResponseBuilder<>();
		builder.status(ResponseStatus.SUCCESS).statusCode(HttpStatus.OK.value()).type(ResponseType.LIST).data(data);
		return ResponseEntity.ok().body(builder.build());
	}

	public static ResponseEntity<?> success(Collection<Object> data, Integer statusCode) {
		ResponseBuilder<Collection<Object>> builder = new ResponseBuilder<>();
		builder.status(ResponseStatus.SUCCESS).statusCode(statusCode).type(ResponseType.LIST).data(data);
		return ResponseEntity.ok().body(builder.build());
	}

	public static ResponseEntity<?> success(Object data, Integer statusCode) {
		ResponseBuilder<Object> builder = new ResponseBuilder<>();
		builder.status(ResponseStatus.SUCCESS).statusCode(statusCode).type(ResponseType.OBJECT).data(data);
		return ResponseEntity.ok().body(builder.build());
	}

	public static ResponseEntity<?> success(Object data) {
		ResponseBuilder<Object> builder = new ResponseBuilder<>();
		builder.status(ResponseStatus.SUCCESS).statusCode(HttpStatus.OK.value()).type(ResponseType.OBJECT).data(data);
		return ResponseEntity.ok().body(builder.build());
	}

	public static ResponseEntity<?> failure(String message, Integer statusCode) {
		ResponseBuilder<Object> builder = new ResponseBuilder<>();
		builder.status(ResponseStatus.FAIL).statusCode(statusCode).type(ResponseType.STRING).message(message);
		return ResponseEntity.ok().body(builder.build());
	}
}
