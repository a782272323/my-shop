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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author 梁鸿斌
 * @date 2020/2/14.
 * @time 01:48
 */
@RunWith(SpringRunner.class) //TODO 整理到 springboot 的单元测试笔记里,报错原因，SpringRunner.class正常 Runner.class 错误
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
        List<TbUserDomain> tbUsers = tbUserService.selectAll();
        for (TbUserDomain tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void getById()   {
        Long id = Long.valueOf(37);
        TbUserDomain tbUserDomain = tbUserDao.getById(id);
        System.out.println(tbUserDomain.getUsername());
    }

    @Test
    public void delete()    {
        tbUserDao.delete(Long.valueOf(1));
    }

    @Test
    public void testsave()  {
        TbUserDomain tbUserDomain = new TbUserDomain();
        tbUserDomain.setEmail("1@163.com");
        tbUserDomain.setUsername("test1");
        tbUserDomain.setPassword("1234");
        tbUserDomain.setCreated(new Date());
        tbUserDomain.setPhone("12345678900");
        tbUserDomain.setUpdated(new Date());
        tbUserService.save(tbUserDomain);
    }

    @Test
    public void find()  {

        if (tbUserService.findEmail("LHBdfs@qq.com") == true) {
            System.out.println("重复");
        } else {
            System.out.println("不重复");
        }
    }

    @Test
    public void detailTest()    {
        Long id = Long.valueOf(17);
        TbUserDomain tbUserDomain = tbUserService.detail(id);
        System.out.println(tbUserDomain.getId());
        System.out.println(tbUserDomain.getPhone());
        System.out.println(tbUserDomain.getUsername());
        System.out.println(tbUserDomain.getEmail());
        System.out.println(tbUserDomain.getCreated());
        System.out.println(tbUserDomain.getUpdated());
    }

}
