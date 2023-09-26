package sieum.member.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.data.annotation.CreatedDate;

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

	@CreatedDate
	@Column(name="follow_created_date",nullable = false)
	private LocalDateTime createdDate;

}
