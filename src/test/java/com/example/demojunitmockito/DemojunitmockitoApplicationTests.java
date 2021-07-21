package com.example.demojunitmockito;

import com.example.demojunitmockito.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemojunitmockitoApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        Assert.assertEquals(2,userService.count());
    }


}
