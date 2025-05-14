package storage;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileManager {
    private static final String FILE_NAME = "users.txt";

    // 유저 리스트 저장하기
    public static void saveUsers(List<User> userList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : userList) {
                writer.write(user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ 저장 중 오류 발생: " + e.getMessage());
        }
    }

    // 유저 리스트 불러오기
    public static List<User> loadUsers() {
        List<User> userList = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return userList; // 파일 없으면 빈 리스트 리턴
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userList.add(new User(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("❌ 불러오기 중 오류 발생: " + e.getMessage());
        }

        return userList;
    }
}