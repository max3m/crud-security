package web.model;

import lombok.Data;

@Data
public class User {
    int id;
    String name;
    int age;
    String email;


    public User() { }

    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
