package sieum.member.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		log.debug("error message : {}",e.getMessage());
		ErrorResponse errorResponse= ErrorResponse.builder().
			errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).
			errorMessage(e.getMessage()).build();
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
