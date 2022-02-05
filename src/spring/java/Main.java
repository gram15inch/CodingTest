package spring.java;

import spring.DBinfo;

import java.io.Reader;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
      /*  UserDao dao = new UserDao();
        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");
        dao.add(user);

        System.out.println(user.getId());
        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());*/



        System.out.println(DBinfo.USERNAME);
    }
}
