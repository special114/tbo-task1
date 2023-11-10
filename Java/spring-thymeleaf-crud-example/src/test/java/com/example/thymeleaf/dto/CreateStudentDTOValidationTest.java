package com.example.thymeleaf.dto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CreateStudentDTOValidationTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void should_not_return_errors_for_valid_student() {
        // Given
        CreateStudentDTO createStudentDTO = getValidStudent();

        // When
        Set<ConstraintViolation<CreateStudentDTO>> violations = validator.validate(createStudentDTO);

        // Then
        assertTrue(violations.isEmpty());
    }

    @Test
    public void should_not_enable_xss_attack_in_student_name() {
        // Given
        CreateStudentDTO createStudentDTO = getValidStudent();
        createStudentDTO.setName("<script>alert('attack');</script>");

        // When
        Set<ConstraintViolation<CreateStudentDTO>> violations = validator.validate(createStudentDTO);

        // Then
        assertFalse(violations.isEmpty());
    }

    @Test
    public void should_not_enable_xss_attack_in_student_street() {
        // Given
        CreateStudentDTO createStudentDTO = getValidStudent();
        createStudentDTO.setStreet("<script>alert('attack');</script>");

        // When
        Set<ConstraintViolation<CreateStudentDTO>> violations = validator.validate(createStudentDTO);

        // Then
        assertFalse(violations.isEmpty());
    }

    @Test
    public void should_not_enable_xss_attack_in_student_district() {
        // Given
        CreateStudentDTO createStudentDTO = getValidStudent();
        createStudentDTO.setDistrict("<script>alert('attack');</script>");

        // When
        Set<ConstraintViolation<CreateStudentDTO>> violations = validator.validate(createStudentDTO);

        // Then
        assertFalse(violations.isEmpty());
    }

    @Test
    public void should_not_enable_xss_attack_in_student_city() {
        // Given
        CreateStudentDTO createStudentDTO = getValidStudent();
        createStudentDTO.setCity("<script>alert('attack');</script>");

        // When
        Set<ConstraintViolation<CreateStudentDTO>> violations = validator.validate(createStudentDTO);

        // Then
        assertFalse(violations.isEmpty());
    }

    @Test
    public void should_not_enable_xss_attack_in_student_state() {
        // Given
        CreateStudentDTO createStudentDTO = getValidStudent();
        createStudentDTO.setState("<script>alert('attack');</script>");

        // When
        Set<ConstraintViolation<CreateStudentDTO>> violations = validator.validate(createStudentDTO);

        // Then
        assertFalse(violations.isEmpty());
    }

    private CreateStudentDTO getValidStudent() {
        CreateStudentDTO createStudentDTO = new CreateStudentDTO();

        createStudentDTO.setName("Name");
        createStudentDTO.setEmail("aaa@bb.cc");
        createStudentDTO.setBirthday(LocalDate.of(2000, 1, 1));
        createStudentDTO.setZipCode("11111-111");
        createStudentDTO.setStreet("Street");
        createStudentDTO.setNumber("5");
        createStudentDTO.setDistrict("District");
        createStudentDTO.setCity("City");
        createStudentDTO.setState("State");

        return createStudentDTO;
    }
}
