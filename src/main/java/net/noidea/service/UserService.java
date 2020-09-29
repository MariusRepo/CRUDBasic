package net.noidea.service;

import net.noidea.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Page<User> findAll(Pageable pageable);
    Optional<User> findById(Long id);
    void addUser(User user);
    Optional<User> delete(Long id);
    Optional<User> update(User user);
    List<User> findByCriteria(String criteria, String searchItem);
}
