package com.example.thymeleaf.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "address")
@EqualsAndHashCode(of = {"id"})
public class Address {

    @Id
    private String id;

    @NotNull
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$")
    @Column(name = "zip_code")
    private String zipCode;

    @NotNull
    @Size(min = 1)
    @Pattern(regexp = "[0-9]+")
    private String street;

    @NotNull
    @Size(min = 1, max = 5)
    @Pattern(regexp = "[0-9]+")
    private String number;

    @Size(min = 3, max = 800)
    @Pattern(regexp = "[a-zA-Z0-9- ]*")
    private String complement;

    @NotNull
    @Size(min = 3, max = 400)
    @Pattern(regexp = "[a-zA-Z- ]*")
    private String district;

    @NotNull
    @Size(min = 3, max = 400)
    @Pattern(regexp = "[a-zA-Z- ]*")
    private String city;

    @NotNull
    @Size(min = 3, max = 400)
    @Pattern(regexp = "[a-zA-Z- ]*")
    private String state;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "fk_student")
    private Student student;

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
