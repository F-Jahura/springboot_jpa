package com.springboot.data_jpa.dto;

import com.springboot.data_jpa.entity.Person;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PersonValidation {
    @NotEmpty(message = "There is no name. Please add name.")
    private String name;

    @Pattern(regexp = "^7\\d{10}", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE}, message = "The mobile number should start with 7 and there must have 11 digits.")
    private String mobile;

    @Pattern(regexp = "^[A-Z]{1}[A-Za-z0-9]{7,9}$", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE}, message = "password should be between 8 and 10 characters and it must start with capital letter.")
    private String password;

    @Valid
    @NotNull(message = "The passport details should be filled.")
    private PassportValidation passportValidation;

    public Person toPerson(){
        Person person = new Person();
        person.setName(name);
        person.setMobile(mobile);
        person.setPassword(password);
        person.setPassport(passportValidation.toPassport());
        return person;
    }

}
