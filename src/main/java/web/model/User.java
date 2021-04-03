package web.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @Column
    int age;

    @Column
    String email;

    public User() { }

    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
