package learn.lhb.my.shop.web.admin.dao;

import learn.lhb.my.shop.domain.TbUserDomain;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 22:55
 */
@Repository
@MapperScan
public interface TbUserDao {

    /**
     * 查询全部用户信息
     *
     * @return
     */
    public List<TbUserDao> selectAll();

    /**
     * 添加用户
     * @param tbUserDomain
     */
    void insert(TbUserDomain tbUserDomain);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 修改
     * @param tbUserDomain
     */
    void update(TbUserDomain tbUserDomain);

    /**
     * 根据用户名进行模糊匹配
     * @param username
     * @return
     */
    List<TbUserDomain> selectByUsername(String username);

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUserDomain getByEmail(String email);

    /**
     * 根据用户编号查询用户信息
     * @param id
     * @return
     */
    TbUserDomain getById(String id);
}
