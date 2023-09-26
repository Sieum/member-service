package sieum.member.exception.message;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum FollowerExceptionMessage {
	ALREADY_FOLLOW("이미 팔로우하셨습니다.", HttpStatus.BAD_REQUEST);

	private final String errorMessage;
	private final HttpStatus errorCode;


	private FollowerExceptionMessage(String errorMessage, HttpStatus errorCode) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
}
