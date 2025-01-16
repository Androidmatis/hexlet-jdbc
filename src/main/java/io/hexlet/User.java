package io.hexlet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    Long id;
    String username;
    String phone;
    public User(String username, String phone) {
        this.username = username;
        this.phone = phone;
    }
}
