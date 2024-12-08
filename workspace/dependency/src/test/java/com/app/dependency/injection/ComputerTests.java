package com.app.dependency.injection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ComputerTests {

    @Autowired
    private Coding coding;

    @Test
    public void testCoding(){
//        System.out.println(coding);
        log.info("{}", coding);
    }
}
