package com.study.tdd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    private Long subjectId;
    private String title;
    private String content;
    private ParaEnum para;
}
