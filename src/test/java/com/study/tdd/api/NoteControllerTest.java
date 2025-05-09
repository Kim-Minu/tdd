package com.study.tdd.api;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class NoteControllerTest {

    // @MockBean
    // private NoteService noteService;

    // @Autowired
    // private MockMvc mockMvc;

    // @Test
    // void testGetNote() throws Exception {
    //     mockMvc.perform(get("/api/v1/notes/1"))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$.id").value(1));
    // }

}