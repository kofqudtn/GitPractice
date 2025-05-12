package cbs_practice.EarlyBird.dto;

//getter/setter 자동으로 만들어줌
import lombok.Getter;
import lombok.Setter;
//생성자도 기본으로 하나 만들어둠
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 회원가입할 때 요청 데이터를 담는 DTO
 * 클라이언트 → 서버로 전달되는 데이터 구조
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String username; //username을 필수로 받을꺼
    private String password; //password도 같이 받을 거 필수
}
/*
"회원가입할 때 사용자한테 입력받을 값들을 담는 상자 하나 만들 거임.
이 상자는 SignupRequest라는 이름으로 만들 거고,
DB랑 연결되는 건 아님. 그냥 일회성으로 입력값만 받는 용도야."

"상자 안에 들어갈 건 총 3개야:"

사용자 이름 (username)
→ "회원가입할 때 입력한 이름을 담을 문자열 변수"

이메일 (email)
→ "회원가입할 때 입력한 이메일 주소를 담는 문자열 변수"

비밀번호 (password)
→ "입력한 비밀번호를 담는 문자열 변수인데,
이건 나중에 저장 전에 암호화해서 처리할 거임"

"이 클래스는 외부에서 값을 받아야 하니까,
getter랑 setter 메서드가 필요하고,
간단하게 만들기 위해 Lombok을 써서 자동으로 만들 거야."

"결론적으로 이 클래스는
‘회원가입 폼 입력 데이터’를 자바 객체로 옮겨 담기 위한 용도야.
DB에 저장은 안 하고, 입력값 검증할 때만 쓰임."
*/
