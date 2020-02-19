package learn.lhb.my.shop.web.admin.service;

import learn.lhb.my.shop.commons.dto.BaseResult;
import learn.lhb.my.shop.commons.dto.DataTablePageInfo;
import learn.lhb.my.shop.domain.TbUserDomain;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 23:48
 */
public interface TbUserService {

    /**
     * 查询全部
     * @return
     */
    public List<TbUserDomain> selectAll();

    /**
     * 保存用户信息
     * @param tbUserDomain
     * @return
     */
    BaseResult save(TbUserDomain tbUserDomain);

    /**
     * 删除用户信息
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    TbUserDomain getById(Long id);

    /**
     * 更新用户信息
     * @param tbUserDomain
     */
    void update(TbUserDomain tbUserDomain);


    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUserDomain login(String email,String password);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 邮箱是否重复
     * @param email
     * @return
     */
    boolean findEmail(String email);

    /**
     * 姓名是否重复
     * @param username
     * @return
     */
    boolean findUsername(String username);

    /**
     * 手机号码是否重复
     * @param phone
     * @return
     */
    boolean findPhone(String phone);

    /**
     * 分页查询
     * @param draw
     * @param start
     * @param length
     * @return
     */
    DataTablePageInfo<TbUserDomain> page(int draw,int start, int length,TbUserDomain tbUserDomain);

    /**
     * 分页查询总笔数
     * @return
     */
    int count(TbUserDomain tbUserDomain);

    /**
     * 查询单个用户信息
     * @param id
     * @return
     */
    TbUserDomain detail(Long id);
}
