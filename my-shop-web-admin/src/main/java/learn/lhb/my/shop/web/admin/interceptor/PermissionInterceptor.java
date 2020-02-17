package learn.lhb.my.shop.web.admin.interceptor;

import learn.lhb.my.shop.commons.constant.ConstantUtils;
import learn.lhb.my.shop.domain.TbUserDomain;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 *
 * @author 梁鸿斌
 * @date 2020/2/14.
 * @time 00:56
 */
@Configuration
public class PermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        //以 login 结尾的请求
        // TODO model,modelMap,modelAndView 用法补完全一点
        if (modelAndView != null && modelAndView.getViewName() != null && modelAndView.getViewName().endsWith("login"))   {
            TbUserDomain tbUserDomain = (TbUserDomain) request.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if (tbUserDomain != null) {
                response.sendRedirect("/main");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
