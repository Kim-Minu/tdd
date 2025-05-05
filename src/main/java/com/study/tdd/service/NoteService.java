package com.study.tdd.service;

import com.study.tdd.model.Note;
import com.study.tdd.model.Subject;
import com.study.tdd.port.NotePort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class NoteService implements NoteUsecase{

    private final NotePort notePort;

    @Override
    public void addNote(Note newNote) {
        notePort.addNote(newNote);
    }

    @Override
    public void modifyNote(Note modifiedNote) {
        notePort.modifyNote(modifiedNote);
    }

    @Override
    public void removeNote(Long noteId) {
        notePort.removeNote(noteId);
    }

    @Override
    public Optional<Note> getNote(Long noteId) {
        return notePort.getNote(noteId);
    }

    @Override
    public List<Note> noteList(String title) {
        return notePort.noteList(title);
    }

    @Override
    public void registSubject() {

    }

    @Override
    public void removeSubject() {

    }

    @Override
    public List<Subject> subjectList() {
        return List.of();
    }
}
