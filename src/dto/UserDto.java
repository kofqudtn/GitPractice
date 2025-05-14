package dto;

public class UserDto {
    private String id;
    private String pw;

    public UserDto(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
}