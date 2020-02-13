package learn.lhb.my.shop.web.admin.service.impl;


import learn.lhb.my.shop.domain.UserDomain;
import learn.lhb.my.shop.web.admin.dao.UserDao;
import learn.lhb.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 11:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDomain adminLogin(String email, String password) {


        return userDao.getUserByUsernameAndPassword(email,password);
    }
}
