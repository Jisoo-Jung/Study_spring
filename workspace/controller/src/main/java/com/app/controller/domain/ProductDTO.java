package com.app.controller.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString @Setter @Getter
public class ProductDTO {
    private String productName;
    private int productPrice;
}
