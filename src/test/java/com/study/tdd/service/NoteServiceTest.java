package com.study.tdd.service;

import com.study.tdd.model.Note;
import com.study.tdd.port.NotePort;
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

    @Test
    public void noteCrudTest() {
        // given
        var noteId = 1L;
        // 처음엔 아이디가 없는 노트
        var note = new Note(null, "title", "content");

        // when
        noteService.addNote(note);

        // then
        // verify는 Mockito에서 제공하는 메서드로,
        // 특정 메서드가 호출되었는지, 호출 횟수나 호출 조건이 올바른지 검증할 때 사용됩니다.
        // 이를 통해 테스트 대상 코드가 의도한 대로 동작했는지 확인할 수 있습니다.
        verify(notePort, times(1)).addNote(note);

        // 저장되면 아이디 부여됨
        var savedNote = new Note(noteId, "title", "content");

        // when
        when(notePort.getNote(noteId)).thenReturn(Optional.of(savedNote));

        var resultNote = noteService.getNote(noteId);

        assertThat(resultNote.isPresent()).isTrue();

        // 수정, 삭제

        var modifiedNote = new Note(noteId, "modified title", "modified content");
        noteService.modifyNote(modifiedNote);
        verify(notePort, times(1)).modifyNote(modifiedNote);

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
}