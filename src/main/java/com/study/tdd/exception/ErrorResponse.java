package com.study.tdd.exception;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String message;
    private int status;
    private List<FieldErrorResponse> errors = new ArrayList<>();
    private String code;

}
