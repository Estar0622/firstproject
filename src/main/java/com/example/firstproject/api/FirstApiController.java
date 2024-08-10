package com.example.firstproject.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //RestAPI용 컨트롤러 JSON을 반환
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello() {
        return "삼성전자 SCSA 24기 합격자 김동규님 안녕하세요!";
    }

}
