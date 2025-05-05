package com.study.tdd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


public record Note (
     Long noteId,
     String title,
     String content
) {}
