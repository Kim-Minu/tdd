package com.study.tdd;


import com.study.tdd.model.Note;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssertJTest {

    // BDD
    // Given / When / Then
    // Given : 테스트를 위한 준비
    // When : 테스트를 실행하는 행위
    // Then : 테스트의 결과를 검증하는 행위

    // AssertJ : 자바의 테스트 라이브러리로, BDD 스타일의 문법을 제공
    // assertThat : 검증하고자 하는 객체를 지정
    // isEqualTo : 검증하고자 하는 값과 비교
    // isNotEqualTo : 검증하고자 하는 값과 비교
    // isTrue : boolean 값이 true인지 검증
    // isFalse : boolean 값이 false인지 검증
    // isNull : null인지 검증
    // isNotNull : null이 아닌지 검증
    // isEmpty : 비어있는지 검증
    // isNotEmpty : 비어있지 않은지 검증
    // isIn : 지정한 값 중 하나인지 검증
    // isNotIn : 지정한 값 중 하나가 아닌지 검증
    // hasSize : 컬렉션의 크기를 검증

    @Test
    void bddTest() {
        // Given
        String str = "Hello, World!";

        // When
        boolean result = str.equals("Hello, World!");

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void noteTest() {
        var note = new Note(1L, "title", "content");

        assertThat(note.title()).isNotNull().contains("tit");
        assertThat(note).isInstanceOf(Note.class);


    }


}
