package learn.lhb.my.shop.web.admin.service.impl;

import learn.lhb.my.shop.commons.constant.ConstantUtils;
import learn.lhb.my.shop.domain.TbUserDomain;
import learn.lhb.my.shop.web.admin.dao.TbUserDao;
import learn.lhb.my.shop.web.admin.service.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
        return null;
    }

    @Override
    public void insert(TbUserDomain tbUserDomain) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TbUserDomain getById(Long id) {
        return null;
    }

    @Override
    public void update(TbUserDomain tbUserDomain) {

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
}
