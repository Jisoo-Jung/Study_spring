package com.app.app.controller.restful;

import com.app.app.domain.restful.RestDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @GetMapping("ex01/{id}")
    public String ex01(@PathVariable int id) {
        return id + "번";
    }

    @GetMapping("ex02")
    public RestDTO ex02(RestDTO restDTO) {
        return restDTO;
    }

    @GetMapping("ex03")
    public List<RestDTO> ex03(){
        List<RestDTO> list = new ArrayList<>();
        RestDTO r1 = new RestDTO();
        RestDTO r2 = new RestDTO();

        r1.setId(1L);
        r1.setName("REST1");

        r2.setId(2L);
        r2.setName("REST2");

        list.add(r1);
        list.add(r2);

        return list;
    }
}














