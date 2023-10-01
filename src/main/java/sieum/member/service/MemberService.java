package sieum.member.service;

import sieum.member.dto.response.MemberProfileResponseDto;
import sieum.member.dto.request.MemberProfileUpdateRequestDto;

import java.util.UUID;

public interface MemberService {
    public MemberProfileResponseDto getMemberProfile(UUID uuid);

    public MemberProfileResponseDto updateMemberProfile(UUID uuid, MemberProfileUpdateRequestDto memberProfileUpdateRequestDto);

    public void deleteUser(UUID uuid);

}
