package entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    public User() {
    }

    public User(String name, int age, String email, String role) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.role = role;
    }

    public User(int id, String name, int age, String email, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
