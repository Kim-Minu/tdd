package com.study.tdd.service;

import com.study.tdd.model.Note;
import com.study.tdd.model.Subject;
import com.study.tdd.port.NotePort;
import com.study.tdd.port.SubjectPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService implements NoteUsecase{

    private final NotePort notePort;
    private final SubjectPort subjectPort;

    @Override
    public Note addNote(Note newNote) {
        return notePort.addNote(newNote)
                .orElseThrow(() -> new RuntimeException("Failed to add note"));
    }

    @Override
    public Note modifyNote(Note modifiedNote) {
        return notePort.modifyNote(modifiedNote)
                .orElseThrow(() -> new RuntimeException("Failed to modify note"));

    }

    @Override
    public void removeNote(Long noteId) {
        notePort.removeNote(noteId);
    }

    @Override
    public Note getNote(Long noteId) {
        return notePort.getNote(noteId)
                .orElseThrow(() -> new RuntimeException("Failed to get note"));

    }

    @Override
    public List<Note> noteList(String title) {
        return notePort.noteList(title);
    }

    @Override
    public List<Subject> registSubject(Long noteId, Long subjectId) {

        subjectPort.registSubject(noteId, subjectId);

        return subjectPort.subjectList(noteId);

    }

    @Override
    public List<Subject> removeSubject(Long noteId, Long subjectId) {
        subjectPort.removeSubject(noteId, subjectId);

        return subjectPort.subjectList(noteId);
    }

    @Override
    public List<Subject> subjectList(Long noteId) {
        return subjectPort.subjectList(noteId);
    }
}
