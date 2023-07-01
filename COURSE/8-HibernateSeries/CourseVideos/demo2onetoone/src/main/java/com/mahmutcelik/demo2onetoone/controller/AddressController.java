package com.mahmutcelik.demo2onetoone.controller;

import com.mahmutcelik.demo2onetoone.model.Address;
import com.mahmutcelik.demo2onetoone.service.address.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    private List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/address/{id}")
    private Address getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @PostMapping("/address")
    private Address addNewAddress(@RequestBody Address address){
        return addressService.addNewAddress(address);
    }

    @PutMapping("/address/{id}")
    private Address updateAddress(@RequestBody Address address,@PathVariable Long id){
        return addressService.updateAddress(address,id);
    }

    @DeleteMapping("/address/{id}")
    private void deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
    }
}
