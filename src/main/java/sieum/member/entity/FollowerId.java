package sieum.member.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
@Getter
public class FollowerId implements Serializable {
	@Column(name = "follow_member_id", nullable = false)
	private UUID followeeId;

	@Column(name = "member_id", nullable = false)
	private UUID followerId;

	@Override
	public boolean equals(Object obj) {
		if(obj== null || getClass() != obj.getClass()) {
			return false;
		}
		FollowerId other = (FollowerId) obj;
		if(other.followerId.equals(followerId) && other.followeeId.equals(followeeId)) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return Objects.hash(getFolloweeId(), getFollowerId());
	}

}
