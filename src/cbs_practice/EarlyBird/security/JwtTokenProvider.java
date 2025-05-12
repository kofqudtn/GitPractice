package cbs_practice.EarlyBird.security;

public class JwtTokenProvider {
}
/*
얘는 로그인 성공했을 때 JWT 토큰을 생성하고,
요청이 올 때 그 토큰을 검증하는 역할을 하는 놈임.

"이 클래스는 JWT 토큰을 다루는 유틸 클래스고,
이름은 JwtTokenProvider."

"기능은 크게 3가지임:"

✅ 1. 토큰 만들기 (createToken)
"이건 로그인 성공한 유저에게 JWT 토큰을 만들어주는 함수임."

username 같은 사용자 정보 넣고

비밀 키(SECRET_KEY)로 서명해서

만료 시간도 정해주고

최종적으로 문자열 토큰을 만들어서 반환함

즉 → 로그인 성공 → 사용자 정보 넣고 → 서명 → 토큰 완성

✅ 2. 토큰에서 사용자 정보 꺼내기 (getUsernameFromToken)
"요청 헤더에 담겨온 JWT를 까서,
그 안에 있는 사용자 정보를 추출하는 기능"

Claims(토큰 내부 정보)에서 subject 꺼냄

우리가 username을 넣었으니까 이걸로 유저 식별 가능

즉 → 토큰 받은 다음 → 누군지 꺼내는 작업

✅ 3. 토큰 유효한지 검사 (validateToken)
"이건 토큰이 만료되지 않았는지,
위조된 건 아닌지 검증하는 메서드임."

서명 무결성 체크

만료시간 확인

예외 있으면 false, 문제 없으면 true 반환

즉 → 받은 토큰이 정상인지 검사

✅ 클래스 내부에는 이런 정보들이 있음:
private final String SECRET_KEY = "mySecretKey";
private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1시간

SECRET_KEY: 토큰 서명에 쓸 비밀 문자열 (외부에 유출되면 안 됨)

EXPIRATION_TIME: 토큰 유효 기간 (지금은 1시간)

 총정리

JwtTokenProvider는
로그인 성공하면 토큰 만들어주고,
나중에 요청 올 때 토큰 확인해서
누군지 확인하고 유효한지도 검사하는 보안담당 유틸 클래스다.

 */