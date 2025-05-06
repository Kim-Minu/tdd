package com.study.tdd.service;

import com.study.tdd.model.Note;
import com.study.tdd.model.Subject;

import java.util.List;
import java.util.Optional;

public interface NoteUsecase {

    // note CRUD
    Note addNote(Note newNote);
    Note modifyNote(Note modifiedNote);
    void removeNote(Long noteId);
    Note getNote(Long noteId);
    List<Note> noteList(String title);

    // subject CRUD
    List<Subject> registSubject(Long noteId, Long subjectId);
    List<Subject> removeSubject(Long noteId, Long subjectId);
    List<Subject> subjectList(Long noteId);
}
