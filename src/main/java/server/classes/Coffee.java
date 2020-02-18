package server.classes;

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
}
