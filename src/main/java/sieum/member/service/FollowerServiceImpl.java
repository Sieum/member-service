package sieum.member.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sieum.member.repository.FollowerRepository;

@RequiredArgsConstructor
@Service
public class FollowerServiceImpl implements FollowerService{
	private final FollowerRepository followerRepository;

}
