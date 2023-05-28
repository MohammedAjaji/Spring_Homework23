package com.example.spring_homework21.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {


    private Integer teacher_id;

    @NotEmpty(message = "area cannot be empty")
    private String area;

    @NotEmpty(message = "Street cannot be empty")
    private String Street;

    @NotEmpty(message = "buildingNumber cannot be empty")
    private String buildingNumber;
}
