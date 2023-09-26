package sieum.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sieum.member.entity.Follower;
import sieum.member.entity.FollowerId;

public interface FollowerRepository extends JpaRepository<Follower, FollowerId> {

}
