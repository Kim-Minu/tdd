package com.study.tdd.service;

import com.study.tdd.model.Note;
import com.study.tdd.model.ParaEnum;
import com.study.tdd.model.Subject;
import com.study.tdd.port.NotePort;
import com.study.tdd.port.SubjectPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService implements SubjectUsecase{

    private final SubjectPort subjectPort;

    private final NotePort notePort;

    @Override
    public Subject addSubject(Subject subject) {
        return subjectPort.addSubject(subject)
                .orElseThrow(() -> new RuntimeException("Failed to add subject"));
    }

    @Override
    public Subject modifySubject(Subject subject) {
        return subjectPort.modifySubject(subject)
                .orElseThrow(() -> new RuntimeException("Failed to modify subject"));
    }

    @Override
    public void removeSubject(Long subjectId) {
        subjectPort.removeSubject(subjectId);
    }

    @Override
    public Subject getSubject(Long subjectId) {
        return subjectPort.getSubject(subjectId).orElseThrow(() -> new RuntimeException("Failed to get subject"));
    }

    @Override
    public List<Subject> subjectList(String title) {
        return subjectPort.findSubjectList(title);
    }

    @Override
    public List<Note> noteList(Long subjectId) {
        return notePort.notes(subjectId);
    }

    @Override
    public Subject changePara(Subject subject) {
        return subjectPort.modifySubject(subject)
                .orElseThrow(() -> new RuntimeException("Failed to change para"));
    }

}
