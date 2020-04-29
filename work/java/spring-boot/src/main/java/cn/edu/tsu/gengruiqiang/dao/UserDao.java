package cn.edu.tsu.gengruiqiang.dao;

import cn.edu.tsu.gengruiqiang.bean.User;

/**
 * @author Gregorio
 * @date 2020/4/22 10:39
 */
public interface UserDao {
    User findUserById(int id);
    User findByName(String username);
    int insert(User user);
}
