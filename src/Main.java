import dto.UserDto;
import service.UserService;
import util.InputUtil;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        while (true) {
            System.out.println("\n===== 🔐 로그인 / 회원가입 시스템 =====");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 종료");

            int choice = InputUtil.inputInt("번호 선택 ➤ ");

            switch (choice) {
                case 1:
                    String regId = InputUtil.inputString("🧑 아이디 입력: ");
                    String regPw = InputUtil.inputString("🔑 비밀번호 입력: ");
                    UserDto regDto = new UserDto(regId, regPw);
                    boolean regResult = userService.register(regDto);

                    if (regResult) {
                        System.out.println("✅ 회원가입 성공!");
                    } else {
                        System.out.println("❌ 이미 존재하는 아이디입니다.");
                    }
                    break;

                case 2:
                    String loginId = InputUtil.inputString("🧑 아이디 입력: ");
                    String loginPw = InputUtil.inputString("🔑 비밀번호 입력: ");
                    UserDto loginDto = new UserDto(loginId, loginPw);
                    boolean loginResult = userService.login(loginDto);

                    if (loginResult) {
                        System.out.println("✅ 로그인 성공! 환영합니다, " + loginId + "님!");
                    } else {
                        System.out.println("❌ 로그인 실패: 아이디 또는 비밀번호가 틀렸습니다.");
                    }
                    break;

                case 3:
                    System.out.println("👋 프로그램 종료!");
                    InputUtil.closeScanner();
                    return;

                default:
                    System.out.println("❗ 1~3번 중에서 선택해주세요.");
            }
        }
    }
}