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
public class AddMediaInputValidationTest {

    private MockHttpSession createSession() {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", new User("media", "user"));
        return session;
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidMediaEntry() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", new User("media", "user"));

        MvcResult result = mockMvc.perform(post("/addMedia")
                        .param("month", "1")
                        .param("day", "1")
                        .param("name", "Interstellar")
                        .param("tag", "movie")
                        .param("length", "169")
                        .session(session))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
        assertEquals("/home", result.getResponse().getRedirectedUrl());
    }

    @Test
    public void testMissingFields() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", new User("media", "user"));

        MvcResult result = mockMvc.perform(post("/addMedia")
                        .param("month", "1")
                        .param("day", "1")
                        .param("name", "")
                        .param("tag", "")
                        .param("length", "")
                        .session(session))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
        assertEquals("/home", result.getResponse().getRedirectedUrl());
    }
    @Test
    public void testInvalidMonth() throws Exception {
        MvcResult result = mockMvc.perform(post("/addMedia")
                        .param("month", "13")
                        .param("day", "1")
                        .param("name", "Inception")
                        .param("tag", "movie")
                        .param("length", "120")
                        .session(createSession()))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    public void testInvalidDay() throws Exception {
        MvcResult result = mockMvc.perform(post("/addMedia")
                        .param("month", "1")
                        .param("day", "29")
                        .param("name", "Inception")
                        .param("tag", "movie")
                        .param("length", "120")
                        .session(createSession()))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    public void testInvalidName() throws Exception {
        MvcResult result = mockMvc.perform(post("/addMedia")
                        .param("month", "1")
                        .param("day", "1")
                        .param("name", "")
                        .param("tag", "movie")
                        .param("length", "120")
                        .session(createSession()))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    public void testInvalidTag() throws Exception {
        MvcResult result = mockMvc.perform(post("/addMedia")
                        .param("month", "1")
                        .param("day", "1")
                        .param("name", "Inception")
                        .param("tag", "")
                        .param("length", "120")
                        .session(createSession()))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    public void testInvalidLength() throws Exception {
        MvcResult result = mockMvc.perform(post("/addMedia")
                        .param("month", "1")
                        .param("day", "1")
                        .param("name", "Inception")
                        .param("tag", "movie")
                        .param("length", "-5")
                        .session(createSession()))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    public void testInvalidLengthDecimals() throws Exception {
        MvcResult result = mockMvc.perform(post("/addMedia")
                        .param("month", "1")
                        .param("day", "1")
                        .param("name", "Inception")
                        .param("tag", "movie")
                        .param("length", "1.0000")
                        .session(createSession()))
                .andReturn();

        assertEquals(302, result.getResponse().getStatus());
    }
}