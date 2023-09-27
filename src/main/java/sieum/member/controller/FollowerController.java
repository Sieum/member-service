package sieum.member.controller;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sieum.member.MessageOnly;
import sieum.member.message.FollowMessage;
import sieum.member.request.FollowRequestDto;
import sieum.member.service.FollowerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follower")
public class FollowerController {

	private final FollowerService followerService;

	/**
	 * Follow API
	 * @param uuid  Follow를 요청한 대상의 UUID
	 * @param followRequestDto Follow를 받은 대상의 UUID
	 * @return
	 */
	@PostMapping("/follow")
	public ResponseEntity<MessageOnly> follow(@RequestHeader(name = "uuid") String uuid, @RequestBody @Valid FollowRequestDto followRequestDto){
		followerService.follow(UUID.fromString(uuid), UUID.fromString(followRequestDto.getFollowerId()));
		return new ResponseEntity<>(new MessageOnly(FollowMessage.SUCCESS_FOLLOW.getMessage()), HttpStatus.OK);
	}
	@PostMapping("/unfollow")
	public ResponseEntity<MessageOnly> unfollow(@RequestHeader(name = "uuid") String uuid, @RequestBody @Valid FollowRequestDto followRequestDto){
		followerService.follow(UUID.fromString(uuid), UUID.fromString(followRequestDto.getFollowerId()));
		return new ResponseEntity<>(new MessageOnly(FollowMessage.SUCCESS_UNFOLLOW.getMessage()), HttpStatus.OK);
	}

}
