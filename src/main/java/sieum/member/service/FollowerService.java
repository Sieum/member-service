package sieum.member.service;

import java.util.UUID;

import sieum.member.entity.Member;

public interface FollowerService {
	public void follow(UUID followerId, UUID followeeId);
	public boolean isFollower(UUID followerId,UUID followeeId);
}
