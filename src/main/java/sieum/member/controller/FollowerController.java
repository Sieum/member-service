package sieum.member.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sieum.member.service.FollowerService;

@RestController
@RequiredArgsConstructor
public class FollowerController {

	private final FollowerService followerService;

}
