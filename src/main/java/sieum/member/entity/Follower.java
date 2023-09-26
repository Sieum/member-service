package sieum.member.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Follower {

	@EmbeddedId
	private FollowerId followerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("followeeId")
	@JoinColumn(name = "member_id", nullable = false)
	private Member followee;


	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("followerId")
	@JoinColumn(name = "member_id", nullable = false)
	private Member follower;

}
