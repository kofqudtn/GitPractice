package cbs_practice.EarlyBird.dto;

public class AuthResponse {
}
/*
 "이건 로그인 성공했을 때
서버가 클라이언트한테 결과를 되돌려주는 상자야."

"이름은 AuthResponse고,
Response → 응답 데이터니까 클라이언트한테 리턴할 때 쓰임."

"안에 담기는 건 딱 두 개:"

accessToken
→ "로그인 성공한 사용자에게 발급되는 JWT 토큰"
→ 이걸 들고 있어야 나중에 인증된 사용자처럼 행동할 수 있음
→ 로그인 유지, 마이페이지 접근 이런 거 가능하게 해주는 열쇠 같은 느낌

tokenType
→ 보통 "Bearer" 라고 들어감
→ 클라이언트가 다음 요청에서 Authorization: Bearer <token> 형태로 보내기 위해 필요

"이 클래스도 당연히 DB랑 연결되는 건 아니고,
그냥 클라이언트한테 JSON으로 응답을 줄 때 구조 맞추려고 만든 DTO임."

"즉, AuthResponse는

“로그인 성공했을 때 JWT 토큰이랑 토큰 타입을 포장해서
클라이언트한테 전달해주는 응답용 DTO”다.”
 */