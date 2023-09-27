package sieum.member.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sieum.member.dto.MemberProfileUpdateRequestDto;
import sieum.member.entity.Member;
import sieum.member.repository.MemberRepository;
import sieum.member.dto.MemberProfileResponseDto;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    /*
    * UUID를 통해 유저 프로필을 반환하는 API
    * */
    @Override
    public MemberProfileResponseDto getMemberProfile(UUID uuid) {
        Member member = findMemberById(uuid);
        return new MemberProfileResponseDto().toMemberProfileResponseDto(member);
    }

    /*
    * 유저 프로필을 변경하고 변경한 결과를 반환하는 API
    * */
    @Override
    @Transactional
    public MemberProfileResponseDto updateMemberProfile(UUID uuid, MemberProfileUpdateRequestDto memberProfileUpdateRequestDto) {
        Member member = memberRepository.save(findMemberById(uuid).updateMember(memberProfileUpdateRequestDto));
        return new MemberProfileResponseDto().toMemberProfileResponseDto(member);
    }

    public Member findMemberById(UUID uuid){
        return memberRepository.findByIdAndIsDeletedFalse(uuid)
                .orElseThrow(() -> new RuntimeException("해당하는 유저를 찾을 수 없습니다."));
    }
}
