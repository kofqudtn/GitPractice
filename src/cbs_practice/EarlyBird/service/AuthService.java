package cbs_practice.EarlyBird.service;

public class AuthService {
}
/*
"이 클래스는 서비스 계층이고 이름은 AuthService.
회원가입이랑 로그인 기능을 여기에 다 때려박을 거임."

"여긴 컨트롤러랑 DB 사이에서 실제 비즈니스 로직을 처리하는 핵심 클래스야."

1. 의존성 주입 (생성자에 필요한 애들 넣기)
private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;
private final JwtTokenProvider jwtTokenProvider;

userRepository → DB에 유저 저장하거나 조회하려고

passwordEncoder → 비번 암호화하려고 (bcrypt로 해싱)

jwtTokenProvider → JWT 토큰 생성하려고

이거 셋은 생성자 주입해서 스프링이 자동으로 넣어주게 할 거임

 2. signup(SignupRequest request) – 회원가입

"이 함수는 클라이언트가 회원가입할 때 보내준 데이터(SignupRequest)를 받아서,
다음 작업들을 순서대로 함:"

같은 username이 이미 존재하는지 확인

있으면 에러 던짐 ("이미 존재하는 사용자")

비밀번호 암호화 (passwordEncoder.encode)

User 객체로 변환해서 DB에 저장 (userRepository.save)

즉:

“중복 체크 → 비밀번호 암호화 → User 객체 생성 → 저장”
이 흐름을 쭉 처리해줌

3. login(LoginRequest request) – 로그인
"이 함수는 클라이언트가 로그인할 때 입력한 아이디/비번을 받아서,
다음 순서로 처리함:"

1-username으로 User를 조회함
없으면 예외 ("사용자 없음")

2-입력한 비밀번호와 DB에 저장된 암호화된 비번을 비교
안 맞으면 예외 ("비밀번호 틀림")

3-토큰 발급 (jwtTokenProvider.createToken(username))

4-AuthResponse로 감싸서 반환

전체 요약

AuthService는 진짜 핵심 기능만 모여있는 클래스다.

회원가입은 “검증 → 암호화 → 저장”

로그인은 “조회 → 검증 → 토큰 발급”

여기서 중요한 건
DB는 repository한테 맡기고,
JWT는 security한테 맡기고,
여긴 흐름만 담당하는 구조라는 거.
 */