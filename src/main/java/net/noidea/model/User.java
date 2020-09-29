package net.noidea.model;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String firstName, lastName;
    @NotNull
    private Integer age;
    @NotNull
    private String country;

    public User(String username, String password, String firstName, String lastName, Integer age, String country) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }
}