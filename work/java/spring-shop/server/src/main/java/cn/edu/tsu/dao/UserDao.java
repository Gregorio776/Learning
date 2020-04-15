package cn.edu.tsu.dao;

import cn.edu.tsu.bean.User;

/**
 * @author Gregorio
 * @date 2020/4/13 10:54
 */
public interface UserDao {

    User getByName(String username);
    int insert(User user);
    User getById(int id);

}
