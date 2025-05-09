package com.study.tdd.abaptor;

import com.study.tdd.model.Note;
import com.study.tdd.model.Subject;
import com.study.tdd.port.NotePort;
import com.study.tdd.port.SubjectPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TempAdaptor implements SubjectPort, NotePort {
    @Override
    public Optional<Note> addNote(Note newNote) {
        return Optional.empty();
    }

    @Override
    public Optional<Note> getNote(Long noteId) {
        return Optional.empty();
    }

    @Override
    public Optional<Note> modifyNote(Note modifiedNote) {
        return Optional.empty();
    }

    @Override
    public void removeNote(Long noteId) {

    }

    @Override
    public List<Note> noteList(String title) {
        return List.of();
    }

    @Override
    public List<Note> notes(Long subjectId) {
        return List.of();
    }

    @Override
    public void registSubject(Long noteId, Long subjectId) {

    }

    @Override
    public void removeSubject(Long noteId, Long subjectId) {

    }

    @Override
    public List<Subject> subjectList(Long noteId) {
        return List.of();
    }

    @Override
    public Optional<Subject> addSubject(Subject subject) {
        return Optional.empty();
    }

    @Override
    public Optional<Subject> modifySubject(Subject subject) {
        return Optional.empty();
    }

    @Override
    public void removeSubject(Long subjectId) {

    }

    @Override
    public Optional<Subject> getSubject(Long subjectId) {
        return Optional.empty();
    }

    @Override
    public List<Subject> findSubjectList(String title) {
        return List.of();
    }
}
