package com.app.app.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestTask {

//    매 분 0초마다
    @Scheduled(cron="0 * * * * *")
    public void test(){
        log.info("한동석 짱");
    }
}
