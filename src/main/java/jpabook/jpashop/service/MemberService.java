package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@AllArgsConstructor // 필드를 가지고 생성자를 만들어준다.
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // final 로 되어있는 필드를 가지고 생성자를 만들어준다
public class MemberService {

  private final MemberRepository memberRepository;

//  @Autowired
//  public MemberService (MemberRepository memberRepository) {
//    this.memberRepository = memberRepository;
//  }

  // 회원가입
  @Transactional
  public Long join (Member member) {
    validateDuplicateMember(member);
    memberRepository.save(member);
    return member.getId();
  }

  // 중복 회원 검증
  private void validateDuplicateMember(Member member) {
    List<Member> findMembers = memberRepository.findByName(member.getName());
    if (!findMembers.isEmpty()) {
      throw new IllegalStateException("이미 존재하는 회원입니다.");
    }
  }

  // 회원 전체 조회
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }
  
  // 회원 한명만 조회
  public Member findOne(Long memberId) {
    return memberRepository.findOne(memberId);
  }
}
