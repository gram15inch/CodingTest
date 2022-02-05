package spring.java;


import spring.java.dao.UserDao;
import spring.java.domain.User;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new UserDao();
        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");
        dao.add(user);

        System.out.println(user.getId());
        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());


    }
}
