package com.example.spring_homework21.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Address {

    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    private String area;

    @Column(columnDefinition = "varchar(20) not null")
    private String Street;

    @Column(columnDefinition = "varchar(20) not null")
    private String buildingNumber;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
