package cbs_practice.EarlyBird.controller;

public class AuthController {
}
/*
"이 클래스는 REST API를 처리하는 컨트롤러고,
이름은 AuthController."

"기본 경로는 /auth로 시작하고,
그 안에 회원가입(/signup) 이랑 로그인(/login) API를 만들 거임."

✅ 클래스 위에 붙이는 어노테이션
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

@RestController: 이 클래스는 HTTP 요청을 받는 컨트롤러다 (자동으로 JSON 반환함)

@RequestMapping("/auth"): 이 컨트롤러의 기본 URL prefix는 /auth

@RequiredArgsConstructor: final 필드들을 자동으로 생성자 주입해줌

📌 즉, 클라이언트가 /auth/signup, /auth/login 으로 요청 보내면 이 클래스가 받음

✅ 필드
private final AuthService authService;
→ 서비스 로직은 다 AuthService에 위임할 거라
여기선 요청만 받고 넘겨주는 역할만 함

✅ /signup API – 회원가입 처리
@PostMapping("/signup")
public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
    authService.signup(request);
    return ResponseEntity.ok("회원가입 완료");
}

🧠 흐름:

클라이언트가 JSON 형식으로 가입 정보를 보내면

@RequestBody로 DTO를 자동으로 매핑

그걸 authService.signup()에 넘겨서 처리

성공하면 200 OK랑 메시지 응답

✅ /login API – 로그인 처리
@PostMapping("/login")
public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
    AuthResponse response = authService.login(request);
    return ResponseEntity.ok(response);
}
🧠 흐름:

클라가 username + password 보내면

로그인 로직 돌리고, 성공 시 JWT 토큰 만들어서

AuthResponse 형태로 응답 줌

정리하면:

AuthController는 클라이언트로부터 요청을 받고,
DTO로 변환한 뒤, 서비스에 넘겨서 처리하게 하고,
그 결과를 다시 HTTP 응답으로 보내주는 역할을 함.
 */