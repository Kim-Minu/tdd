package com.study.tdd.port;

import com.study.tdd.model.Note;

import java.util.List;
import java.util.Optional;

public interface NotePort {
    Optional<Note> addNote(Note newNote);

    Optional<Note> getNote(Long noteId);

    Optional<Note> modifyNote(Note modifiedNote);

    void removeNote(Long noteId);

    List<Note> noteList(String title);

    List<Note> notes(Long subjectId);



}
