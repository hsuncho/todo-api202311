package com.example.todo.userapi.dto.response;


import com.example.todo.userapi.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter @Getter
@ToString
public class KakaoUserDTO {

    private long id; // 카카오 쪽에서 제공하는 아이디(우리는 uuid 이용)

    @JsonProperty("connected_at")
    private LocalDateTime connectedAt;

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;


    @Setter @Getter @ToString
    public static class KakaoAccount { // 바깥쪽의 값을 참조할 때는 private
        // 바깥쪽의 값을 참조하지 않을 것이므로 static class

        private String email;

        private Profile profile;

        @Getter @Setter @ToString
        public static class Profile {
            private String nickname;

            @JsonProperty("profile_image_url")
            private String profileImageUrl;

        }
    }

    public User toEntity (String accessToken) {
        return User.builder()
                .id(String.valueOf(this.id)) // user의 id는 String, kakao에서 제공된 id는 Long 타입
                .email(this.kakaoAccount.getEmail())
                .userName(this.kakaoAccount.profile.nickname)
                .password("password!")
                .profileImg(this.kakaoAccount.profile.profileImageUrl)
                .accessToken(accessToken)
                .build();
    }

}
