package com.app.app.aspect;

import com.app.app.domain.reply.ReplyDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Slf4j
@Configuration
public class LogAspect {
    @AfterReturning(value = "@annotation(com.app.threetier.aspect.annotation.LogStatus)", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, List<ReplyDTO> returnValue) {
        log.info("method: {}", joinPoint.getSignature().getName());
        log.info("arguments: {}", Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", ")));
        log.info("return: {}", returnValue);
    }
}















