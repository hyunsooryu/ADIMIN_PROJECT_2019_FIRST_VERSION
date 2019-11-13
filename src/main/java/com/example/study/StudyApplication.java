package com.example.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {


    //JPA란? RDB데이터베이스의 정보를 객체지향으로 손쉽게 활용할 수 있도록 도와주는 도구입니다.
    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

}
