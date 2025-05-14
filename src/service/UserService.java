package service;

import dto.UserDto;
import model.User;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> userMap = new HashMap<>();

    // 회원가입
    public boolean register(UserDto dto) {
        if (userMap.containsKey(dto.getId())) {
            return false;
        }
        User user = new User(dto.getId(), dto.getPw());
        userMap.put(user.getId(), user);
        return true;
    }

    // 로그인
    public boolean login(UserDto dto) {
        User user = userMap.get(dto.getId());
        return user != null && user.getPw().equals(dto.getPw());
    }
}