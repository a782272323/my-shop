package learn.lhb.my.shop.web.admin.controller;

import learn.lhb.my.shop.commons.constant.ConstantUtils;
import learn.lhb.my.shop.domain.TbUserDomain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 18:16
 */
@Controller
public class MainController {

//    @GetMapping(value = "main")
//    public String main(
//            @RequestParam(value = "tbUserDomain")TbUserDomain tbUserDomain,
//            Model model
//            )    {
//        if (tbUserDomain == null)   {
//            model.addAttribute(ConstantUtils.WEB_MESSAGE,"获取邮箱失败");
//        }   {
//            model.addAttribute(ConstantUtils.SESSION_USER,tbUserDomain);
//        }
//        return "main";
//    }

    @GetMapping(value = "main")
    public String main()    {
        return "main";
    }
}
