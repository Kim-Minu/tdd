package com.study.tdd.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.study.tdd.model.Note;
import com.study.tdd.service.NoteService;
import com.study.tdd.service.NoteUsecase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

        var noteId = 1L;
        var note = new Note(noteId, "title", "content");

        // when
        given(noteService.getNote(noteId)).willReturn(note);

        var result = mockMvcTester
                .get()
                .uri("/api/v1/notes/{noteId}", noteId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .assertThat()
                .apply(print())
                .hasStatusOk()
                .bodyJson();

        result.extractingPath("$.noteId").isEqualTo(note.noteId().intValue());
        result.extractingPath("$.title").isEqualTo(note.title());
        result.extractingPath("$.content").isEqualTo(note.content());

    }

    @Test
    void addNote() throws JsonProcessingException {

        var newNote = new Note(null, "title", "content");

        mockMvcTester.post()
                .uri("/api/v1/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newNote))
                .assertThat().apply(print())
                .hasStatusOk();
    }

    @Test
    void modifyNote() throws JsonProcessingException {
        var noteId = 1L;
        var modifiedNote = new Note(noteId, "modified title", "modified content");

        given(noteService.modifyNote(modifiedNote)).willReturn(modifiedNote);

        mockMvcTester.put()
                .uri("/api/v1/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(modifiedNote))
                .assertThat().apply(print())
                .hasStatusOk();
    }

    @Test
    void removeNote() {

        var noteId = 1L;

        mockMvcTester.delete()
                .uri("/api/v1/notes/{noteId}", noteId)
                .assertThat().apply(print())
                .hasStatusOk();

    }

}