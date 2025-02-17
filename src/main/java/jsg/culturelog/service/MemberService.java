package jsg.culturelog.service;

import jsg.culturelog.domain.Member;
import jsg.culturelog.domain.dto.MemberDto;
import jsg.culturelog.domain.form.member.MemberAddForm;
import jsg.culturelog.domain.form.member.MemberEditForm;
import jsg.culturelog.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member addMember(MemberAddForm form) {
        Member newMember = new Member();
        newMember.setUserId(form.getUserId());
        newMember.setName(form.getName());
        newMember.setEmail(form.getEmail());
        newMember.setPhone(form.getPhone());
        newMember.setSex(form.getSex());
        newMember.setPwd(form.getPwd());

        return memberRepository.save(newMember);
    }

    public MemberDto getMemberInfo(Long memberId) {
        Optional<Member> findMember = memberRepository.findById(memberId);

        if (findMember.isEmpty()) {
            throw new RuntimeException("조회된 회원 없음");
        }

        return new MemberDto(findMember.get());
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Optional<Member> findMember = memberRepository.findById(memberId);

        if (findMember.isEmpty()) {
            throw new RuntimeException("조회된 회원 없음");
        }

        findMember.get().setUseAt("N");
    }

    @Transactional
    public Member editMember(MemberEditForm form) {
        Optional<Member> findMember = memberRepository.findById(form.getId());
        if (findMember.isEmpty()) {
            throw new RuntimeException("조회된 회원 없음");
        }
        Member member = findMember.get();
        member.setEmail(form.getEmail());
        member.setPhone(form.getPhone());

        return member;
    }
}
