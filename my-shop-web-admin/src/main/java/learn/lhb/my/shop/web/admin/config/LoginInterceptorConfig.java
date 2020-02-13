package learn.lhb.my.shop.web.admin.config;

import learn.lhb.my.shop.web.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static");
    }
}
