package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

  @Autowired MemberRepository memberRepository;

  @Test
  @Transactional // test 코드에서는 create 이후 rollback 발생
  @Rollback(value = false)
  public void testMember() throws Exception {
//    Member member = new Member();
//    member.setUsername("memberA");
//
//    Long saveId = memberRepository.save(member);
//    Member findMember = memberRepository.find(saveId);
//
//    Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//    Assertions.assertThat(findMember).isEqualTo(member); // findMember == member 트랜잭션 안에서는 같은 영속성 컨텍스트이기때문에 id 가 같으면 같다고 인식
  }
}