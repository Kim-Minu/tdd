package com.study.tdd.api;

import com.study.tdd.model.Note;
import com.study.tdd.service.NoteService;
import com.study.tdd.service.NoteUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/notes")
public class NoteController {

    private final NoteUsecase noteService;

    @GetMapping("/{noteId}")
    public ResponseEntity<Note> getNote(@PathVariable Long noteId) {
        return ResponseEntity.ok(noteService.getNote(noteId));
    }

    @PostMapping("")
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return ResponseEntity.ok(noteService.addNote(note));

    }

    @PutMapping("")
    public ResponseEntity<Note> modifyNote(@RequestBody Note note) {
        return ResponseEntity.ok(noteService.modifyNote(note));
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Object> removeNote(@PathVariable Long noteId) {
        noteService.removeNote(noteId);
        return ResponseEntity.ok().build();
    }


}
