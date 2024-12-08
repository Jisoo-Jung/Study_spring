package com.app.threetier.domain.post;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestDTO {
    private String name;
    private String[] tests;
}
