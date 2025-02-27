package com.app.dependency.qualifier;

import com.app.dependency.qualifier.task.Restaurant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RestaurantTests {
    @Autowired
    @Qualifier("vips")
    private Restaurant restaurant;

    @Test
    public void testRestaurant(){
        log.info("{}", restaurant);
    }
}
