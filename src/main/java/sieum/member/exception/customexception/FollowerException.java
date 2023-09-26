package sieum.member.exception.customexception;

import org.springframework.http.HttpStatus;

import sieum.member.exception.BaseException;

public class FollowerException extends BaseException {
	public FollowerException(HttpStatus httpStatus, String message) {
		super(httpStatus, message);
	}
}
