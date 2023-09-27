package sieum.member.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import sieum.member.entity.Member;

public interface FollowerRepositoryCustom {
	public List<Member> findFolloweeList(UUID followerId, Pageable pageable);

	public List<Member> findFollowerList(UUID followeeId, Pageable pageable);

}
