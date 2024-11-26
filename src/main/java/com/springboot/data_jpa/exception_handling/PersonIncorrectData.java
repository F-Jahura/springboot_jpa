package com.springboot.data_jpa.exception_handling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonIncorrectData {
    private String info;

    public PersonIncorrectData() {
    }
}
