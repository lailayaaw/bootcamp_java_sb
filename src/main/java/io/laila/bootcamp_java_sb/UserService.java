package io.laila.bootcamp_java_sb;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer, String> userLists = new HashMap<>();

    @PostConstruct
    private void onConstructed() {
        userLists.put(1, "Alice");
        userLists.put(2, "Bob");
        userLists.put(3, "Charlie");
        userLists.put(4, "Mamat");
        userLists.put(5, "Ujang");
        userLists.put(6, "Diana");
    }

    public String findUser(Integer userId) {
        return this.userLists.get(userId);
    }
}
