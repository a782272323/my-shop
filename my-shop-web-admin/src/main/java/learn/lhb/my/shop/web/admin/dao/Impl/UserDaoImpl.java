package learn.lhb.my.shop.web.admin.dao.Impl;

import learn.lhb.my.shop.domain.UserDomain;
import learn.lhb.my.shop.web.admin.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 11:03
 */
@Repository
public class UserDaoImpl implements UserDao {

    public static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public UserDomain getUserByUsernameAndPassword(String email, String password) {
        logger.debug("调用 getUser(),email:{},password:{}",email,password);

        UserDomain userDomain = null;

        if ("test@qq.com".equals(email))    {
            if ("admin".equals(password)) {
                userDomain = new UserDomain();
                userDomain.setEmail("test@qq.com");
                userDomain.setUsername("LHB");

                logger.info("成功获取 \"{}\" 的用户信息",userDomain.getUsername());
            }
        }   else {
            logger.warn("获取 \"{}\" 的用户信息失败",email);
        }

        return userDomain;
    }
}
