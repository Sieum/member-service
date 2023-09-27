package sieum.member.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		memberRepository.findMemberByIdAndIsDeletedFalse(followeeId).orElseThrow(()->
			new FollowerException(FollowerExceptionMessage.NOT_FOUND_MEMBER));
		if(isFollower(followerId, followeeId)){
			throw new FollowerException(FollowerExceptionMessage.ALREADY_FOLLOW);
		}
		Follower follow = Follower.builder()
						.follower(followerId)
						.followee(followeeId)
						.build();
		followerRepository.save(follow);
	}

	@Override
	public void unfollow(UUID followerId, UUID followeeId) {
		memberRepository.findMemberByIdAndIsDeletedFalse(followeeId).orElseThrow(()->
			new FollowerException(FollowerExceptionMessage.NOT_FOUND_MEMBER));
		Follower follower=followerRepository.findByFollowerAndFollowee(followerId, followeeId).orElseThrow(()->
			new FollowerException(FollowerExceptionMessage.NOT_FOUND_FOLLOW));

		followerRepository.delete(follower);


	}

	@Override
	public List<Member> getFolloweeList(UUID followerId, Pageable tempPageable) {
		Pageable pageable= PageRequest.of(tempPageable.getPageNumber(), 10);
		return followerRepository.findFolloweeList(followerId, pageable);
	}

	@Override
	public boolean isFollower(UUID follower, UUID followee) {
		if(followerRepository.findByFollowerAndFollowee(follower, followee).orElse(null)!=null){
			return true;
		}
		return false;
	}
}
