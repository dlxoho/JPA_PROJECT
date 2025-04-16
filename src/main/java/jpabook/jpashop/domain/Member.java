package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// 1:N 관계에서 N이 연관관계의 주인이 된다.
// 연관관계 주인은 단순히 외래키를 어디서 관리하냐의 문제
// n : JoinColumn
// 1 : mappedby

@Entity
@Getter
@Setter
public class Member {
  @Id @GeneratedValue
  @Column(name = "member_id")
  private Long id;

  private String name;

  @Embedded
  private Address address;

  // order entity에 있는 member 필드에 매핑된거야 라는 의미 (읽기전용이 된다.)
  @OneToMany(mappedBy = "member")
  private List<Order> orders = new ArrayList<>();
}
