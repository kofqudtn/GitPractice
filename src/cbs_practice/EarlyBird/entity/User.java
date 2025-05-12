package cbs_practice.EarlyBird.entity;

import jakarta.persistence.*; //JPA에서 제공하는 어노테이션들을 한번에 불러옴
import lombok.*; // 롬복이 제공하는 편의 어노테이션들 불러옴
import java.time.LocalDateTime; //시간,날짜를 담을 수 있는 자료형 가져오기

@Entity //이 클래스를 자바 테이블로 쓰겠다
@Table(name = "users") // DB테이블 이름 users 로 만듬

//getter/setter, 기본 생성자, 빌더 같은 건 Lombok으로 자동 생성
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    //기본 키는 Id이고, 자동증가
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //username은 필수고, 중복되면 안 되고, 50자까지 허용
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    //비밀번호는 필수지만 중복 여부는 상관 없음
    @Column(nullable = false)
    private String password;

    //가입 날짜를 createdAt에 자동으로 넣어줌
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist //이 객체를 DB에 저장하기 바로 직전에 이 메서드를 실행
    public void prePersist() {
        this.createdAt = LocalDateTime.now(); //createdAt이라는 시간 필드에 현재 시간(LocalDateTime.now())을 넣는다
    }// 즉, 사용자가 값을 안 넣어도 → DB에 저장되기 직전에 자동으로 시간이 채워짐
}

/*
"나는 회원 정보를 담을 User 클래스 하나 만들 거임.
이건 데이터베이스 테이블이랑 연결되는 애고, 이름은 users 테이블로 할 거임."

"회원마다 고유한 번호가 있어야 하니까 id 필드를 만들고,
이건 자동으로 숫자가 1씩 올라가게 만들 거야."

"그리고 회원마다 username, email, password를 저장할 거야.
username이랑 email은 중복되면 안 되니까 유니크(unique)로 설정하고,
길이도 각각 50자, 100자로 제한할 거야."

"비밀번호는 무조건 있어야 하니까 빈 값은 안 되고,
나중에 이건 암호화해서 저장할 거야."

"회원이 가입한 시점을 저장할 createdAt이라는 필드도 만들 거고,
이건 사용자가 직접 넣지 않아도 DB에 저장되기 직전에
자동으로 현재 시간을 넣어주게 만들 거야."

"나중에 이 필드를 직접 가져오고(set), 읽고(get) 하려고
Getter랑 Setter는 자동으로 만들어줄 거고,
객체 생성할 때 new 대신 .builder()로도 만들 수 있게 할 거야."

그리고 이 모든 걸 기반으로
나중에 회원가입할 때는 SignupRequest에서 입력을 받고,
그걸 User로 바꿔서 DB에 저장하면 되는 구조야.
*/
