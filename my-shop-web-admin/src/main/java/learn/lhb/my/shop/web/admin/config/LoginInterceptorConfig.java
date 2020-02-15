package learn.lhb.my.shop.web.admin.config;

import learn.lhb.my.shop.web.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 登录拦截器配置
 *
 * @author 梁鸿斌
 * @date 2020/2/14.
 * @time 02:31
 */
// TODO 有个springboot 拦截器做一个 笔记
@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {

    // TODO 把这个笔记完善到 springboot到拦截器里去
    // TODO 有条件的话，把WebMvcConfigurer源码读懂

    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor())
                // 拦截路径
                .addPathPatterns("/**")
                // 排除路径
                .excludePathPatterns("/login")
                .excludePathPatterns("/logout")
                .excludePathPatterns("/static/**")
//                .excludePathPatterns("/bower_components/**","/dist/**","/plugins/**","/assets/**")
        ;


//        // 注册拦截器
//        LoginInterceptor loginInterceptor = new LoginInterceptor();
//        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
//        //拦截路径
//        loginRegistry.addPathPatterns("/**");
//        //排除路径
//        loginRegistry.excludePathPatterns("/login");
//        loginRegistry.excludePathPatterns("/logout");
//        loginRegistry.excludePathPatterns("/static");
    }


//    /**
//     * 配置静态资源文件路径
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static");
//
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//    }
}
