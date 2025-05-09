package com.study.tdd.exception;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FieldErrorResponse {
    private String filed;
    private String value;
    private String reason;
}
