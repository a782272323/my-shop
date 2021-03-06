package learn.lhb.my.shop.web.admin.interceptor;

import learn.lhb.my.shop.commons.constant.ConstantUtils;
import learn.lhb.my.shop.domain.TbUserDomain;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @author 梁鸿斌
 * @date 2020/2/14.
 * @time 00:48
 */
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    // TODO 拦截器用法做个笔记


    // 未登录
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TbUserDomain tbUserDomain = (TbUserDomain) request.getSession().getAttribute(ConstantUtils.SESSION_USER);

        // TODO 登录拦截那些逻辑未解决,要先登录一次才能拦截，若把会话全清了，或者新的浏览器打开，会进入死循环
        // 未登录
        if (tbUserDomain == null)   {
//            tbUserDomain.setEmail("x");
            response.sendRedirect("/login");

        }

        // return 为false下面的方法就进不去了
        return true;

//        if (tbUserDomain == null | tbUserDomain.equals("")) {
//            request.getRequestDispatcher("/login.html").forward(request,response);
//            return false;
//        } else {
//            return true;
//        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


//        //以 login 结尾的请求
//        // TODO model,modelMap,modelAndView 用法补完全一点
//        if (modelAndView.getViewName().endsWith("login"))   {
//            TbUserDomain tbUserDomain = (TbUserDomain) request.getSession().getAttribute(ConstantUtils.SESSION_USER);
//            if (tbUserDomain != null) {
//                response.sendRedirect("/main");
//            }
//        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
