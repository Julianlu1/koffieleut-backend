package server.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="score")
@Data
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "points")
    private int points;

    public Score(int userId, int points) {
        this.userId = userId;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
