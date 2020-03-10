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

    @ManyToOne
    private User user;


    @Column(name="location")
    private String location;

    @Column(name="code")
    private String code;

    public Order() {
    }

    public Order(int id, User user, String location, String code) {
        this.user = user;
        this.location = location;
        this.code = code;
    }

    public Order(User user, String location, String code) {
        this.user = user;
        this.location = location;
        this.code = code;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
