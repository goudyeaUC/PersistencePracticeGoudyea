package com.elkabani.firstspringboot.repositories;

import com.elkabani.firstspringboot.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}