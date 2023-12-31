package com.example.todo.userapi.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString @EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id; // 계정명이 아니라 식별 코드

    @Column(nullable = false, unique = true)
    private String email; // email address = user id

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @CreationTimestamp
    private LocalDateTime joinDate;

    @Enumerated(EnumType.STRING)
    @Builder.Default
//    @ColumnDefault("'COMMON'") // enum type이어서 안쪽에 홑따옴표
    private Role role = Role.COMMON; // 유저 권한
    // COMMON, PREMIUM, ADMIN
    
    private String profileImg; // 프로필 이미지 경로
    
    private String accessToken; // 카카오 로그인 시 발급 받는 accessToken을 저장 -> 로그아웃 때 필요

    // 엔터티는 setter가 없는 경우가 많으므로 직접 메서드 선언
    // 등급 수정 메서드
    public void changeRole(Role role) {
        this.role = role; // 해당 객체의 role을 매개값으로 받은 role로 변경
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
