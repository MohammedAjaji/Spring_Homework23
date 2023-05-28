package com.example.spring_homework21.Service;

import com.example.spring_homework21.ApiException.ApiException;
import com.example.spring_homework21.DTO.AddressDTO;
import com.example.spring_homework21.Model.Address;
import com.example.spring_homework21.Model.Teacher;
import com.example.spring_homework21.Repository.AddressRepository;
import com.example.spring_homework21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public void addAddress(AddressDTO dto){
        Teacher teacher = teacherRepository.findTeacherById(dto.getTeacher_id());
        if (teacher == null){
            throw new ApiException("Cannot add address Teacher Not Found");
        }

        Address address = new Address(null, dto.getArea(), dto.getStreet(), dto.getBuildingNumber(), teacher);

        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO dto){
        Teacher teacher = teacherRepository.findTeacherById(dto.getTeacher_id());
        if (teacher == null){
            throw new ApiException("Cannot add address Teacher Not Found");
        }

        Address oldAddress = teacher.getAddress();

        oldAddress.setArea(dto.getArea());
        oldAddress.setBuildingNumber(dto.getBuildingNumber());
        oldAddress.setStreet(dto.getStreet());

        addressRepository.save(oldAddress);
    }

    public void deleteAddress(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("Cannot add address Teacher Not Found");
        }

        addressRepository.delete(teacher.getAddress());
    }


}
