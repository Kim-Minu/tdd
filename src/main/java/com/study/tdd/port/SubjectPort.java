package com.study.tdd.port;


import com.study.tdd.model.ParaEnum;
import com.study.tdd.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectPort {

    void registSubject(Long noteId, Long subjectId);

    void removeSubject(Long noteId, Long subjectId);

    List<Subject> subjectList(Long noteId);

    Optional<Subject> addSubject(Subject subject);

    Optional<Subject>  modifySubject(Subject subject);

    void removeSubject(Long subjectId);

    Optional<Subject> getSubject(Long subjectId);

    List<Subject> findSubjectList(String title);
}
