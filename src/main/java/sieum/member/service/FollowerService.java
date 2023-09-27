package sieum.member.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import sieum.member.entity.Member;

public interface FollowerService {
	public void follow(UUID followerId, UUID followeeId);

	public void unfollow(UUID followerId, UUID followeeId);

	public List<Member> getFolloweeList(UUID followerId, Pageable pageable);
	public boolean isFollower(UUID followerId,UUID followeeId);
}
