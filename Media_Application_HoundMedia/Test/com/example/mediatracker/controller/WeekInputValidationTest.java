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
public class WeekInputValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidWeekAccess() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", new User("test", "pass"));

        MvcResult result = mockMvc.perform(get("/week")
                        .param("month", "1")
                        .param("week", "2")
                        .session(session))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testInvalidMonthWeek() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", new User("test", "pass"));

        MvcResult result = mockMvc.perform(get("/week")
                        .param("month", "13")
                        .param("week", "5")
                        .session(session))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }
    @Test
    public void testInvalidMonthOnly() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", new User("test", "pass"));

        MvcResult result = mockMvc.perform(get("/week")
                        .param("month", "13")
                        .param("week", "2")
                        .session(session))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testInvalidWeekOnly() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", new User("test", "pass"));

        MvcResult result = mockMvc.perform(get("/week")
                        .param("month", "1")
                        .param("week", "5")
                        .session(session))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testEmptyInputs() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("user", new User("test", "pass"));

        MvcResult result = mockMvc.perform(get("/week")
                        .param("month", "")
                        .param("week", "")
                        .session(session))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }
}