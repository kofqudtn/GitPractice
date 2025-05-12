package cbs_practice.EarlyBird.repository;

public class UserRepository {
}
/*
 "이건 이름 그대로,
DB랑 직접 연결돼서 User 데이터를 저장하거나 꺼내오는 역할을 맡는 놈임."

"Spring Data JPA에서는
Repository 인터페이스를 만들고 JpaRepository를 상속만 해주면
자동으로 DB 쿼리 기능을 만들어줌.
(우리가 직접 SQL을 안 써도 된다는 얘기지!)"

"이 클래스 이름은 UserRepository고,
제네릭으로 <User, Long> 이렇게 두 개를 넘겨줌:"

User → 어떤 엔티티랑 연결할 건지 (즉, 테이블 구조)

Long → 그 엔티티의 @Id 필드 타입 (지금은 id: Long이었지)

"그리고 하나만 딱 추가로 정의해줄 거 있음:"

Optional<User> findByUsername(String username);
→ "이건 username으로 유저를 조회하는 기능인데,
메서드 이름만 맞추면 JPA가 자동으로 쿼리를 만들어줌.
Optional로 감싸는 건 값이 없을 수도 있어서 null-safe하게 하려고."

📦 요약하면:

“UserRepository는 User 엔티티를 DB에 저장하거나 꺼낼 때 사용하는 인터페이스고,
Spring Data JPA 덕분에 우리가 직접 SQL 안 써도 됨.
findByUsername() 같은 메서드도 이름만 지으면 자동으로 쿼리 짜준다.”
 */