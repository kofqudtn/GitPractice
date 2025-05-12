package cbs_practice.EarlyBird.dto;

public class LoginRequest {
}

/*
"이번엔 로그인할 때 클라이언트(사용자)로부터 입력받는 값만 따로 담는 상자를 만들 거임.
이 상자 이름은 LoginRequest고, 역시 DB랑 연결은 안 됨. 일회성 데이터 담는 용도야."

"로그인할 때 필요한 정보는 딱 두 개뿐이야:"

username
→ "어떤 사용자인지 알아보기 위한 식별자"
→ 회원가입할 때 쓴 아이디랑 같음

password
→ "로그인할 때 입력하는 비밀번호"
→ 이건 나중에 저장된 비번이랑 비교해서 맞는지 검증할 때 씀

"이 클래스도 마찬가지로 값만 왔다갔다 하니까
getter, setter 자동으로 만들어줄 거고,
@RequestBody로 컨트롤러에서 바로 받을 수 있게 DTO 형태로만 쓸 거임."

📦 즉 요약하면:

“LoginRequest는
사용자가 로그인할 때 입력한 username과 password를
받아서 서비스한테 넘겨주는 용도의 데이터 상자다.”
* */
