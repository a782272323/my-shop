package learn.lhb.my.shop.web.admin.controller;

import learn.lhb.my.shop.commons.constant.ConstantUtils;
import learn.lhb.my.shop.commons.utils.CookieUtils;
import learn.lhb.my.shop.domain.TbUserDomain;
import learn.lhb.my.shop.web.admin.service.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * 登录模块
 *
 * @author 梁鸿斌
 * @date 2020/2/12.
 * @time 11:31 下午
 */
@Controller
//@RequestMapping(value = "v1.0")   TODO 加了访问 静态资源失效，bug未解决
public class LoginController {

    // 日志
    public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private TbUserService tbUserService;

    @GetMapping("test1")
    public String test1()   {
        return "test1";
    }

    /**
     * 跳转登录页
     * @return
     */
    @GetMapping(value = "login")
    public String login()   {
        // TODO 最好做个token 验证

        return "login";
    }



    /**
     * TODO 登录业务(暂时只有邮件登录，手机登录往后看情况改)
     * @param email
     * @param password
     * @param model
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = {"","login"})
    public String login(
            @RequestParam(required = true,value = "email") String email,
            @RequestParam(required = true,value = "password") String password,
            HttpServletRequest request, HttpServletResponse response, Model model,
            RedirectAttributes redirectAttributes)   {

        TbUserDomain tbUserDomain = tbUserService.login(email, password);

        // TODO 登录业务有bug
        // 登录失败
        if (tbUserDomain == null) {
            redirectAttributes.addFlashAttribute(ConstantUtils.WEB_MESSAGE,ConstantUtils.MESSAGE_ERROR);
            return "redirect:/login";
        }   else {  // 登录成功
            // 将登录信息放入会话

            request.getSession().setAttribute(ConstantUtils.SESSION_USER,tbUserDomain);

            //重定向到首页
            return "redirect:/main";
        }


    // TODO 做完这个项目后，把maven笔记完善一下
    }


    @GetMapping(value = "logout")
    public String logout(HttpServletRequest request)  {
        request.getSession().invalidate();
        return "login";
    }

    // TODO springboot 整合单元测试做一个笔记 ,spring 的不适用
}
