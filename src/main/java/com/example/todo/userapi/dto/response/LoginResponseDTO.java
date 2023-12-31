package com.example.todo.userapi.dto.response;

import com.example.todo.userapi.entity.Role;
import com.example.todo.userapi.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class LoginResponseDTO {

    private String email;

    private String userName;

    @JsonFormat(pattern = "yyyy년 MM월 dd일")
    private LocalDate joinDate;

    private String token; // 인증 토큰

    private String role; // 권한

    // user entity와 token을 받아서 setting 해주는 생성자
    public LoginResponseDTO(User user, String token) {
        this.email = user.getEmail();
        this.userName = user.getUserName();
        this.joinDate = LocalDate.from(user.getJoinDate());
        this.token = token;
        this.role = String.valueOf(user.getRole());
    }
}
