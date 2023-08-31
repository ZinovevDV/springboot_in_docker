package ru.mail.zinovev_dv.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class UsersRestControllerTest2 {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15");

    @DynamicPropertySource
    static void postgreSqlProperties(DynamicPropertyRegistry registry){
        registry.add("postgresql.driver", postgreSQLContainer::getDriverClassName);
    }

    @Autowired
    MockMvc mockMvc;

    @Autowired
    Environment environment;

    @Test
    void findAllUsers_ReturnsUsersList() throws Exception{

        assertEquals("org.postgresql.Driver", environment.getProperty("postgresql.driver"));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpectAll(
                        status().isOk(),
                        content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                        content().json("""
                                    [
                                        {"id":  1, "username":  "Adam"},
                                        {"id":  2, "username":  "Bob"},
                                        {"id":  3, "username":  "Clain"}
                                    ]
                                    """)
                );
    }
}