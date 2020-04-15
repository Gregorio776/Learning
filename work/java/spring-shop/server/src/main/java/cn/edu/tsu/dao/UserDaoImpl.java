package cn.edu.tsu.dao;

import cn.edu.tsu.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/**
 * @author Gregorio
 * @date 2020/4/13 10:56
 */
@Repository
public class UserDaoImpl implements UserDao  {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getByName(String username) {
        return (User) jdbcTemplate.query("select * from user where username = ?", new Object[]{username}, (ResultSetExtractor<Object>) resultSet -> {
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setAge(resultSet.getInt("age"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
            return user;
        });
    }

    @Override
    public int insert(User user) {
        return jdbcTemplate.update("insert into user (username,password,age)values(?,?,?)",
               user.getUsername(),user.getPassword(),user.getAge());
    }

    @Override
    public User getById(int id) {
        return (User) jdbcTemplate.query("select * from user where id = ?", new Object[]{id}, (ResultSetExtractor<Object>) resultSet -> {
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setAge(resultSet.getInt("age"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
            return user;
        });
    }
}
