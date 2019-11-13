package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {
    //dependary injection 직접객체를 만들지 않고, 스프링이 직접관리를 하겠다.
    //직접 의존성을 주입하겠다. 이런말입니다.
    //dependency injection(DI) -> 스프링의 기능입니다.
    @Autowired
    private UserRepository userRepository;
    @Test
    public void create(){
        User user = new User();
        //user.setId(); auto Increase 자동으로 넣엉줍니다.
        user.setAccount("TestUser04");
        user.setEmail("TestUser03@naver.com");
        user.setPhoneNumber("010-3333-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("Admin3");
        User newUser = userRepository.save(user);
        System.out.println("newUser :" + newUser);
    }
    @Transactional
    @Test
    public void read(){
        //select * from user where id = 6L;
       Optional<User> user = userRepository.findById(6L);
       user.ifPresent(selectUser->{
           System.out.println(selectUser.getId());
       });
    }

    @Transactional
    @Test
    public void readByTwoSector(){
        Optional<User> user = userRepository.findByAccountAndEmail("TestUser03", "TestUser03@naver.com");
        user.ifPresent(selectUser->{
                System.out.println(selectUser);
        });
    }

    @Test
    @Transactional
    public void readAllItemBought(){
        Optional<User> user = userRepository.findById(6L);
        user.ifPresent(selectUser->{
            selectUser.getOrderDetailList().stream().forEach(detail->{
             System.out.println(detail);
            });
        });
    }


    @Test
    @Transactional
    public void update(){
        Optional<User> user = userRepository.findById(4L);
        user.ifPresent(selectUser->{
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("updated method()");
            userRepository.save(selectUser);
        });
    }

    @Test
    public void selectAll(){
        List<User> list = new ArrayList<User>();
        list = userRepository.findAll();
        System.out.println("FIRST WAY TO SELECT ALL");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("SECOND WAY TO SELECT ALL");
        for(User user : list){
            System.out.println(user);
        }
    }

    @Test
    @Transactional //꼭 해줘야지 진짜 데이터베이스가 다치지않습니다.
    public void delete(){
        Optional<User> user = userRepository.findById(4L);

        //반드시 존재가해야합니다.
        Assertions.assertTrue(user.isPresent());//true
        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(4L);
        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : " + deleteUser.get());
        }else{
            System.out.println("데이터 삭제 : 데이터 없음");
        }
        Assertions.assertFalse(deleteUser.isPresent()); //false
    }

}
