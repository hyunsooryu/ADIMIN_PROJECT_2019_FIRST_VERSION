package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//db table이름과 같게시켜줍니다.
//db는 snake_case인데, jpa에서 자동으로 매칭을 해주는 장점을 갖고있습니다.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user") //User 라는 이름과 동일하기 떄문에 선언하지 않으면 자동으로 매칭이됩니다.
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //관리전략을 설정
    private Long id; //LONG 으로 빅인트를 나타냈습니다.
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    //1 : N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")

    //패치 타입에 대한 고찰

    /*
    1. 레이지 타입 -> 지연 로딩 / 이거 타입 -> 즉시 로딩

    1 : 1 -> EAGER -> 그 외에는 무조건 레이지로 조지세요


    */
    private List<OrderDetail> orderDetailList;
}
