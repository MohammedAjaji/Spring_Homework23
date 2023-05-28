package com.example.spring_homework21.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "age cannot be empty")
    @Min(value = 18,message = "age have to be 18+")
    @Column(columnDefinition = "int default 0")
    private Integer age;

    @NotEmpty(message = "email cannot be empty")
    @Email
    @Column(columnDefinition = "varchar(20) not null")
    private String email;

    @NotNull(message = "salary cannot be empty")
    @Column(columnDefinition = "double default 0")
    private double salary;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

}
