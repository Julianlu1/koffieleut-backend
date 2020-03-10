package server.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="`coffee`")
@Data
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Coffee(String name) {
        this.name = name;
    }

    public Coffee(){}

    public Coffee(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
