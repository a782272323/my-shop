package learn.lhb.my.shop.web.admin.controller;

import learn.lhb.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理
 *
 * @author 梁鸿斌
 * @date 2020/2/15.
 * @time 00:35
 */
@Controller
@RequestMapping(value = "user")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    /**
     * 跳转到用户列表页
     * @return
     */
    @GetMapping("list")
    public String list()    {
        return "user_list";
    }
}
