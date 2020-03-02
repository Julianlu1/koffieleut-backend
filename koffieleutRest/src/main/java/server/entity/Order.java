package server.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="`order`")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="name")
    private String name;

    @Column(name="location")
    private String location;

    @Column(name="code")
    private String code;

    public Order() {
    }

    public Order(int userId, String name, String location, String code) {
        this.userId = userId;
        this.name = name;
        this.location = location;
        this.code = code;
    }
}
