package com.example.todo.userapi.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
