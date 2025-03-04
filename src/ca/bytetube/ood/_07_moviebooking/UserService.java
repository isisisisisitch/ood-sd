package ca.bytetube.ood._07_moviebooking;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserService {
    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public User registerUser(String username, String email, String phoneNumber, String password) {
        // 验证用户信息
        validateUserInfo(username, email, phoneNumber);

        // 创建新用户
        String userId = generateUserId();
        User user = new User(userId, username, email, phoneNumber);
        users.put(userId, user);

        return user;
    }

    public User getUserById(String userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return user;
    }

    public void updateUserStatus(String userId, UserStatus status) {
        User user = getUserById(userId);
        user.setStatus(status);
    }

    private void validateUserInfo(String username, String email, String phoneNumber) {
        // 验证用户名
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        // 验证邮箱格式
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        // 验证手机号格式
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }

    private boolean isValidEmail(String email) {
        // 实现邮箱格式验证
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // 实现手机号格式验证
        return phoneNumber != null && phoneNumber.matches("^\\d{10}$");
    }

    private String generateUserId() {
        return UUID.randomUUID().toString();
    }
}
