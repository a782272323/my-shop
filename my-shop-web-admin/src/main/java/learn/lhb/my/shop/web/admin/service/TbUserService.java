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

    public List<TbUserDomain> selectAll();

    BaseResult save(TbUserDomain tbUserDomain);

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

    /**
     * 搜索功能
     * @param tbUserDomain
     * @return
     */
    List<TbUserDomain> search(TbUserDomain tbUserDomain);

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
    DataTablePageInfo<TbUserDomain> page(int draw,int start, int length);

    /**
     * 分页查询总笔数
     * @return
     */
    int count();

    /**
     * 查询单个用户信息
     * @param id
     * @return
     */
    TbUserDomain detail(Long id);
}
