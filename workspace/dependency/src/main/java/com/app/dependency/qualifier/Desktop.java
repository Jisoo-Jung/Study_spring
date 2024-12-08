package com.app.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("desktop")
@Primary
public class Desktop implements Computer{
    @Override
    public int getScreenSize() {
        return 2180;
    }
}
