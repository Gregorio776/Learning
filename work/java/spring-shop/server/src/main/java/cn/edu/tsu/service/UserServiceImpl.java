package cn.edu.tsu.service;

import cn.edu.tsu.bean.User;
import cn.edu.tsu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gregorio
 * @date 2020/4/13 11:06
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String username, String password) {
        return userDao.getByName(username);
    }

    @Override
    @Transactional
    public int register(User user) {
        User res = userDao.getByName(user.getUsername());
        if(res==null){
            return userDao.insert(user);
        }
        return 0;
    }
}
