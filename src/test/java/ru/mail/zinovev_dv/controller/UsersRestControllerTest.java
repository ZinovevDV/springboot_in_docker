package ru.mail.zinovev_dv.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UsersRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void findAllUsers_ReturnsUsersList() throws Exception{
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