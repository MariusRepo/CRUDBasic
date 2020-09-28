package net.noidea.repository;

import net.noidea.model.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    List<User> findByAge(Integer age);

    List<User> findByCountry(String country);
}
