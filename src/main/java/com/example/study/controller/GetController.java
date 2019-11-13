package com.example.study.controller;
import com.example.study.model.SearchParam;
import com.example.study.model.entity.User;
import com.example.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import sun.tools.java.Parser;

import java.util.Optional;

@RestController
@RequestMapping("/api")// localhost:8080/api 까지맵핑이 되었습니다.
public class GetController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest(){
        return "HI, getMethod";
    }
    //parameter를 받아보자.
    //api/getParameter?id=1234&password=abcd
    @GetMapping("/getParameter") //get으로 자동으로 메소드가 설정됨 path만 설정하자.
    //name = "~~" 로 지정해주는 방식도있습니다. name을 지정해줍니다.
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){
        String password = "bbbb";
        System.out.println(id);
        System.out.println(pwd);
        return id + pwd;
    }

    //api/getMultiParameter?account=abcd&email=study&gmail.com@page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());
        //json형식으로도 통신을하는데 어떻게 우리는 할 수 있을까?
        //{"account" : "", "email" : "", "page" : 0}
        //그대로 클래스를 리턴해주면됩니다.
        return searchParam;
    }

    @GetMapping("/getInformation")
    public String getInformation(@RequestParam String id){
        Long targetId = Long.parseLong(id);
        Optional<User> user = userRepository.findById(targetId);
        if(user == null){
            return "해당 자료가 존재하지 않습니다.";
        }
        return user.toString();
    }
}
