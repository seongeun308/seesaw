package team.seesaw.common.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import team.seesaw.common.entity.Member;
import team.seesaw.web.dto.MemberDto;
import team.seesaw.common.repository.MemberRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl{

    private final MemberRepository memberRepository;

    public MemberDto signup(MemberDto memberDto) {
        Member member = memberRepository.save(memberDto.toEntity());
        log.info("Signup member {}", member);
        return member.toDto();
    }

    public MemberDto checkMember(Long id) {
        Optional<Member> memberById = memberRepository.findById(id);
        Member member = memberById.orElseThrow(() ->
                new NoSuchElementException("Member not found"));
        log.info("Check member {}", member);
        return member.toDto();
    }

    public MemberDto updateMember(MemberDto newMemberDto) {
        Member member = memberRepository.save(newMemberDto.toEntity());
        return member.toDto();
    }

    public void withdraw(Long id) {
        memberRepository.deleteById(id);
    }

}
