package server.dto;

import server.entity.Order;

public class OrderDto {

private int id;
private String username;
private String location;
private String code;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.username = order.getUser().getName();
        this.location = order.getLocation();
        this.code = order.getCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
