package cn.edu.tsu.gengruiqiang.dao;

import cn.edu.tsu.gengruiqiang.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/**
 * @author Gregorio
 * @date 2020/4/22 10:40
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findUserById(int id) {
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

    @Override
    public User findByName(String username) {
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
}
