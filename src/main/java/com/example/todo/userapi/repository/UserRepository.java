package com.example.todo.userapi.repository;

import com.example.todo.userapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, String> {

    // 이메일로 회원 정보 조회
    Optional<User> findByEmail(String email); // Query method
    // findById() return type = Optional

    // 이메일 중복 체크
//    @Query("SELECT COUNT(*) FROM USER u WHERE u.email =: email") // JPQL
    boolean existsByEmail(String email); // Query method
}