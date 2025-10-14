package com.elkabani.firstspringboot.services;

import com.elkabani.firstspringboot.entities.Address;
import com.elkabani.firstspringboot.entities.User;
import com.elkabani.firstspringboot.repositories.ProfileRepository;
import com.elkabani.firstspringboot.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;

    @Transactional
    public void showEntityState()
    {
        var user = User.builder()
                .name("James Mark")
                .email("jmark@email.com")
                .password("james123")
                .build();
        if(entityManager.contains(user))
        {
            System.out.println("Persistent");
        }
        else
        {
            System.out.println("Transient / Detached");
        }

        userRepository.save(user);

        if(entityManager.contains(user))
        {
            System.out.println("Persistent");
        }
        else
        {
            System.out.println("Transient / Detached");
        }
    }

    @Transactional
    public void showRelatedEntities()
    {
      //  var user = userRepository.findById(3L).orElseThrow();
    //    System.out.println(user.getEmail());
        var profile = profileRepository.findById(3L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void persistRelated()
    {
        var user = User.builder()
                .name("Alice Johnson")
                .email("ajohnson@email.com")
                .password("alicepwd")
                .build();
        var address = Address.builder()
                .street("456 Elm St")
                .city("Metropolis")
                .state("NY")
                .zipCode("10001")
                .build();
        var address1 = Address.builder()
                .street("789 Oak St")
                .city("Metropolis")
                .state("NY")
                .zipCode("10002")
                .build();
        user.addAddress(address);
        user.addAddress(address1);
        userRepository.save(user);
    }
    @Transactional
    public void deleteRelated()
    {
      //  userRepository.deleteById(13L);
       var user = userRepository.findById(11L).orElseThrow();
       var address = user.getAddresses().getFirst();
       user.removeAddress(address);
         userRepository.save(user);
   }
}
