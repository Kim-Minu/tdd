package com.study.tdd.port;

import com.study.tdd.model.Note;

import java.util.List;
import java.util.Optional;

public interface NotePort {
    void addNote(Note newNote);

    Optional<Note> getNote(Long noteId);

    void modifyNote(Note modifiedNote);

    void removeNote(Long noteId);

    List<Note> noteList(String title);
}
