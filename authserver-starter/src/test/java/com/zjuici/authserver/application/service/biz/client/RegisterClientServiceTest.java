package com.zjuici.authserver.application.service.biz.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author fuzeqiang
 * @projectName authserver
 * @title: RegisterClientServiceTest
 * @date 2022/1/7 11:20
 */
@Profile("dev")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterClientServiceTest {

    /**
     * service 注入
     */
    @Autowired
    private RegisterClientService registerClientService;


    @Test
    public void testRegisterClient(){
        registerClientService.registerClient("nltosql", "nltosql", "Zju888888", "http://43.129.84.4:8082");
        registerClientService.registerClient("knowledge", "knowledge", "Zju888888", "http://43.129.84.4:8084");
    }


}
