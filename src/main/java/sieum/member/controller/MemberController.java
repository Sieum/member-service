package sieum.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sieum.member.dto.MemberProfileResponseDto;
import sieum.member.dto.MemberProfileUpdateRequestDto;
import sieum.member.response.MessageWithData;
import sieum.member.service.MemberService;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<MessageWithData<MemberProfileResponseDto>> getMemberProfile(@RequestHeader Map<String, String> headers) throws JsonProcessingException {
        String uuid = headers.get("uuid");
        MemberProfileResponseDto data = memberService.getMemberProfile(UUID.fromString(uuid));
        return new ResponseEntity<>(new MessageWithData<>("test", data), HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<MessageWithData<MemberProfileResponseDto>> updateMemberProfile(@RequestHeader Map<String, String> headers,
                                                               @RequestBody MemberProfileUpdateRequestDto memberProfileUpdateRequestDto){
        String uuid = headers.get("uuid");
        MemberProfileResponseDto data = memberService.updateMemberProfile(UUID.fromString(uuid), memberProfileUpdateRequestDto);
        return new ResponseEntity<>(new MessageWithData<>("프로필을 변경했습니다.", data), HttpStatus.ACCEPTED);
    }
}
