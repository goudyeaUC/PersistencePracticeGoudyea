package com.elkabani.firstspringboot;

import com.elkabani.firstspringboot.entities.Address;
import com.elkabani.firstspringboot.entities.Category;
import com.elkabani.firstspringboot.entities.Product;
import com.elkabani.firstspringboot.entities.User;
import com.elkabani.firstspringboot.repositories.UserRepository;
import com.elkabani.firstspringboot.services.CategoryService;
import com.elkabani.firstspringboot.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringBootApplication {

    public static void main(String[] args)
    {
     ApplicationContext context =  SpringApplication.run(FirstSpringBootApplication.class, args);

     //var userRepository = context.getBean(UserRepository.class);
        var userService = context.getBean(UserService.class);
        userService.showEntityState();
        userService.showRelatedEntities();

        var categoryService = context.getBean(CategoryService.class);

        Category Electronics = new Category(null, "Electronics", null);
        Product headphones = new Product(null, "Headphones", "On-ear headphones", 19.72, null);
        Product monitor = new Product(null, "Monitor", "1080p diplay", 109.86, null);
        categoryService.createProductInNewCategory(headphones, Electronics);
        categoryService.createProductInExistingCategory(monitor, Electronics);
        // nnbcategoryService.deleteProduct();

     //   userService.persistRelated();
          //userService.deleteRelated();

   //     var orderService = context.getBean(OrderService.class);
       // var orderservice2 = context.getBean(OrderService.class);
      //var  orderService = new OrderService(new StripePaymentService());
   //     orderService.placeOrder();
       // orderservice2.placeOrder();
     //   var user1 = new User(1L, "John Doe", "jDoe@email.com", "1234");

/*        var user1 = User.builder()
                .name("Jane Smith")
                .email("jSmith@emial.com")
                .password("abcd")
                .build();

       // userRepository.save(user1);
        var user2 = userRepository.findById(2L).orElseThrow();
        System.out.println(user2.getEmail());

        userRepository.deleteById(1L);

        var users = userRepository.findAll();
      users.forEach(u -> System.out.println(u.getName()));

        var address1 = Address.builder()
                .street("123 Main St")
                .city("Springfield")
                .state("IL")
                .zipCode("62701")
                .build();

        user1.addAddress(address1);

        System.out.println(user1); */
    }

}
