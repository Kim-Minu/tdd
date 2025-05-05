package com.study.tdd.service;

import com.study.tdd.model.Note;
import com.study.tdd.model.Subject;

import java.util.List;
import java.util.Optional;

public interface NoteUsecase {

    // note CRUD
    public void addNote(Note newNote);
    public void modifyNote(Note modifiedNote);
    public void removeNote(Long noteId);
    public Optional<Note> getNote(Long noteId);
    public List<Note> noteList(String title);

    // subject CRUD
    public void registSubject();
    public void removeSubject();
    public List<Subject> subjectList();
}
