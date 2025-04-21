package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional // test 코드에서는 create 이후 rollback 발생
//@Rollback(value = false) // 트랜잭션 rollback 이 아닌 commit 을 발생
class MemberServiceTest {

  @Autowired
  MemberService memberService;
  @Autowired
  MemberRepository memberRepository;

  @Test
  public void 회원가입() throws Exception {
    Member member = new Member();
    member.setName("lee");

    Long id = memberService.join(member);

    Assertions.assertEquals(member, memberRepository.findOne(id));
  }

  @Test
  public void 중복_회원_예외() throws Exception {
    Member member = new Member();
    member.setName("kim");

    Member member2 = new Member();
    member2.setName("kim");

    memberService.join(member);

    assertThrows(IllegalStateException.class,() -> {
     memberService.join(member2);
    });
  }

}