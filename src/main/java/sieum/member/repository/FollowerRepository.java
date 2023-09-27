package sieum.member.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import sieum.member.entity.Follower;
import sieum.member.entity.FollowerId;
import sieum.member.entity.Member;

public interface FollowerRepository extends JpaRepository<Follower, UUID> {
	public int countByFollowerAndFollowee(Member follower,Member followee);
}
