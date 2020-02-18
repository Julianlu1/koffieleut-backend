package server.classes;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="`user`")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User()
    {
    }
}
