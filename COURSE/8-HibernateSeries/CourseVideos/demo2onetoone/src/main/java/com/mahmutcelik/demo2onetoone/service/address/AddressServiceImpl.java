package com.mahmutcelik.demo2onetoone.service.address;

import com.mahmutcelik.demo2onetoone.model.Address;
import com.mahmutcelik.demo2onetoone.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Address addNewAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address, Long id) {
        return addressRepository.findById(id).map(e-> addressRepository.save(address)).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
