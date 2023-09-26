package sieum.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;
import sieum.member.MessageOnly;
import sieum.member.MessageWithData;

import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @GetMapping
    public ResponseEntity<MessageOnly> getUserProfile(@RequestHeader Map<String, String> headers) throws JsonProcessingException {
        String UUID = headers.get("UUID");
        return new ResponseEntity<>(new MessageOnly("test"), HttpStatus.ACCEPTED);
    }
}
