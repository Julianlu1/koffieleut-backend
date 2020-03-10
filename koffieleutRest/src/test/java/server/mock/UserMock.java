package server.mock;

import server.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMock {
    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("1", "username1", "name1", "myPassword1", 100));
        userList.add(new User("2", "username2", "name2", "myPassword2", 200));
        userList.add(new User("3", "username3", "name3", "myPassword3", 300));
        return userList;
    }
}
