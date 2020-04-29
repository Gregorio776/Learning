package cn.edu.tsu.gengruiqiang.service;

import cn.edu.tsu.gengruiqiang.bean.User;
import cn.edu.tsu.gengruiqiang.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gregorio
 * @date 2020/4/22 10:42
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        User u = userDao.findByName(username);
        if(u!=null){
            if(u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    @Override
    public User info(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public int reg(User user) {
        User u = userDao.findByName(user.getUsername());
        if(u!=null){
            return 0;
        }
        return userDao.insert(user);
    }
}
