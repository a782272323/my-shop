package learn.lhb.my.shop.web.admin.service;

import learn.lhb.my.shop.domain.TbUserDomain;

import java.util.List;

/**
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 23:48
 */
public interface TbUserService {

    public List<TbUserDomain> selectAll();

    void insert(TbUserDomain tbUserDomain);

    void delete(Long id);

    TbUserDomain getById(Long id);

    void update(TbUserDomain tbUserDomain);

    List<TbUserDomain> selectByUsername(String username);

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUserDomain login(String email,String password);
}