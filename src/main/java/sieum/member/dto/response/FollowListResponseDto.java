package sieum.member.dto.response;

import java.util.UUID;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sieum.member.entity.Follower;
import sieum.member.entity.Member;

@Builder(access= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FollowListResponseDto {
	private UUID id;
	private String nickname;
	private String profileImageUrl;
	private String profileMusicUri;
	private String albumImageUrl;
	private String albumArtist;
	private String albumTitle;

	public static FollowListResponseDto of(Member member){
		return FollowListResponseDto.builder()
			.id(member.getId())
			.nickname(member.getNickname())
			.profileImageUrl(member.getProfileImageUrl())
			.profileMusicUri(member.getProfileMusicUri())
			.albumImageUrl(member.getAlbumImageUrl())
			.albumArtist(member.getAlbumArtist())
			.albumTitle(member.getAlbumTitle())
			.build();
	}
}
