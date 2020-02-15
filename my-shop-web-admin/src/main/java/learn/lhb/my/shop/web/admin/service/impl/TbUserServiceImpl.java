package learn.lhb.my.shop.web.admin.service.impl;

import learn.lhb.my.shop.commons.constant.ConstantUtils;
import learn.lhb.my.shop.commons.dto.BaseResult;
import learn.lhb.my.shop.commons.utils.IsRegexpUtils;
import learn.lhb.my.shop.domain.TbUserDomain;
import learn.lhb.my.shop.web.admin.dao.TbUserDao;
import learn.lhb.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 23:49
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    public static final Logger logger = LoggerFactory.getLogger(TbUserServiceImpl.class);

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public List<TbUserDomain> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public BaseResult save(TbUserDomain tbUserDomain) {
        BaseResult baseResult = checkTbUser(tbUserDomain);

        // 通过非空验证
        if (baseResult.getStatus() == BaseResult.STATUS_OK)    {

            // 修改时间
            tbUserDomain.setUpdated(new Date());
            // 新增用户
            if (tbUserDomain.getId() == null)   {
                // 密码加密处理
                tbUserDomain.setPassword(DigestUtils.md5DigestAsHex(tbUserDomain.getPassword().getBytes()));
                // 创建时间
                tbUserDomain.setCreated(new Date());
                tbUserDao.insert(tbUserDomain);
            } else { // 编辑用户
                tbUserDao.update(tbUserDomain);
            }

            baseResult.setMessage("保存用户成功");
        }

        return baseResult;
    }

    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUserDomain getById(Long id) {
        return null;
    }

    @Override
    public void update(TbUserDomain tbUserDomain) {
        tbUserDao.update(tbUserDomain);
    }

    @Override
    public List<TbUserDomain> selectByUsername(String username) {
        return null;
    }

    @Override
    public TbUserDomain login(String email, String password) {

        TbUserDomain tbUserDomain = tbUserDao.getByEmail(email);
        if (tbUserDomain != null) {
            // TODO md5 加密和用法做笔记
            // 明文密码加密
            logger.debug("\"{}\" 不为空", ConstantUtils.SESSION_USER);
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            // 判断加密后的密码是否匹配
            if (md5Password.equals(tbUserDomain.getPassword())) {
                logger.debug("密码匹配 !");
                return tbUserDomain;
            }
        }

        return null;
    }

    /**
     * 用户信息的有效性验证
     * @param tbUserDomain
     */
    private BaseResult checkTbUser(TbUserDomain tbUserDomain) {
        // TODO 有空把 StringUtils 的用法和源码 的笔记完善下 使用 common.lang3 下面的 StringUtils

        // 默认用户信息是有效的
        BaseResult baseResult = BaseResult.ok();

        // 使用 common.lang3 下面的 StringUtils

        // 邮箱 email 非空验证
        if(StringUtils.isBlank(tbUserDomain.getEmail())) {
            baseResult = BaseResult.error(500,"邮箱不能为空,请重新输入");
        }
        // 验证邮箱格式
        else if(!IsRegexpUtils.checkEmail(tbUserDomain.getEmail())) {
            baseResult = BaseResult.error("邮箱格式不正确，请重新输入");
        }
        // 密码 password 非空验证
        else if(StringUtils.isBlank(tbUserDomain.getPassword())) {
            baseResult = BaseResult.error(500,"密码不能为空,请重新输入");
        }
        // 用户姓名 username 非空验证
        else if (StringUtils.isBlank(tbUserDomain.getUsername()))   {
            baseResult = BaseResult.error(500,"姓名不能为空,请重新输入");
        }
        // 手机号 phone 非空验证
        else if(StringUtils.isBlank(tbUserDomain.getPhone())) {
            baseResult = BaseResult.error(500,"手机号不能为空,请重新输入");
        }
        // 手机格式验证
        else if (!IsRegexpUtils.checkPhone(tbUserDomain.getPhone())) {
            baseResult = BaseResult.error("手机格式不正确，请重新输入");
        }


        return baseResult;
    }
}

// TODO 做一个springMVC 与 thymeleaf的表单标签库 的 笔记