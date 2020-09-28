package net.noidea.component;

import com.github.javafaker.Faker;
import net.noidea.model.User;
import net.noidea.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

import java.util.Random;

@Component
@Transactional
public class FillMehSenpai implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        for (int i = 0; i < 10; i++) {
            Faker fake = new Faker(new Random(i + 10));
            User user = new User(fake.name().username(), fake.name().firstName(), fake.name().lastName(), i + 10, fake.address().country());
            userRepository.save(user);
        }
    }
}
