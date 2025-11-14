package com.webboard.service;

import com.webboard.model.User;
import com.webboard.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원가입
    public void register(User user) {
        // username 중복 체크
        int count = userMapper.checkDuplicateUsername(user.getUsername());
        if (count > 0) {
            throw new RuntimeException("이미 존재하는 사용자명입니다.");
        }

        // 비밀번호 암호화
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insertUser(user);
    }

    // 로그인
    public User login(String username, String password) {
        User user = userMapper.selectUserByUsername(username);
        if (user == null) {
            throw new RuntimeException("사용자를 찾을 수 없습니다.");
        }

        // 비밀번호 검증
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return user;
    }

    // 사용자 정보 조회
    public User getUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    // 사용자 정보 수정
    public void updateUser(User user) {
        // 비밀번호가 제공된 경우 암호화
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userMapper.updateUser(user);
    }

    // 사용자 삭제
    public void deleteUser(Long userId) {
        userMapper.deleteUser(userId);
    }
}
