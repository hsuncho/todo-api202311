package com.example.todo.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본 생성자 필요함
public class NoRegisteredArgumentsException
        extends RuntimeException {
    // 에러의 대분류 타입 상속 받게 함


    // 에러 메세지를 받는 생성자 구축
    public NoRegisteredArgumentsException(String message) {
        super(message);
    }
}
