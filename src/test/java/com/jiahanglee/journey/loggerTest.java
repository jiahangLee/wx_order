package com.jiahanglee.journey;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class loggerTest {

//    private final Logger logger = LoggerFactory.getLogger(loggerTest.class);
    @Test
    public void test1(){
        log.debug("我是debug");
        log.info("我是info");
        log.error("我是error");
        log.info("name:{},password:{}","jiahanglee","123");
    }
}