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
public class LoginInputValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        UserRepository.save(new User("validuser", "validpass"));
    }

    @Test
    public void testLoginWithValidCredentials() throws Exception {
        MvcResult result = mockMvc.perform(post("/login")
                        .param("username", "validuser")
                        .param("password", "validpass"))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
        assertEquals("/home", result.getResponse().getRedirectedUrl());
    }

    @Test
    public void testLoginWithEmptyUsername() throws Exception {
        MvcResult result = mockMvc.perform(post("/login")
                        .param("username", "")
                        .param("password", "validpass"))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testLoginWithEmptyPassword() throws Exception {
        MvcResult result = mockMvc.perform(post("/login")
                        .param("username", "validuser")
                        .param("password", ""))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testLoginWithTooLongUsername() throws Exception {
        MvcResult result = mockMvc.perform(post("/login")
                        .param("username", "a".repeat(30))
                        .param("password", "validpass"))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }
    @Test
    public void testLoginWithWrongUsername() throws Exception {
        MvcResult result = mockMvc.perform(post("/login")
                        .param("username", "wronguser")
                        .param("password", "validpass"))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testLoginWithWrongPassword() throws Exception {
        MvcResult result = mockMvc.perform(post("/login")
                        .param("username", "validuser")
                        .param("password", "wrongpass"))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

}