package com.example.thymeleaf.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class CreateStudentDTO {

    @NotEmpty(message = "{NotEmpty.name}")
    @Size(min = 3, max = 400, message = "{Size.name}")
    @Pattern(regexp = "[a-zA-Z- ]*", message = "{Pattern.name}")
    private String name;

    @Email
    @NotEmpty(message = "{NotEmpty.email}")
    private String email;

    @NotNull(message = "{NotNull.birthday}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotEmpty(message = "{NotEmpty.zipCode}")
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$")
    private String zipCode;

    @NotEmpty(message = "{NotEmpty.street}")
    @Size(min = 3, max = 400, message = "{Size.street}")
    @Pattern(regexp = "[a-zA-Z- ]*", message = "{Pattern.street}")
    private String street;

    @NotEmpty(message = "{NotEmpty.number}")
    @Size(min = 1, max = 5, message = "{Size.number}")
    @Pattern(regexp = "[0-9]+", message = "{Pattern.number}")
    private String number;

    @Size(min = 3, max = 800, message = "{Size.complement}")
    @Pattern(regexp = "[a-zA-Z0-9- ]*", message = "{Pattern.complement}")
    private String complement;

    @NotEmpty(message = "{NotEmpty.district}")
    @Size(min = 3, max = 400, message = "{Size.district}")
    @Pattern(regexp = "[a-zA-Z- ]*", message = "{Pattern.district}")
    private String district;

    @NotEmpty(message = "{NotEmpty.city}")
    @Size(min = 3, max = 400, message = "{Size.city}")
    @Pattern(regexp = "[a-zA-Z- ]*", message = "{Pattern.city}")
    private String city;

    @NotEmpty(message = "{NotEmpty.state}")
    @Size(min = 3, max = 400, message = "{Size.state}")
    @Pattern(regexp = "[a-zA-Z- ]*", message = "{Pattern.state}")
    private String state;

}
