package com.app.dependency.qualifier.task;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("vips")
public class Vips implements Restaurant {
    private int steak = Restaurant.steak + 10000;
    @Override
    public boolean isSaladBar() {
        return true;
    }
}
