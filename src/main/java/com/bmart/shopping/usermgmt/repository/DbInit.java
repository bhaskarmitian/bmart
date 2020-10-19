package com.bmart.shopping.usermgmt.repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bmart.shopping.usermgmt.model.BmartUser;

import java.util.Arrays;
import java.util.List;

@Profile("prod")
@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Crete users
        BmartUser dan = new BmartUser("dan",passwordEncoder.encode("dan123"),"USER","");
        BmartUser admin = new BmartUser("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        BmartUser superadmin = new BmartUser("superadmin",passwordEncoder.encode("superadmin123"),"SUPERADMIN","ACCESS_TEST1");

        List<BmartUser> users = Arrays.asList(dan,admin,superadmin);

        // Save to db
        this.userRepository.saveAll(users);
    }
}