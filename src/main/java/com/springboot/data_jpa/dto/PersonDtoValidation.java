package com.springboot.data_jpa.dto;

import com.springboot.data_jpa.entity.Passport;
import com.springboot.data_jpa.entity.Person;
import lombok.Data;
import org.springframework.data.repository.query.Param;

//@Data
public class PersonDtoValidation {
    /*@NotBlank(message = "name field is empty!")
    private String name;

    @Max(11)
    @NotBlank(message = "telephone number does not match required format")
    private String mobile;

    @Min(8)
    @Max(10)
    @NotBlank(message = "password does not match required format")
    private String password;

    @Valid
    @NotNull(message = "passport details are required")
    private PassportDtoValidation passportValidation;

    public Person toPerson(){
        Person person = new Person();
        person.setName(name);
        person.setMobile(mobile);
        person.setPassword(password);
        person.setPassport(passportValidation.toPassport());
        return person;
    }*/

}
