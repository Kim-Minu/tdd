package com.study.tdd.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.tdd.model.Note;
import com.study.tdd.service.NoteService;
import com.study.tdd.service.NoteUsecase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
class NoteControllerTest {

    @Autowired
    MockMvcTester mockMvcTester;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    NoteUsecase noteService;

    @Test
    void getNote() {

    }

    @Test
    void addNote() throws JsonProcessingException {

        var newNote = new Note(null, "title", "content");

        mockMvcTester.post()
                .uri("/api/v1/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newNote))
                .assertThat().apply(print());
        // .andExpect(status().isOk())


    }

    @Test
    void modifyNote() {
    }

    @Test
    void removeNote() {

    }

}