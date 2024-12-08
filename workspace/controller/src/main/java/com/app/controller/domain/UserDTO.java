package com.app.controller.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString @Setter @Getter
public class UserDTO {
    private String name;
    private int age;
}