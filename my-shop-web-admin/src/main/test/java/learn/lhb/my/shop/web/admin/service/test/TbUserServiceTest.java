package learn.lhb.my.shop.web.admin.service.test;


import learn.lhb.my.shop.domain.TbUserDomain;
import learn.lhb.my.shop.web.admin.WebAdminApplication;
import learn.lhb.my.shop.web.admin.dao.TbUserDao;
import learn.lhb.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @author 梁鸿斌
 * @date 2020/2/14.
 * @time 01:48
 */
//@RunWith(Runner.class) TODO 我也不知道为啥错，到时一起整理到 springboot 的单元测试笔记里
@SpringBootTest(classes = WebAdminApplication.class)
public class TbUserServiceTest {
    public static final Logger logger = LoggerFactory.getLogger(TbUserServiceTest.class);

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbUserDao tbUserDao;

    @Test
    public void testMD5()   {
        String password = "123456";
        logger.debug(DigestUtils.md5DigestAsHex(password.getBytes()));
    }

    @Test
    public void testGetByEmail()    {
        String email = "LHB@qq.com";
        TbUserDomain tbUserDomain = tbUserDao.getByEmail(email);
        logger.debug("用户名: \"{}\" ",tbUserDomain.getUsername());
    }


    @Test
    public void testSelectAll() {
        List<TbUserDomain> tbUsers = tbUserDao.selectAll();
        for (TbUserDomain tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

}
