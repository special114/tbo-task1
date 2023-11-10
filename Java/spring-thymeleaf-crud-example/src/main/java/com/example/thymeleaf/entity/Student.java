package com.example.thymeleaf.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "student")
@EqualsAndHashCode(of = {"id"})
public class Student {

    @Id
    private String id;

    @NotNull
    @Size(min = 3, max = 400)
    @Pattern(regexp = "[a-zA-Z- ]*")
    private String name;

    @Size(min = 3, max = 400)
    @Email
    private String email;

    @NotNull
    private LocalDate birthday;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @NotNull
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

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
