package com.study.tdd.service;

import com.study.tdd.model.Note;
import com.study.tdd.model.ParaEnum;
import com.study.tdd.model.Subject;

import java.util.List;

public interface SubjectUsecase {
    Subject addSubject(Subject subject);

    Subject modifySubject(Subject subject);

    void removeSubject(Long subjectId);

    Subject getSubject(Long subjectId);

    List<Subject> subjectList(String title);

    List<Note> noteList(Long subjectId);

    Subject changePara(Subject subject);
}
