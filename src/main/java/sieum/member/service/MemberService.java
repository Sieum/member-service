package sieum.member.service;

import sieum.member.dto.MemberProfileResponseDto;
import sieum.member.dto.MemberProfileUpdateRequestDto;

import java.util.UUID;

public interface MemberService {
    public MemberProfileResponseDto getMemberProfile(UUID uuid);

    public MemberProfileResponseDto updateMemberProfile(UUID uuid, MemberProfileUpdateRequestDto memberProfileUpdateRequestDto);

}
