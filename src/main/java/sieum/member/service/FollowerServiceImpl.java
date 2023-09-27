package sieum.member.service;

import java.util.UUID;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import sieum.member.entity.Follower;
import sieum.member.entity.Member;
import sieum.member.exception.customexception.FollowerException;
import sieum.member.exception.message.FollowerExceptionMessage;
import sieum.member.repository.FollowerRepository;
import sieum.member.repository.MemberRepository;

@RequiredArgsConstructor
@Service
public class FollowerServiceImpl implements FollowerService{
	private final FollowerRepository followerRepository;
	private final MemberRepository memberRepository;
	@Override
	@Transactional
	public void follow(UUID followerId, UUID followeeId) {
		Member followee=memberRepository.findMemberByIdAndIsDeletedFalse(followeeId).orElseThrow(()->new FollowerException(FollowerExceptionMessage.NOT_FOUND_MEMBER));
		Member follower=memberRepository.findMemberByIdAndIsDeletedFalse(followerId).orElse(null);
		if(isFollower(follower, followee)){
			throw new FollowerException(FollowerExceptionMessage.ALREADY_FOLLOW);
		}

		Follower follow = Follower.builder()
						.follower(follower)
						.followee(followee)
						.build();
		followerRepository.save(follow);
	}

	@Override
	public boolean isFollower(Member follower, Member followee) {
		if(followerRepository.countByFollowerAndFollowee(follower, followee)>0){
			return true;
		}
		return false;
	}
}
