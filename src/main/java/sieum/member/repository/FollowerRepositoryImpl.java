package sieum.member.repository;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import sieum.member.entity.Member;
import sieum.member.entity.QFollower;
import sieum.member.entity.QMember;

@Repository
public class FollowerRepositoryImpl implements FollowerRepositoryCustom{
	private final JPAQueryFactory queryFactory;

	public FollowerRepositoryImpl(EntityManager entityManager) {
		this.queryFactory = new JPAQueryFactory(entityManager);
	}

	@Override
	public List<Member> findFolloweeList(UUID followerId, Pageable pageable) {
		QMember member= QMember.member;
		QFollower follower=QFollower.follower1;
		return queryFactory.select(member)
			.from(member).join(follower).on(member.id.eq(follower.followee))
			.where(follower.follower.eq(followerId))
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch();
	}
}
