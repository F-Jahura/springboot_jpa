package com.springboot.data_jpa.dto;


import com.springboot.data_jpa.entity.Passport;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PassportValidation {

    @Pattern(regexp = "\\d{4}", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE}, message = "In passport series must be 4 digits.")
    private String series;

    @Pattern(regexp = "\\d{6}", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE}, message = "In passport number must be 6 digits.")
    //@Min(value = 6, message = "number is not 6")
    private String number;

    public Passport toPassport(){
        Passport passport = new Passport();
        passport.setSeries(series);
        passport.setNumber(number);
        return passport;
    }
}
