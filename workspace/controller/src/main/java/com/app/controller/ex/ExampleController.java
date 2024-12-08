package com.app.controller.ex;

import com.app.controller.domain.ProductDTO;
import com.app.controller.domain.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/ex/*")
public class ExampleController {

    //    @RequestMapping(value="ex01", method = RequestMethod.GET)
    @GetMapping("ex01")
    public void ex01(){
        log.info("ex01.................");
    }

    @GetMapping("ex02")
    public void ex02(@ModelAttribute("name") String name){
        log.info("ex02.................");
        log.info("name: {}", name);
    }

//    나이 전달받기
//    /ex/ex03
    @GetMapping("ex03")
    public void ex03(@ModelAttribute("age") int age){
        log.info("ex03.................");
        log.info("age: {}살", age);
    }

//    이름과 나이 전달받기
//    /ex/ex04
//    ?name=한동석&age=20
    @GetMapping("ex04")
    public void ex04(@ModelAttribute("name") String name, @ModelAttribute("age")  int age){
        log.info("ex04.................");
        log.info("name: {}, age: {}살", name, age);
    }

    //    이름과 나이 전달받기
    @GetMapping("ex05")
    public void ex05(UserDTO userDTO){
        log.info("ex05.................");
        log.info("{}", userDTO);
    }

//    상품명과 가격 전달받기
@GetMapping("ex06")
    public void ex06(ProductDTO productDTO){
        log.info("ex06.................");
        log.info("{}", productDTO);
    }

//     장소명과 대여비용 전달받기
}
