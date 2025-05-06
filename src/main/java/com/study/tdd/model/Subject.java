package com.study.tdd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public record Subject (
     Long subjectId,
     String title,
     String content,
     ParaEnum para
) {}

