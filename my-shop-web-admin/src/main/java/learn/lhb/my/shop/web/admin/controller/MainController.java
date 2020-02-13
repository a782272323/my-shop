package learn.lhb.my.shop.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 18:16
 */
@Controller
public class MainController {

    @GetMapping(value = "main")
    public String main()    {
        return "main";
    }
}
