package com.webboard.mapper;

import com.webboard.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    // 회원가입: 사용자 생성
    void insertUser(User user);
    
    // 로그인: username으로 사용자 조회
    User selectUserByUsername(@Param("username") String username);
    
    // 사용자 ID로 조회
    User selectUserById(@Param("userId") Long userId);
    
    // 사용자 정보 수정
    void updateUser(User user);
    
    // 사용자 삭제
    void deleteUser(@Param("userId") Long userId);
    
    // username 중복 체크
    int checkDuplicateUsername(@Param("username") String username);
}
