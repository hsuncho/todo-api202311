package com.example.todo.todoapi.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoModifyRequestDTO {
    // 체크박스를 눌렀을 때 done의 상태 변화

    @NotBlank
    private String id;
    private boolean done;
}
