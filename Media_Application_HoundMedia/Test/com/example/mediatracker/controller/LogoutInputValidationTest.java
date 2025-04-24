package com.example.mediatracker.controller;
import org.junit.jupiter.api.BeforeEach;
import com.example.mediatracker.model.User;
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
public class LogoutInputValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLogoutRedirectsToLogin() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", new User("logout", "user"));

        MvcResult result = mockMvc.perform(get("/logout").session(session))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
        assertEquals("/", result.getResponse().getRedirectedUrl());
    }
}