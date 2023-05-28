package com.example.spring_homework21.Controller;


import com.example.spring_homework21.DTO.AddressDTO;
import com.example.spring_homework21.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO dto){
        addressService.addAddress(dto);
        return ResponseEntity.status(200).body("Address added");
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO dto){
        addressService.updateAddress(dto);
        return ResponseEntity.status(200).body("Address updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Address deleted");
    }



}
