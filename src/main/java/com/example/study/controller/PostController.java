package com.example.study.controller;


import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //이건 이름겹쳐도 상관 ㄴㄴ
public class PostController {

    //HTML<FORM>
    //AJAX 검색에 많이 쓰입니다.
    //html post body -> data
    //json, xml, multipart-form, text-plain
    //
  //  @RequestMapping(method = RequestMethod.POST, path = "/postMethod") //postMapping입니다.
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        return searchParam;
    }
    //REST란 HTTP프로토콜에 있는 메소드를 활용한 아키텍쳐 스타일입니다.
    //HTTP METHOD 를 통해서 리소스를 처리합니다. 크루드를 통한 리소스 조작을 할 때 사용합니다.
    //GET POST PUT/PATCH DELETE
    //SELECT CREATE UPDATE DELETE

    //PUT은 업데이트에많이쓰입니다.
    @PutMapping(value = "/put")
    public void put(){

    }
    //PATCH역시 약간 수정할 때 쓰이는 아이입니다.
    @PatchMapping(value = "/patch")
    public void patch(){

    }

}
