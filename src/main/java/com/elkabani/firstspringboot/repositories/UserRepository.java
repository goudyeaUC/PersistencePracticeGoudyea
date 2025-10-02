package com.elkabani.firstspringboot.repositories;

import com.elkabani.firstspringboot.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
