package learn.lhb.my.shop.web.admin.controller;

import learn.lhb.my.shop.commons.constant.ConstantUtils;
import learn.lhb.my.shop.domain.TbUserDomain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 18:16
 */
@Controller
//@RequestMapping(value = "v1.0")   TODO 加了访问 静态资源失效，bug未解决
public class MainController {

    @GetMapping(value = "main")
    public String main()    {
        return "main";
    }
}
