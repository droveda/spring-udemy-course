package com.droveda.myrestapi.service;

import com.droveda.myrestapi.exception.UserNotFound;
import com.droveda.myrestapi.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static int usersCount = 0;

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Kim", LocalDate.now().minusYears(20)));
    }

    public List<User> getUsers() {
        return users;
    }

    public User findById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFound("User not found!"));
    }

    public User addUser(User user) {
        user.setId(++usersCount);
        users.add(user);

        return user;
    }

    public void deleteById(int id) {
        users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFound("User not found!"));
        users.removeIf(u -> u.getId() == id);
    }
}
