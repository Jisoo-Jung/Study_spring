package com.app.threetier.domain.restful;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
public class RestDTO {
    private Long id;
    private String name;
}
