package learn.lhb.my.shop.web.admin.dao;


import learn.lhb.my.shop.domain.UserDomain;

/**
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 10:41
 */
public interface UserDao {

    /**
     * 根据邮箱和密码获取用户名
     * @param email
     * @param password
     * @return
     */
    public UserDomain getUserByUsernameAndPassword(String email, String password);
}
