package com.app.dependency.injection;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ToString
public class Food {
    private final Knife knife;
}
