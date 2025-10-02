package com.elkabani.firstspringboot.repositories;

import com.elkabani.firstspringboot.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}