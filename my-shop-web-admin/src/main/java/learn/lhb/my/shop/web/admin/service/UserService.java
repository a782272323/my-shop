package learn.lhb.my.shop.web.admin.service;


import learn.lhb.my.shop.domain.UserDomain;

/**
 * 用户(后台管理人员)
 *
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 10:40
 */
public interface UserService {

    public UserDomain adminLogin(String email, String password);
}
