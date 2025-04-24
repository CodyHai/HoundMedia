package com.example.mediatracker.controller;
import com.example.mediatracker.model.User;
import com.example.mediatracker.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterInputValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        UserRepository.save(new User("existing", "1234"));
    }

    @Test
    public void testValidRegistration() throws Exception {
        MvcResult result = mockMvc.perform(post("/register")
                        .param("username", "newuser")
                        .param("password", "newpass"))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
        assertEquals("/home", result.getResponse().getRedirectedUrl());
    }

    @Test
    public void testEmptyUsername() throws Exception {
        MvcResult result = mockMvc.perform(post("/register")
                        .param("username", "")
                        .param("password", "pass"))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testDuplicateUser() throws Exception {
        MvcResult result = mockMvc.perform(post("/register")
                        .param("username", "existing")
                        .param("password", "1234"))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }
    @Test
    public void testTooLongUsername() throws Exception {
        MvcResult result = mockMvc.perform(post("/register")
                        .param("username", "a".repeat(30))
                        .param("password", "validpass"))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testTooLongPassword() throws Exception {
        MvcResult result = mockMvc.perform(post("/register")
                        .param("username", "validuser")
                        .param("password", "p".repeat(30)))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }
}