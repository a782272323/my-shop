package learn.lhb.my.shop.web.admin.controller;

import learn.lhb.my.shop.commons.constant.ConstantUtils;
import learn.lhb.my.shop.domain.UserDomain;
import learn.lhb.my.shop.web.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author 梁鸿斌
 * @date 2020/2/12.
 * @time 11:31 下午
 */
@Controller
public class LoginController {

    public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;


    @GetMapping(value = "login")
    public String login(String email,String password,Model model)   {
        // TODO 最好做个token 验证
//        UserEntity userEntity = userService.adminLogin(email,password);
//        model.addAttribute("userEntity",userEntity);
        model.addAttribute("message","登录失败 !");
        return "login";
    }


    /**
     * 登录业务
     * @param email
     * @param password
     * @param model
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "login")
    public String login(String email, String password, Model model, HttpServletRequest request, HttpServletResponse response)   {
        UserDomain userDomain = null;
        userDomain = userService.adminLogin(email,password);
        if (userDomain == null) {
            // 登录失败
            // TODO 登录失败弹窗提示有bug，可以参考微服务的sso服务的代码逻辑
            logger.error("登录失败");
            model.addAttribute("message","失败！");
//            request.setAttribute("message","用户名或者密码错误!");
            //重新登录
            return "redirect:/login";

        } else {
            // 登录成功
            //登录信息存如会话
            request.getSession().setAttribute(ConstantUtils.SESSION_USER,userDomain);
            return "redirect:/main";
        }

    // TODO 做完这个项目后，把maven笔记完善一下
    }
}
