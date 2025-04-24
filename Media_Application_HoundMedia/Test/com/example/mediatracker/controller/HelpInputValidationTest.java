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
public class HelpInputValidationTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String LONG_STRING = "a".repeat(60);

    @Test
    public void testValidHelpForm() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", new User("helpuser", "testpass"));

        MvcResult result = mockMvc.perform(post("/help")
                        .param("email", "test@example.com")
                        .param("message", "This is a test.")
                        .session(session))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
        assertEquals("/help", result.getResponse().getRedirectedUrl());
    }

    @Test
    public void testInvalidEmail() throws Exception {
        MvcResult result = mockMvc.perform(post("/help")
                        .param("email", "not-an-email")
                        .param("message", "Hello"))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    public void testEmptyMessage() throws Exception {
        MvcResult result = mockMvc.perform(post("/help")
                        .param("email", "test@example.com")
                        .param("message", ""))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    public void testTooLongEmail() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", new User("helpuser", "pass"));

        MvcResult result = mockMvc.perform(post("/help")
                        .param("email", LONG_STRING + "@example.com")
                        .param("message", "Valid message.")
                        .session(session))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    public void testTooLongMessage() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", new User("helpuser", "pass"));

        MvcResult result = mockMvc.perform(post("/help")
                        .param("email", "test@example.com")
                        .param("message", LONG_STRING)
                        .session(session))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
    }

}