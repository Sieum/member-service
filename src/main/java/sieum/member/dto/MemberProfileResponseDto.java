package sieum.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sieum.member.entity.Member;

import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberProfileResponseDto {
    private String spotifyId;
    private String profileMusicUri;
    private String nickname;
    private String profileImageUrl;
    private String albumImageUrl;
    private String albumArtist;
    private String albumTitle;
    private Map<String, String> hashtags;

    public MemberProfileResponseDto toMemberProfileResponseDto(Member member){
        return MemberProfileResponseDto.builder()
                .spotifyId(member.getSpotifyUserId())
                .profileMusicUri(member.getProfileMusicUri())
                .nickname(member.getNickname())
                .profileImageUrl(member.getProfileImageUrl())
                .albumImageUrl(member.getAlbumImageUrl())
                .albumArtist(member.getAlbumArtist())
                .albumTitle(member.getAlbumTitle())
                .hashtags(member.getHashtags())
                .build();
    }
}
