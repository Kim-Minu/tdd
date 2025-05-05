package com.study.tdd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ParaEnum {

    PROJECT("project"),
    AREA("area"),
    RESOURCE("resource"),
    ARCHIVE("archive"),
    ;

    private final String value;

    @Override
    public String toString() {
        return "ParaEnum{" +
                "value='" + value + '\'' +
                '}';
    }
}
