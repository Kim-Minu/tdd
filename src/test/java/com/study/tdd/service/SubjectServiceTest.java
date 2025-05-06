package com.study.tdd.service;

import com.study.tdd.model.Note;
import com.study.tdd.model.ParaEnum;
import com.study.tdd.model.Subject;
import com.study.tdd.port.NotePort;
import com.study.tdd.port.SubjectPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SubjectServiceTest {

    @InjectMocks
    SubjectService subjectService;

    @Mock
    SubjectPort subjectPort;

    @Mock
    NotePort notePort;

    @Test
    void subjectCrudTest() {
        var newSubject = new Subject(null, "title", "content", ParaEnum.AREA);

        var addedSubject = Optional.of(new Subject(1L, "title", "content", ParaEnum.AREA));

        when(subjectPort.addSubject(any())).thenReturn(addedSubject);

        assertThat(subjectService.addSubject(newSubject))
                .isInstanceOf(Subject.class);


        // modify
        var mockModifiedSubject = Optional.of(new Subject(1L, "modified title", "modified content", ParaEnum.RESOURCE));
        when(subjectPort.modifySubject(any())).thenReturn(mockModifiedSubject);

        var modifiedSubject = new Subject(1L, "modified title", "modified content", ParaEnum.RESOURCE);
        assertThat(subjectService.modifySubject(modifiedSubject))
                .isInstanceOf(Subject.class);


        // remove
        var subjectId = 1L;
        subjectService.removeSubject(subjectId);
        verify(subjectPort, times(1)).removeSubject(subjectId);

    }

    @Test
    void notesInSubjectTest() {
        var subjectId = 1L;

        var noteList = List.of(
                new Note(1L, "title", "content"),
                new Note(2L, "title", "content")
        );

        when(notePort.notes(subjectId)).thenReturn(noteList);

        assertThat(subjectService.noteList(subjectId))
                .hasSize(2);

    }

    @Test
    void changeParaTest() {
        var originalSubject = new Subject(1L, "title", "content", ParaEnum.AREA);

        var targetSubject = new Subject(1L, "title", "content", ParaEnum.RESOURCE);

        when(subjectPort.modifySubject(any())).thenReturn(Optional.of(targetSubject));

        assertThat(subjectService.changePara(originalSubject).para())
                .isEqualTo(ParaEnum.RESOURCE);

    }
}