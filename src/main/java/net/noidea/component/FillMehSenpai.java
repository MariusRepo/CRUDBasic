package net.noidea.component;

import com.github.javafaker.Faker;
import net.noidea.model.User;
import net.noidea.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Transactional
public class FillMehSenpai implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        userRepository.save(new User("test", "password", "testFirst", "testLast", 100, "ROMANIA"));
        for (int i = 0; i < 30; i++) {
            Faker fake = new Faker(new Random(i + ThreadLocalRandom.current().nextInt(i, 100 + 1)));
            User user = new User(fake.name().username(),
                    passwordEncoder.encode(fake.pokemon().name().toLowerCase()),
                    fake.name().firstName(),
                    fake.name().lastName(),
                    i + 10,
                    fake.address().country());
            userRepository.save(user);
        }
    }
}
