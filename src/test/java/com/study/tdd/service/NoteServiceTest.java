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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NoteServiceTest {

    @InjectMocks
    NoteService noteService;

    @Mock
    NotePort notePort;

    @Mock
    SubjectPort subjectPort;

    @Test
    public void noteCrudTest() {
        // given
        var noteId = 1L;
        // 처음엔 아이디가 없는 노트
        var note = new Note(null, "title", "content");

        when(notePort.addNote(any())).thenReturn(Optional.of(
                new Note(noteId, "title", "content")
        ));

        // when
        assertThat(noteService.addNote(any()))
                .isInstanceOf(Note.class);

        // then
        // verify는 Mockito에서 제공하는 메서드로,
        // 특정 메서드가 호출되었는지, 호출 횟수나 호출 조건이 올바른지 검증할 때 사용됩니다.
        // 이를 통해 테스트 대상 코드가 의도한 대로 동작했는지 확인할 수 있습니다.
        //verify(notePort, times(1)).addNote(note);

        // 저장되면 아이디 부여됨
        var savedNote = new Note(noteId, "title", "content");

        // when
        when(notePort.getNote(noteId)).thenReturn(Optional.of(savedNote));

        assertThat(noteService.getNote(noteId)).isInstanceOf(Note.class);

        // 수정, 삭제
        var modifiedNote = new Note(noteId, "modified title", "modified content");

        when(notePort.modifyNote(any())).thenReturn(Optional.of(modifiedNote));

        assertThat(noteService.modifyNote(modifiedNote)).isInstanceOf(Note.class);
        //verify(notePort, times(1)).modifyNote(modifiedNote);

        //assertThat(noteService.removeNote(noteId)).isInstanceOf(Note.class);
        noteService.removeNote(noteId);
        verify(notePort, times(1)).removeNote(noteId);


    }

    @Test
    public void noteListTest() {
        // given

        String title = "title";

        var mockList = List.of(
                new Note(1L, "title", "content1"),
                new Note(2L, "title", "content2"),
                new Note(3L, "title", "content3")
        );

        when(notePort.noteList(any())).thenReturn(mockList);

        var noteList = noteService.noteList(title);

        assertThat(noteList).hasSize(3);

    }

    @Test
    void subjectInNoteTest() {
        // given
        // when
        Long subjectId = 1L;
        Long noteId = 1L;

        var mockSubjectList = List.of(
                new Subject(1L, "subject1", "content1", ParaEnum.AREA),
                new Subject(2L, "subject2", "content2", ParaEnum.AREA),
                new Subject(3L, "subject3", "content3", ParaEnum.RESOURCE)
        );

        when(subjectPort.subjectList(any())).thenReturn(mockSubjectList);

        assertThat(noteService.registSubject(1L, 1L)).hasSize(3);

        verify(subjectPort, times(1)).registSubject(noteId, subjectId);


        var mockRemoveList = List.of(
                new Subject(2L, "subject2", "content2", ParaEnum.AREA),
                new Subject(3L, "subject3", "content3", ParaEnum.RESOURCE)
        );
        when(subjectPort.subjectList(any())).thenReturn(mockRemoveList);
        assertThat(noteService.removeSubject(noteId, subjectId)).hasSize(2);


        var mockFinalList = List.of(
                new Subject(2L, "subject2", "content2", ParaEnum.AREA),
                new Subject(3L, "subject3", "content3", ParaEnum.RESOURCE)
        );

        when(subjectPort.subjectList(any())).thenReturn(mockFinalList);

        assertThat(noteService.subjectList(noteId)).hasSize(2);

        //noteService.removeSubject();

        //noteService.subjectList();
        // then
    }
}